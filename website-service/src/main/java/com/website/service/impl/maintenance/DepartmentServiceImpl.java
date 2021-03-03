package com.website.service.impl.maintenance;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.StringUtil;
import com.website.common.util.bean.ServiceResult;
import com.website.common.util.constants.ConstantsUtil;
import com.website.common.util.date.DateUtils;
import com.website.common.util.session.LoginUserInfo;
import com.website.common.util.session.SessionUtils;
import com.website.common.util.string.GetterUtil;
import com.website.mybatis.bean.auto.system.CMDepartment;
import com.website.mybatis.bean.auto.system.CMDepartmentExample;
import com.website.mybatis.bean.auto.system.CMDepartmentUser;
import com.website.mybatis.bean.auto.system.CMDepartmentUserExample;
import com.website.mybatis.bean.auto.system.CMMenuExample;
import com.website.mybatis.bean.ext.system.AdminMenuBean;
import com.website.mybatis.bean.ext.system.ExtDepartmentModel;
import com.website.service.impl.BaseServiceImpl;
import com.website.service.maintenance.DepartmentService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DepartmentServiceImpl extends BaseServiceImpl implements DepartmentService {
    private static final String THIS_CLASS = DepartmentServiceImpl.class.getName();

    /**
     * 获取菜单列表
     *
     * @return
     */
    public ServiceResult<JSONArray> getRecordList(AdminMenuBean form) {
        ServiceResult<JSONArray> result = new ServiceResult<>();
        List<ExtDepartmentModel> leftDepartmentList = this.extDepartmentMapper.selectDepartment(new ExtDepartmentModel());

        Map<String, String> map = new HashMap<String, String>();
        map.put(ConstantsUtil.TREE_TOP, "联信集团");
        if (leftDepartmentList != null && leftDepartmentList.size() > 0) {
            for (ExtDepartmentModel adminDepartment : leftDepartmentList) {
                map.put(adminDepartment.getDepartmentCd() + "", adminDepartment.getDepartmentName());
            }
        }

        String selectedNode = form.getSelectedNode();
        JSONArray array = this.treeDepartmentList(leftDepartmentList, map, selectedNode, ConstantsUtil.TREE_TOP, 1);

        JSONArray treeArray = new JSONArray();
        JSONObject jo = new JSONObject();
        jo.put("id", ConstantsUtil.TREE_TOP);
        jo.put("text", "联信集团");
        jo.put("icon", "fa fa-institution");
        jo.put("children", array);
        JSONObject joAttr = new JSONObject();
        joAttr.put("contextmenu", "create_menu");
        joAttr.put("departmentCd", ConstantsUtil.TREE_TOP);
        jo.put("li_attr", joAttr);
        treeArray.add(jo);
        result.setResult(treeArray);
        result.setSuccess(true);
        return result;
    }


    /**
     * 获取菜单列表
     *
     * @return
     */
    public ServiceResult<JSONArray> getRecordListWithUserCnt(AdminMenuBean form) {
        ServiceResult<JSONArray> result = new ServiceResult<>();
        List<ExtDepartmentModel> leftDepartmentList = this.extDepartmentMapper.selectDepartmentWithUserCnt(new ExtDepartmentModel());

        Map<String, String> map = new HashMap<String, String>();
        if (leftDepartmentList != null && leftDepartmentList.size() > 0) {
            for (ExtDepartmentModel adminDepartment : leftDepartmentList) {
                map.put(adminDepartment.getDepartmentCd() + "", adminDepartment.getDepartmentName());
            }
        }

        String selectedNode = form.getSelectedNode();
        JSONArray array = this.treeDepartmentList(leftDepartmentList, map, selectedNode, ConstantsUtil.TREE_TOP, 1);

        if (array != null && array.size() > 0) {
            getUserCnt(array);
        }

        result.setResult(array);
        result.setSuccess(true);
        return result;
    }

    private int getUserCnt(JSONArray array) {
        int userCnt = 0;
        if (array != null && array.size() > 0) {
            for (int i = 0; i < array.size(); i++) {
                int subCnt = 0;
                JSONObject jo = array.getJSONObject(i);
                if (jo.containsKey("li_attr")) {
                    subCnt += jo.getJSONObject("li_attr").getIntValue("userCnt");
                }
                if (jo.containsKey("children")) {
                    subCnt += getUserCnt(jo.getJSONArray("children"));
                }
                jo.put("userCnt", subCnt);

                userCnt += subCnt;
            }
        }
        return userCnt;
    }
    
    /**
     * 获取部门
     *
     * @param param
     * @return
     */
    @Override
	public ServiceResult<List<ExtDepartmentModel>> selectDepartment(ExtDepartmentModel param) {
        ServiceResult<List<ExtDepartmentModel>> result = new ServiceResult<List<ExtDepartmentModel>>();
		if(param!=null){
			List<ExtDepartmentModel> records = this.extDepartmentMapper.selectDepartment(param);
			if(records!=null && records.size()>0){
				result.setResult(records);
				result.setSuccess(true);
			}
		}
		return result;
	}

    /**
     * 获取菜单
     *
     * @param id
     * @return
     */
    @Override
    public ServiceResult<ExtDepartmentModel> getRecord(String id) {
        ServiceResult<ExtDepartmentModel> result = new ServiceResult<ExtDepartmentModel>();
        ExtDepartmentModel model = new ExtDepartmentModel();
        model.setId(id);
        List<ExtDepartmentModel> records = this.extDepartmentMapper.selectDepartment(model);
        if (records != null && records.size() > 0) {
            List<String> ids = new ArrayList<>();
            ids.add(records.get(0).getDepartmentCd());
            result.setResult(records.get(0));
        }
        result.setSuccess(true);
        return result;
    }

	/**
     * 菜单树形结构
     *
     * @param DepartmentTreeDBList
     * @param topParentDepartmentCd
     * @return
     */
    public JSONArray treeDepartmentList(List<ExtDepartmentModel> DepartmentTreeDBList, Map<String, String> map, String selectedNode, String topParentDepartmentCd, int index) {
        JSONArray ja = new JSONArray();
        JSONObject joAttr = new JSONObject();
        if (DepartmentTreeDBList != null && DepartmentTreeDBList.size() > 0) {
            JSONObject jo = null;
            for (ExtDepartmentModel departmentTreeRecord : DepartmentTreeDBList) {
                jo = new JSONObject();
                jo.put("id", departmentTreeRecord.getId());
                jo.put("text", departmentTreeRecord.getDepartmentName());
                joAttr = new JSONObject();
                joAttr.put("departmentCd", departmentTreeRecord.getDepartmentCd());
                joAttr.put("departmentPCd", departmentTreeRecord.getDepartmentPCd());
                joAttr.put("departmentName", departmentTreeRecord.getDepartmentName());
                joAttr.put("departmentPName", map.get(departmentTreeRecord.getDepartmentPCd()));
                joAttr.put("sortKey", departmentTreeRecord.getSortKey());
                joAttr.put("status", departmentTreeRecord.getStatus());
                joAttr.put("delFlag", departmentTreeRecord.getDelFlag());
                joAttr.put("userCnt", GetterUtil.getInteger(departmentTreeRecord.getUserCnt()));
                joAttr.put("level", index);
                joAttr.put("contextmenu", "create_page");
                if (index == 4) {
                    joAttr.put("contextmenu", "modify_page");
                }
                jo.put("li_attr", joAttr);
                if (StringUtils.isNotBlank(selectedNode) && selectedNode.equals(departmentTreeRecord.getDepartmentCd())) {
                    JSONObject selectObj = new JSONObject();
                    selectObj.put("selected", true);
                    jo.put("state", selectObj);
                }

                String departmentCd = departmentTreeRecord.getDepartmentCd();
                String departmentPCd = departmentTreeRecord.getDepartmentPCd();
                if (topParentDepartmentCd.equals(departmentPCd)) {
                    JSONArray array = treeDepartmentList(DepartmentTreeDBList, map, selectedNode, departmentCd, index + 1);
                    jo.put("children", array);
                    ja.add(jo);
                }
            }
        }
        return ja;
    }

    /**
     * 根据菜单名称判断菜单中数据是否存在
     *
     * @return
     */
    public ServiceResult<Integer> isExistsRecord(String menuId, String menuName) {
        ServiceResult<Integer> result = new ServiceResult<>();

        int cnt = 0;
        CMMenuExample example = new CMMenuExample();
        CMMenuExample.Criteria cra = example.createCriteria();
        cra.andMenuNameEqualTo(menuName);
        if (StringUtils.isNotBlank(menuId)) {
            cra.andMenuIdNotEqualTo(menuId);
        }
        cnt = cmMenuMapper.countByExample(example);
        result.setResult(cnt);
        result.setSuccess(true);

        return result;
    }

    private ServiceResult<CMDepartment> checkParam(LoginUserInfo userInfo, ExtDepartmentModel record, boolean isUpdate) {
        ServiceResult<CMDepartment> result = new ServiceResult<>();
        if (StringUtils.isEmpty(record.getDepartmentName())) {
            result.setSuccess(false);
            result.setMessage("请输入部门名称");
            return result;
        }
        result.setSuccess(true);
        return result;
    }

    /**
     * 部门插入
     *
     * @param record
     */
    public ServiceResult<CMDepartment> insertRecord(LoginUserInfo userInfo, ExtDepartmentModel record) throws Exception {
        ServiceResult<CMDepartment> result = checkParam(userInfo, record, false);
        if (!result.getSuccess()) {
            return result;
        }

        CMDepartment department = new CMDepartment();
        department.setSortKey(record.getSortKey());
        department.setDepartmentPCd(record.getDepartmentPCd());
        department.setDepartmentName(record.getDepartmentName());
        department.setDepartmentCd(UUID.randomUUID().toString());
        if (!StringUtils.equals(record.getDelFlag(), "1")) {
            department.setDelFlag(ConstantsUtil.FLG_NORMAL);
        } else {
            department.setDelFlag(ConstantsUtil.FLG_DELETE);
        }
        department.setCreateGroupCd(userInfo.getDepartmentId());
        department.setCreateUserCd(userInfo.getUserId());
        department.setCreateDate(DateUtils.getNowServerDateTime());
        department.setUpdateGroupCd(userInfo.getDepartmentId());
        department.setUpdateUserCd(userInfo.getUserId());
        department.setUpdateDate(DateUtils.getNowServerDateTime());
        cmDepartmentMapper.insert(department);
        // 插入图片
        record.setDepartmentCd(department.getDepartmentCd());

        CMDepartmentExample example = new CMDepartmentExample();
        CMDepartmentExample.Criteria criteria = example.createCriteria();
        criteria.andDepartmentCdEqualTo(department.getDepartmentCd());

        result.setResult(this.cmDepartmentMapper.selectByExample(example).get(0));
        result.setSuccess(true);
        return result;
    }

    /**
     * 菜单更新
     *
     * @param record
     */
    public ServiceResult<CMDepartment> updateRecord(LoginUserInfo userInfo, ExtDepartmentModel record) throws Exception {
        ServiceResult<CMDepartment> result = checkParam(userInfo, record, true);
        if (!result.getSuccess()) {
            return result;
        }

        CMDepartment department = new CMDepartment();
        department.setSortKey(record.getSortKey());
        department.setId(Integer.valueOf(record.getId()));
        department.setDepartmentPCd(record.getDepartmentPCd());
        department.setDepartmentName(record.getDepartmentName());
        department.setDepartmentCd(record.getDepartmentCd());
        department.setStatus(ConstantsUtil.FLG_NORMAL);

        if (!StringUtils.equals(record.getDelFlag(), "1")) {
            department.setDelFlag(ConstantsUtil.FLG_NORMAL);
        } else {
            department.setDelFlag(ConstantsUtil.FLG_DELETE);
        }
        department.setUpdateGroupCd(userInfo.getDepartmentId());
        department.setUpdateUserCd(userInfo.getUserId());
        department.setUpdateDate(DateUtils.getNowServerDateTime());
        cmDepartmentMapper.updateByPrimaryKeySelective(department);
        if(StringUtils.equals(record.getDelFlag(), "1")){
            this.updateDepartmentRecursive(userInfo, record);
        }
        result.setResult(department);
        result.setSuccess(true);
        return result;
    }

    /**
     * 递归删除父级及其子集的部门列表
     * @param userInfo
     * @param record
     */
    public void updateDepartmentRecursive(LoginUserInfo userInfo, ExtDepartmentModel record){
    	CMDepartmentExample example = new CMDepartmentExample();
        CMDepartmentExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotEmpty(record.getDepartmentCd())){
        	criteria.andDepartmentPCdEqualTo(record.getDepartmentCd());
        }
        List<CMDepartment> departmentList = this.cmDepartmentMapper.selectByExample(example);
        if(departmentList!=null && departmentList.size()>0){
        	CMDepartment department = new CMDepartment();
        	department.setStatus(ConstantsUtil.FLG_NORMAL);
            if (!StringUtils.equals(record.getDelFlag(), "1")) {
                department.setDelFlag(ConstantsUtil.FLG_NORMAL);
            } else {
                department.setDelFlag(ConstantsUtil.FLG_DELETE);
            }
            department.setUpdateGroupCd(userInfo.getDepartmentId());
            department.setUpdateUserCd(userInfo.getUserId());
            department.setUpdateDate(DateUtils.getNowServerDateTime());
            cmDepartmentMapper.updateByExampleSelective(department, example);
            for(CMDepartment departmentChil : departmentList){
            	ExtDepartmentModel recordChil = new ExtDepartmentModel();
            	recordChil.setDepartmentCd(departmentChil.getDepartmentCd());
            	recordChil.setDelFlag(record.getDelFlag());
        		updateDepartmentRecursive(userInfo, recordChil);
        	}
        }else{
        	return;
        }
    }
    
    /**
     * 获取部门的子菜单
     *
     * @param departmentCd
     * @return
     */
    @Override
    public ServiceResult<List<String>> getAllChildDepartment(String departmentCd) {
        ServiceResult<List<String>> result = new ServiceResult<>();
        if (StringUtils.isNotBlank(departmentCd)) {
            List<ExtDepartmentModel> leftDepartmentList = this.extDepartmentMapper.selectDepartment(new ExtDepartmentModel());

            List<String> childs = new ArrayList<>();

            Map<String, ExtDepartmentModel> map = new HashMap<String, ExtDepartmentModel>();
            if (leftDepartmentList != null && leftDepartmentList.size() > 0) {
                for (ExtDepartmentModel adminDepartment : leftDepartmentList) {
                    if (departmentCd.equals(adminDepartment.getDepartmentCd())) {
                        childs.add(adminDepartment.getId());
                    }
                    map.put(adminDepartment.getDepartmentCd() + "", adminDepartment);
                }
            }

            childs.addAll(getChildDepartment(map, departmentCd));

            result.setResult(childs);
            result.setSuccess(true);
        }

        return result;
    }

    private List<String> getChildDepartment(Map<String, ExtDepartmentModel> map, String departmentCd) {
        List<String> childs = new ArrayList<>();
        if (StringUtils.isNotBlank(departmentCd)) {

            ExtDepartmentModel adminDepartment = null;
            for (Map.Entry<String, ExtDepartmentModel> entry : map.entrySet()) {
                String key = entry.getKey();
                adminDepartment = entry.getValue();
                if (adminDepartment.getDepartmentPCd().equals(departmentCd)) {
                    if (!childs.contains(adminDepartment.getId())) {
                        childs.add(adminDepartment.getId());

                        List<String> subList = getChildDepartment(map, adminDepartment.getDepartmentCd());
                        if (subList != null) {
                            childs.addAll(subList);
                        } else {
                            break;
                        }
                    }
                }
            }
        }

        return childs;
    }

    /**
     * 获取用户所在的部门
     *
     * @param userId
     * @return
     */
    public ServiceResult<List<CMDepartmentUser>> getDepartmentListByUserId(String userId) {
        ServiceResult<List<CMDepartmentUser>> serviceResult = new ServiceResult<List<CMDepartmentUser>>();
        CMDepartmentUserExample departmentUserExample = new CMDepartmentUserExample();
        CMDepartmentUserExample.Criteria criteria = departmentUserExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        serviceResult.setSuccess(true);
        serviceResult.setResult(this.cmDepartmentUserMapper.selectByExample(departmentUserExample));
        return serviceResult;
    }


    /**
     * 获取登录用户所在的部门
     *
     * @return
     */
    public ServiceResult<List<String>> getLoginUserDepartmentList() {
        ServiceResult<List<String>> serviceResult = new ServiceResult<List<String>>();
        ServiceResult<List<CMDepartmentUser>> departmentList = this.getDepartmentListByUserId(SessionUtils.getLoginUserCd());
        List<String> listDepartmentCd = new ArrayList<>();
        if (departmentList.getResult() != null && departmentList.getResult().size() > 0) {
            for (CMDepartmentUser departmentUser : departmentList.getResult()) {
                listDepartmentCd.add(departmentUser.getDepartmentCd());
            }
        }
        serviceResult.setResult(listDepartmentCd);
        return serviceResult;
    }
    
    /**
     * 获取所有的分公司列表
     *
     * @return
     */
    @Override
    public List<CMDepartment> getBranchDepartmentList() {
        CMDepartmentExample example = new CMDepartmentExample();
        CMDepartmentExample.Criteria criteria = example.createCriteria();
        criteria.andDepartmentCdNotEqualTo(ConstantsUtil.DEPARTMENT_TOP);
        criteria.andDepartmentPCdEqualTo(ConstantsUtil.TREE_TOP);
        criteria.andDelFlagEqualTo(ConstantsUtil.FLG_NORMAL);
        return this.cmDepartmentMapper.selectByExample(example);
    }

    /**
     * 根据已知的部门ID获取该部门以及所有父级的列表数据,排序由低级部门向高级部门排序
     * @param new List, departmentCd
     * @return
     */
	@Override
	public List<CMDepartment> getDepartmentParentsList(List<CMDepartment> departmentList, String departmentCd) {
		if(StringUtils.isNotEmpty(departmentCd)){
			CMDepartmentExample example = new CMDepartmentExample();
	        CMDepartmentExample.Criteria criteria = example.createCriteria();
	        criteria.andDepartmentCdNotEqualTo(ConstantsUtil.DEPARTMENT_TOP);
	        criteria.andDepartmentCdEqualTo(departmentCd);
	        criteria.andDelFlagEqualTo(ConstantsUtil.FLG_NORMAL);
	        List<CMDepartment> cmdDepartmentList = this.cmDepartmentMapper.selectByExample(example);
	        if(cmdDepartmentList!=null && cmdDepartmentList.size()>0){
	        	CMDepartment department = cmdDepartmentList.get(0);
	        	departmentList.add(department);
	        	if(StringUtil.isNotEmpty(department.getDepartmentPCd())){
	        		getDepartmentParentsList(departmentList, department.getDepartmentPCd());
	        	}else{
	        		return departmentList;
	        	}
	        }else{
	        	return departmentList;
	        }
		}else{
			return departmentList;
		}
		return departmentList;
	}


	/**
	 *(non-Javadoc)
	 * <p>Title: selectDepartment</p>
	 * <p>Description: 获取国内催收中心下的各个分公司</p>
	 * @param departmentPCd
	 * @return
	 * @see com.lxhr.service.maintenance.DepartmentService#selectDepartment(java.lang.String)
	 */
	
	@Override
	public ServiceResult<JSONArray> selectDepartment(AdminMenuBean form, String departmentPCd) {
		ExtDepartmentModel param = new ExtDepartmentModel();
		param.setDepartmentPCd(departmentPCd);
		ServiceResult<JSONArray> result = new ServiceResult<>();
		
        List<ExtDepartmentModel> leftDepartmentList = this.extDepartmentMapper.selectDepartmentByDepartmentPCd(param);

        Map<String, String> map = new HashMap<String, String>();
        map.put(departmentPCd, "");
        if (leftDepartmentList != null && leftDepartmentList.size() > 0) {
            for (ExtDepartmentModel adminDepartment : leftDepartmentList) {
                map.put(adminDepartment.getDepartmentCd() + "", adminDepartment.getAreas());
            }
        }

        String selectedNode = form.getSelectedNode();
        JSONArray array = this.treeCityList(leftDepartmentList, map, selectedNode, departmentPCd, 1);

        JSONArray treeArray = new JSONArray();
        JSONObject jo = new JSONObject();
        jo.put("id", departmentPCd);
        jo.put("text", "");
        jo.put("icon", "fa fa-institution");
        jo.put("children", array);
        JSONObject joAttr = new JSONObject();
        joAttr.put("contextmenu", "create_menu");
        joAttr.put("departmentCd", ConstantsUtil.TREE_TOP);
        jo.put("li_attr", joAttr);
        treeArray.add(jo);
        result.setResult(treeArray);
        result.setSuccess(true);
        return result;
	}
	
	/**
     * 办公城市菜单树形结构
     *
     * @param DepartmentTreeDBList
     * @param topParentDepartmentCd
     * @return
     */
    public JSONArray treeCityList(List<ExtDepartmentModel> DepartmentTreeDBList, Map<String, String> map, String selectedNode, String topParentDepartmentCd, int index) {
        JSONArray ja = new JSONArray();
        JSONObject joAttr = new JSONObject();
        if (DepartmentTreeDBList != null && DepartmentTreeDBList.size() > 0) {
            JSONObject jo = null;
            for (ExtDepartmentModel departmentTreeRecord : DepartmentTreeDBList) {
                jo = new JSONObject();
                jo.put("id", departmentTreeRecord.getId());
                jo.put("text", departmentTreeRecord.getAreas());
                joAttr = new JSONObject();
                joAttr.put("departmentCd", departmentTreeRecord.getDepartmentCd());
                joAttr.put("departmentPCd", departmentTreeRecord.getDepartmentPCd());
                joAttr.put("areas", departmentTreeRecord.getAreas());
                joAttr.put("departmentPName", map.get(departmentTreeRecord.getDepartmentPCd()));
                joAttr.put("sortKey", departmentTreeRecord.getSortKey());
                joAttr.put("status", departmentTreeRecord.getStatus());
                joAttr.put("delFlag", departmentTreeRecord.getDelFlag());
                joAttr.put("userCnt", GetterUtil.getInteger(departmentTreeRecord.getUserCnt()));
                joAttr.put("level", index);
                joAttr.put("contextmenu", "create_page");
                if (index == 4) {
                    joAttr.put("contextmenu", "modify_page");
                }
                jo.put("li_attr", joAttr);
                if (StringUtils.isNotBlank(selectedNode) && selectedNode.equals(departmentTreeRecord.getDepartmentCd())) {
                    JSONObject selectObj = new JSONObject();
                    selectObj.put("selected", true);
                    jo.put("state", selectObj);
                }

                String departmentCd = departmentTreeRecord.getDepartmentCd();
                String departmentPCd = departmentTreeRecord.getDepartmentPCd();
                if (topParentDepartmentCd.equals(departmentPCd)) {
                    JSONArray array = treeDepartmentList(DepartmentTreeDBList, map, selectedNode, departmentCd, index + 1);
                    jo.put("children", array);
                    ja.add(jo);
                }
            }
        }
        return ja;
    }


	/**
	 *(non-Javadoc)
	 * <p>Title: selectCitys</p>
	 * <p>Description: 用一句话描述这个表示什么</p>
	 * @param departmentPCd
	 * @return
	 * @see com.website.service.maintenance.DepartmentService#selectCitys(java.lang.String)
	 */
	
	@Override
	public List<ExtDepartmentModel> selectCitys(String departmentPCd) {
		ExtDepartmentModel param = new ExtDepartmentModel();
		param.setDepartmentPCd(departmentPCd);
		List<ExtDepartmentModel> departmentList = this.extDepartmentMapper.selectDepartmentByDepartmentPCd(param);
		return departmentList;
	}
	
	@Override
	public ServiceResult<List<ExtDepartmentModel>> selectDepartmentRes(ExtDepartmentModel form, String departmentPCd) {
		ExtDepartmentModel param = new ExtDepartmentModel();
		param.setDepartmentPCd(departmentPCd);
		ServiceResult<List<ExtDepartmentModel>> result = new ServiceResult<>();
		
        List<ExtDepartmentModel> leftDepartmentList = this.extDepartmentMapper.selectDepartmentByDepartmentPCd(param);

        /*Map<String, String> map = new HashMap<String, String>();
        map.put(departmentPCd, "");
        if (leftDepartmentList != null && leftDepartmentList.size() > 0) {
            for (ExtDepartmentModel adminDepartment : leftDepartmentList) {
                map.put(adminDepartment.getDepartmentCd() + "", adminDepartment.getAreas());
            }
        }*/
        result.setResult(leftDepartmentList);
        return result;
	}

}
