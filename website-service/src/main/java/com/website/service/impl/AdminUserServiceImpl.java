package com.website.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.website.common.util.bean.ServiceResult;
import com.website.common.util.constants.ConstantsUtil;
import com.website.common.util.security.MD5Util;
import com.website.common.util.string.GetterUtil;
import com.website.mybatis.bean.auto.system.CMDepartment;
import com.website.mybatis.bean.auto.system.CMDepartmentExample;
import com.website.mybatis.bean.auto.system.CMDepartmentUser;
import com.website.mybatis.bean.auto.system.CMDepartmentUserExample;
import com.website.mybatis.bean.auto.system.CMUser;
import com.website.mybatis.bean.auto.system.CMUserCustom;
import com.website.mybatis.bean.auto.system.CMUserCustomExample;
import com.website.mybatis.bean.auto.system.CMUserExample;
import com.website.mybatis.bean.auto.system.CMUserRole;
import com.website.mybatis.bean.auto.system.CMUserRoleExample;
import com.website.mybatis.bean.ext.system.ExtUserModel;
import com.website.service.AdminUserService;
import com.website.service.maintenance.DepartmentService;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2016/8/2.
 */
@Service
public class AdminUserServiceImpl extends BaseServiceImpl implements AdminUserService {

    private static final String THIS_CLASS = AdminUserServiceImpl.class.getName();

    private static final Logger logger = LoggerFactory.getLogger(AdminUserServiceImpl.class);

    @Autowired
    private DepartmentService departmentService;
    
    /**
     * 取得查询条件
     *
     * @param form
     * @return
     */
    private ExtUserModel getExample(ExtUserModel form) {
        // 查询条件：部门
        String ids = form.getIds();
        List<String> listId = new ArrayList<>();
        if (org.apache.commons.lang.StringUtils.isNotBlank(ids)) {
            listId = JSONArray.parseArray(StringEscapeUtils.unescapeHtml4(ids), String.class);
        }
        form.setListDepartmentCd(listId);

        String orderByClause;
        if (StringUtils.isBlank(form.getSort())) {
            orderByClause = "u.create_date ";
        } else {
            orderByClause = formatOrder(form.getSort(), form.getOrder());
        }
        // 设置排序
        form.setOrderByClause(orderByClause);
        return form;
    }

    /**
     * 获取公告件数
     *
     * @return
     */
    public ServiceResult<Integer> getRecordListSize(ExtUserModel form) {
        ServiceResult<Integer> result = new ServiceResult<>();
        try {
            int cnt = this.extUserMapper.selectUserListCount(getExample(form));
            result.setResult(cnt);
            result.setSuccess(true);
        } catch (Exception e) {
            logger.error(THIS_CLASS, "getRecordListSize", e.getMessage(), e);
            result.setError(e.getMessage());
        }
        return result;
    }

    /**
     * 获取公告列表
     *
     * @return
     */
    public ServiceResult<List<ExtUserModel>> getRecordList(ExtUserModel form) {
        ServiceResult<List<ExtUserModel>> result = new ServiceResult<>();

        try {
            List<ExtUserModel> list = this.extUserMapper.selectUserList(getExample(form));

            result.setResult(list);
            result.setSuccess(true);
        } catch (Exception e) {
            logger.error(THIS_CLASS, "getRecordList", e.getMessage(), e);
            result.setError(e.getMessage());
        }
        return result;
    }

    /**
     * 获取公告列表
     *
     * @return
     */
    public ServiceResult<ExtUserModel> getRecord(ExtUserModel form) {
        ServiceResult<ExtUserModel> result = new ServiceResult<>();

        try {
            ExtUserModel record = this.extUserMapper.selectUserById(form.getUserId());
            //获取用户部门关系
            CMDepartmentUserExample cmDepartmentUserExample = new CMDepartmentUserExample();
            cmDepartmentUserExample.createCriteria().andUserIdEqualTo(record.getUserId());
            record.setUserDepartmentList(this.cmDepartmentUserMapper.selectByExample(cmDepartmentUserExample));
            //获取用户客户关系
            CMUserCustomExample cmUserCustomExample = new CMUserCustomExample();
            cmUserCustomExample.createCriteria().andUserIdEqualTo(record.getUserId());
            record.setUserCustomList(this.cmUserCustomMapper.selectByExample(cmUserCustomExample));

            result.setResult(record);
            result.setSuccess(true);
        } catch (Exception e) {
            logger.error(THIS_CLASS, "getRecord", e.getMessage(), e);
            result.setError(e.getMessage());
        }
        return result;
    }

    @Override
    public ServiceResult<CMUser> insertRecord(ExtUserModel record) {
        ServiceResult<CMUser> result = new ServiceResult<>();

        CMUser doc = new CMUser();
        String userId = UUID.randomUUID().toString();
        BeanUtils.copyProperties(record, doc);
        doc.setUserId(userId);
        doc.setPassword(MD5Util.string2MD5("a123456"));
        doc.setDelFlag(ConstantsUtil.FLG_NORMAL);
        doc.setCreateGroupCd(record.getCreateGroupCd());
        doc.setCreateUserCd(record.getCreateUserCd());
        doc.setCreateDate(record.getCreateDate());
        doc.setUpdateGroupCd(record.getUpdateGroupCd());
        doc.setUpdateUserCd(record.getUpdateUserCd());
        doc.setUpdateDate(record.getUpdateDate());
        doc.setIsAgreeAgreement("1");//同意用户协议(0：同意，1：不同意)

        //清空部门用户关联表
        CMDepartmentUserExample departmentExample = new CMDepartmentUserExample();
        departmentExample.createCriteria().andUserIdEqualTo(userId);
        this.cmDepartmentUserMapper.deleteByExample(departmentExample);
        if (record.getListDepartmentCd()!=null && record.getListDepartmentCd().size()>0) {
            // 更新部门用户关联表
        	for(String departmentCd : record.getListDepartmentCd()){
        		CMDepartmentUser cmDepartmentUser = new CMDepartmentUser();
                cmDepartmentUser.setUserId(userId);
                cmDepartmentUser.setDepartmentCd(departmentCd);
                cmDepartmentUser.setDelFlag(ConstantsUtil.FLG_NORMAL);
                cmDepartmentUser.setCreateGroupCd(record.getCreateGroupCd());
                cmDepartmentUser.setCreateUserCd(record.getCreateUserCd());
                cmDepartmentUser.setCreateDate(record.getCreateDate());
                cmDepartmentUser.setUpdateGroupCd(record.getUpdateGroupCd());
                cmDepartmentUser.setUpdateUserCd(record.getUpdateUserCd());
                cmDepartmentUser.setUpdateDate(record.getUpdateDate());
                this.cmDepartmentUserMapper.insertSelective(cmDepartmentUser);
        	}
        }
        boolean userType = false;
        if (StringUtils.isNotBlank(record.getCustomType())) {
            String[] customTypes = record.getCustomType().split(",");
            CMUserCustomExample cmUserCustomExample = new CMUserCustomExample();
            cmUserCustomExample.createCriteria().andUserIdEqualTo(userId);
            this.cmUserCustomMapper.deleteByExample(cmUserCustomExample);
            if (customTypes != null && customTypes.length > 0) {
                for (String customType : customTypes) {
                    if (StringUtils.isNotEmpty(customType)) {
                        if ("0".equals(customType)) {
                            userType = true;
                        } else {
                            CMUserCustom cmUserCustom = new CMUserCustom();
                            cmUserCustom.setId(UUID.randomUUID().toString());
                            cmUserCustom.setCustomType(customType);
                            cmUserCustom.setUserId(userId);
                            this.cmUserCustomMapper.insert(cmUserCustom);
                        }
                    }
                }
            }
        }
        if (userType) {
            doc.setUserType("0");
        } else {
            doc.setUserType("1");
        }
        int cnt = this.cmUserMapper.insert(doc);

        // 插入用户权限
        if (StringUtils.isNotBlank(record.getRoleId())) {
            CMUserRole userRole = new CMUserRole();
            userRole.setUserId(userId);
            userRole.setRoleId(record.getRoleId());
            userRole.setDelFlag(ConstantsUtil.FLG_NORMAL);
            userRole.setCreateGroupCd(record.getCreateGroupCd());
            userRole.setCreateUserCd(record.getCreateUserCd());
            userRole.setCreateDate(record.getCreateDate());
            userRole.setUpdateGroupCd(record.getUpdateGroupCd());
            userRole.setUpdateUserCd(record.getUpdateUserCd());
            userRole.setUpdateDate(record.getUpdateDate());
            this.cmUserRoleMapper.insertSelective(userRole);
        }

        result.setResult(doc);
        result.setSuccess(true);

        return result;
    }

    @Override
    public ServiceResult<CMUser> updateRecord(ExtUserModel record) {
        ServiceResult<CMUser> result = new ServiceResult<>();

        CMUser doc = new CMUser();
        BeanUtils.copyProperties(record, doc);
        doc.setUserSortKey(GetterUtil.getInteger(record.getUserSortKey()));
        doc.setDelFlag(ConstantsUtil.FLG_NORMAL);
        doc.setUpdateGroupCd(record.getUpdateGroupCd());
        doc.setUpdateUserCd(record.getUpdateUserCd());
        doc.setUpdateDate(record.getUpdateDate());

        //清空部门用户关联表
        CMDepartmentUserExample departmentExample = new CMDepartmentUserExample();
        departmentExample.createCriteria().andUserIdEqualTo(record.getUserId());
        this.cmDepartmentUserMapper.deleteByExample(departmentExample);
        if (record.getListDepartmentCd()!=null && record.getListDepartmentCd().size()>0) {
            // 更新部门用户关联表
        	for(String departmentCd : record.getListDepartmentCd()){
        		CMDepartmentUser cmDepartmentUser = new CMDepartmentUser();
                cmDepartmentUser.setUserId(record.getUserId());
                cmDepartmentUser.setDepartmentCd(departmentCd);
                cmDepartmentUser.setDelFlag(ConstantsUtil.FLG_NORMAL);
                cmDepartmentUser.setCreateGroupCd(record.getCreateGroupCd());
                cmDepartmentUser.setCreateUserCd(record.getCreateUserCd());
                cmDepartmentUser.setCreateDate(record.getCreateDate());
                cmDepartmentUser.setUpdateGroupCd(record.getUpdateGroupCd());
                cmDepartmentUser.setUpdateUserCd(record.getUpdateUserCd());
                cmDepartmentUser.setUpdateDate(record.getUpdateDate());
                this.cmDepartmentUserMapper.insertSelective(cmDepartmentUser);
        	}
        }

        boolean userType = false;
        if (StringUtils.isNotBlank(record.getCustomType())) {
            String[] customTypes = record.getCustomType().split(",");
            CMUserCustomExample cmUserCustomExample = new CMUserCustomExample();
            cmUserCustomExample.createCriteria().andUserIdEqualTo(record.getUserId());
            this.cmUserCustomMapper.deleteByExample(cmUserCustomExample);
            if (customTypes != null && customTypes.length > 0) {
                for (String customType : customTypes) {
                    if (StringUtils.isNotEmpty(customType)) {
                        if ("0".equals(customType)) {
                            userType = true;
                        } else {
                            CMUserCustom cmUserCustom = new CMUserCustom();
                            cmUserCustom.setId(UUID.randomUUID().toString());
                            cmUserCustom.setCustomType(customType);
                            cmUserCustom.setUserId(record.getUserId());
                            this.cmUserCustomMapper.insert(cmUserCustom);
                        }
                    }
                }
            }
        }
        if (userType) {
            doc.setUserType("0");
        } else {
            doc.setUserType("1");
        }
        int cnt = this.cmUserMapper.updateByPrimaryKeySelective(doc);
        // 更新用户权限
        if (StringUtils.isNotBlank(record.getRoleId())) {
            CMUserRoleExample userRoleExample = new CMUserRoleExample();
            userRoleExample.createCriteria().andUserIdEqualTo(record.getUserId());
            int roleCnt = this.cmUserRoleMapper.countByExample(userRoleExample);
            if (roleCnt == 0) {
                CMUserRole userRole = new CMUserRole();
                userRole.setUserId(record.getUserId());
                userRole.setRoleId(record.getRoleId());
                userRole.setDelFlag(ConstantsUtil.FLG_NORMAL);
                userRole.setCreateGroupCd(record.getCreateGroupCd());
                userRole.setCreateUserCd(record.getCreateUserCd());
                userRole.setCreateDate(record.getCreateDate());
                userRole.setUpdateGroupCd(record.getUpdateGroupCd());
                userRole.setUpdateUserCd(record.getUpdateUserCd());
                userRole.setUpdateDate(record.getUpdateDate());
                this.cmUserRoleMapper.insertSelective(userRole);
            } else {
                CMUserRole userRole = new CMUserRole();
                userRole.setRoleId(record.getRoleId());
                userRole.setDelFlag(ConstantsUtil.FLG_NORMAL);
                userRole.setUpdateGroupCd(record.getUpdateGroupCd());
                userRole.setUpdateUserCd(record.getUpdateUserCd());
                userRole.setUpdateDate(record.getUpdateDate());
                this.cmUserRoleMapper.updateByExampleSelective(userRole, userRoleExample);
            }
        }

        result.setResult(doc);
        result.setSuccess(true);
        return result;
    }

    @Override
    public ServiceResult<CMUser> deleteRecord(ExtUserModel record) {
        ServiceResult<CMUser> result = new ServiceResult<>();

        // 更新用户
        CMUser doc = new CMUser();
        doc.setUserId(record.getUserId());
        doc.setDelFlag(ConstantsUtil.FLG_DELETE);
        doc.setUpdateGroupCd(record.getUpdateGroupCd());
        doc.setUpdateUserCd(record.getUpdateUserCd());
        doc.setUpdateDate(record.getUpdateDate());
        int cnt = this.cmUserMapper.updateByPrimaryKeySelective(doc);
        if (cnt > 0) {
            // 删除部门用户关联表
            CMDepartmentUserExample departmentExample = new CMDepartmentUserExample();
            departmentExample.createCriteria().andUserIdEqualTo(record.getUserId());
            CMDepartmentUser cmDepartmentUser = new CMDepartmentUser();
            cmDepartmentUser.setDelFlag(ConstantsUtil.FLG_DELETE);
            this.cmDepartmentUserMapper.updateByExampleSelective(cmDepartmentUser, departmentExample);

            // 更新用户权限
            if (StringUtils.isNotBlank(record.getRoleId())) {
                CMUserRoleExample userRoleExample = new CMUserRoleExample();
                userRoleExample.createCriteria().andUserIdEqualTo(record.getUserId());
                CMUserRole userRole = new CMUserRole();
                userRole.setDelFlag(ConstantsUtil.FLG_DELETE);
                userRole.setDelFlag(ConstantsUtil.FLG_NORMAL);
                this.cmUserRoleMapper.updateByExampleSelective(userRole, userRoleExample);
            }

            result.setResult(doc);
            result.setSuccess(true);
        } else {
            result.setSuccess(false);
        }
        return result;
    }

    /**
     * 查询数据
     *
     * @param record
     */
    public ServiceResult<List<CMUser>> selectByExample(ExtUserModel record) {
        ServiceResult<List<CMUser>> result = new ServiceResult<>();

        try {
            // 更新用户
            CMUserExample example = new CMUserExample();
            CMUserExample.Criteria criteria = example.createCriteria();
            criteria.andDelFlagEqualTo(ConstantsUtil.FLG_NORMAL);
            if (StringUtils.isNotBlank(record.getUserId())) {
                criteria.andUserIdEqualTo(record.getUserId());
            }
            if (StringUtils.isNotBlank(record.getUserName())) {
                criteria.andUserNameEqualTo(record.getUserName());
            }
            if (StringUtils.isNotBlank(record.getMobileNumber())) {
                criteria.andMobileNumberEqualTo(record.getMobileNumber());
            }
            if (StringUtils.isNotBlank(record.getEmailAddress())) {
                criteria.andEmailAddressEqualTo(record.getEmailAddress());
            }

            List<CMUser> list = this.cmUserMapper.selectByExample(example);
            result.setResult(list);
            result.setSuccess(true);
        } catch (Exception e) {
            logger.error(THIS_CLASS, "deleteRecord", e.getMessage(), e);
            result.setError(e.getMessage());
        }
        return result;
    }

    @Override
    public ServiceResult<CMUser> updatePassword(ExtUserModel record) {
        ServiceResult<CMUser> result = new ServiceResult<>();

        CMUser doc = new CMUser();
        doc.setUserId(record.getUserId());
        doc.setPassword(MD5Util.string2MD5(record.getPassword()));
        doc.setUserSortKey(GetterUtil.getInteger(record.getUserSortKey()));
        doc.setDelFlag(ConstantsUtil.FLG_NORMAL);
        doc.setUpdateGroupCd(record.getUpdateGroupCd());
        doc.setUpdateUserCd(record.getUpdateUserCd());
        doc.setUpdateDate(record.getUpdateDate());
        int cnt = this.cmUserMapper.updateByPrimaryKeySelective(doc);
        if (cnt > 0) {
            result.setResult(doc);
            result.setSuccess(true);
        } else {
            result.setSuccess(false);
        }
        return result;
    }

    /**
     * 获取分配的人员
     *
     * @param record
     * @return
     */
    public ServiceResult<List<ExtUserModel>> selectInviteUserList(ExtUserModel record) {
        ServiceResult<List<ExtUserModel>> serviceResult = new ServiceResult<List<ExtUserModel>>();
        List<ExtUserModel> userModelList = this.extUserMapper.selectInviteUserList(record);
        serviceResult.setResult(userModelList);
        serviceResult.setSuccess(true);
        return serviceResult;
    }

    /**
     * 获取登录用户的登录部门以及所管辖的地区
     * user_type 为 1：属于最高的部门，为2属于最低级的部门
     *
     * @param record
     * @return
     */
    public ServiceResult<List<ExtUserModel>> selectLoginUserDepartment(ExtUserModel record) {
        ServiceResult<List<ExtUserModel>> serviceResult = new ServiceResult<List<ExtUserModel>>();
        serviceResult.setResult(this.extUserMapper.selectLoginUserDepartment(record));
        serviceResult.setSuccess(true);
        return serviceResult;
    }


    /**
     * 获取部门关联的省市区
     *
     * @param userId
     * @return
     */
    public ServiceResult<List<CMDepartment>> getDepartmentAreaList(String userId) {
        ServiceResult<List<CMDepartment>> serviceResult = new ServiceResult<List<CMDepartment>>();
        CMDepartmentUserExample departmentUserExample = new CMDepartmentUserExample();
        CMDepartmentUserExample.Criteria userCriteria = departmentUserExample.createCriteria();
        userCriteria.andUserIdEqualTo(userId);
        List<CMDepartmentUser> departmentUserList = this.cmDepartmentUserMapper.selectByExample(departmentUserExample);

        List<String> departmentCdList = new ArrayList<>();
        if (departmentUserList != null && departmentUserList.size() > 0) {
            for (CMDepartmentUser departmentUser : departmentUserList) {
                departmentCdList.add(departmentUser.getDepartmentCd());
            }
            CMDepartmentExample departmentExample = new CMDepartmentExample();
            CMDepartmentExample.Criteria criteria = departmentExample.createCriteria();
            criteria.andDepartmentCdIn(departmentCdList);
            serviceResult.setResult(this.cmDepartmentMapper.selectByExample(departmentExample));
        }
        serviceResult.setSuccess(true);
        return serviceResult;
    }

    /**
     * 获取省列表
     *
     * @return
     */
    public ServiceResult<List<CMDepartment>> getProvince() {
        ServiceResult<List<CMDepartment>> serviceResult = new ServiceResult<List<CMDepartment>>();
        CMDepartmentExample cmDepartmentExample = new CMDepartmentExample();
        CMDepartmentExample.Criteria criteria = cmDepartmentExample.createCriteria();
        criteria.andDepartmentPCdEqualTo(ConstantsUtil.TREE_TOP);
        List<CMDepartment> departmentList = this.cmDepartmentMapper.selectByExample(cmDepartmentExample);
        serviceResult.setSuccess(true);
        serviceResult.setResult(departmentList);
        return serviceResult;
    }


    /**
     * 获取市列表
     *
     * @param code
     * @return
     */
    public ServiceResult<List<CMDepartment>> getCity(String code) {
        ServiceResult<List<CMDepartment>> serviceResult = new ServiceResult<List<CMDepartment>>();
        CMDepartmentExample cmDepartmentExample = new CMDepartmentExample();
        CMDepartmentExample.Criteria criteria = cmDepartmentExample.createCriteria();
        criteria.andDepartmentPCdEqualTo(code);
        List<CMDepartment> departmentList = this.cmDepartmentMapper.selectByExample(cmDepartmentExample);
        serviceResult.setSuccess(true);
        serviceResult.setResult(departmentList);
        return serviceResult;
    }

    /**
     * 获取用户列表
     *
     * @return
     */
    public ServiceResult<List<CMUser>> getUserListByExample(ExtUserModel form) {
        ServiceResult<List<CMUser>> result = new ServiceResult<>();
        CMUserExample example = new CMUserExample();
        CMUserExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(form.getUserName())) {
            criteria.andUserNameEqualTo(form.getUserName());
        }
        if (StringUtils.isNotBlank(form.getDelFlag())) {
            criteria.andDelFlagEqualTo(form.getDelFlag());
        }

        List<CMUser> list = this.cmUserMapper.selectByExample(example);

        result.setResult(list);
        result.setSuccess(true);
        return result;
    }

    /**
     * 根据用户信息获取该用户下关联的部门关系模型
     * @param form
     * @return
     */
	@Override
	public List<List<CMDepartment>> getDepartmentModelByUser(ExtUserModel form) {
		List<List<CMDepartment>> objectList = new ArrayList<List<CMDepartment>>();
		if(StringUtils.isNotEmpty(form.getUserId())){
			//获取用户部门关联关系信息列表数据
			// 更新部门用户关联表
            CMDepartmentUserExample departmentUserExample = new CMDepartmentUserExample();
            departmentUserExample.createCriteria().andUserIdEqualTo(form.getUserId());
            List<CMDepartmentUser> departmentUserList = this.cmDepartmentUserMapper.selectByExample(departmentUserExample);
            if(departmentUserList!=null && departmentUserList.size()>0){
            	for(CMDepartmentUser departmentUser : departmentUserList){
            		if(StringUtils.isNotEmpty(departmentUser.getDepartmentCd())){
            			//获取该用户部门层级列表数据
            			List<CMDepartment> cmDepartmentList = this.departmentService.getDepartmentParentsList(new ArrayList<CMDepartment>(), departmentUser.getDepartmentCd());
            			objectList.add(cmDepartmentList);
            		}
            	}
            }else{
            	return objectList;
            }
		}
		return objectList;
	}
}