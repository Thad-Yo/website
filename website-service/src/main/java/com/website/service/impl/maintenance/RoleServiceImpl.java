package com.website.service.impl.maintenance;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.website.common.util.bean.ServiceResult;
import com.website.common.util.constants.ConstantsUtil;
import com.website.common.util.date.DateUtils;
import com.website.common.util.session.LoginUserInfo;
import com.website.mybatis.bean.auto.system.CMRole;
import com.website.mybatis.bean.auto.system.CMRoleExample;
import com.website.mybatis.bean.auto.system.CMRoleMenuPermission;
import com.website.mybatis.bean.auto.system.CMRoleMenuPermissionExample;
import com.website.mybatis.bean.auto.system.CMUserRole;
import com.website.mybatis.bean.auto.system.CMUserRoleExample;
import com.website.mybatis.bean.ext.system.ExtRoleMenuPermissionModel;
import com.website.mybatis.bean.ext.system.ExtRoleModel;
import com.website.service.maintenance.RoleService;
import com.website.service.impl.BaseServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RoleServiceImpl extends BaseServiceImpl implements RoleService {
    private static final String THIS_CLASS = RoleServiceImpl.class.getName();

    /**
     * 获取角色列表
     *
     * @param record
     * @return
     */
    @Override
    public ServiceResult<List<CMRole>> getRoleList(ExtRoleModel record) {
        ServiceResult<List<CMRole>> result = new ServiceResult<>();
        CMRoleExample example = new CMRoleExample();
        CMRoleExample.Criteria criteria = example.createCriteria();
        criteria.andDelFlagEqualTo(ConstantsUtil.FLG_NORMAL);

        if (StringUtils.isNotEmpty(record.getRole())) {
            criteria.andRoleEqualTo(record.getRole());
        }
        if (StringUtils.isNotEmpty(record.getRoleName())) {
            criteria.andRoleNameLike("%" + record.getRoleName() + "%");
        }

        if (StringUtils.isNotEmpty(record.getSort())) {
            if (StringUtils.equals("roleName", record.getSort())) {
                record.setSort("role_name");
            }
            example.setOrderByClause(record.getSort() + " " + (record.getOrder() == null ? "" : record.getOrder()));
        }

        List<CMRole> roleList = this.cmRoleMapper.selectByExample(example);
        result.setResult(roleList);
        result.setSuccess(true);
        return result;
    }

    @Override
    public ServiceResult<Integer> countRoleByRole(String roleId, String role) {
        ServiceResult<Integer> result = new ServiceResult<>();
        int cnt = 0;
        if (StringUtils.isNotBlank(role)) {
            CMRoleExample example = new CMRoleExample();
            CMRoleExample.Criteria criteria = example.createCriteria();
            criteria.andDelFlagEqualTo(ConstantsUtil.FLG_NORMAL).andRoleEqualTo(role);
            if (StringUtils.isNotBlank(roleId)) {
                criteria.andRoleIdNotEqualTo(roleId);
            }
            cnt = this.cmRoleMapper.countByExample(example);
        }
        result.setResult(cnt);
        result.setSuccess(true);
        return result;
    }

    @Override
    public ServiceResult<CMRole> getRole(ExtRoleModel record) {
        ServiceResult<CMRole> result = new ServiceResult<>();
        result.setResult(this.cmRoleMapper.selectByPrimaryKey(record.getRoleId()));
        result.setSuccess(true);
        return result;
    }

    @Override
    public ServiceResult<CMRole> insertRecord(LoginUserInfo userInfo, ExtRoleModel record) {
        ServiceResult<CMRole> result = new ServiceResult<>();

        CMRole role = new CMRole();
        role.setRoleId(UUID.randomUUID().toString());
        role.setRoleName(record.getRoleName());
        role.setRole(record.getRole());
        role.setNote(record.getNote());
        role.setDelFlag(ConstantsUtil.FLG_NORMAL);

        role.setCreateGroupCd(userInfo.getDepartmentId());
        role.setCreateUserCd(userInfo.getUserId());
        role.setCreateDate(DateUtils.getNowServerDateTime());
        role.setUpdateGroupCd(userInfo.getDepartmentId());
        role.setUpdateUserCd(userInfo.getUserId());
        role.setUpdateDate(DateUtils.getNowServerDateTime());
        this.cmRoleMapper.insert(role);

        result.setResult(role);
        result.setSuccess(true);
        return result;
    }

    @Override
    public ServiceResult<CMRole> updateRecord(LoginUserInfo userInfo, ExtRoleModel record) {
        ServiceResult<CMRole> result = new ServiceResult<>();

        CMRole role = new CMRole();
        role.setRoleId(record.getRoleId());
        role.setRoleName(record.getRoleName());
        role.setRole(record.getRole());
        role.setNote(record.getNote());
        role.setDelFlag(ConstantsUtil.FLG_NORMAL);
        role.setUpdateGroupCd(userInfo.getDepartmentId());
        role.setUpdateUserCd(userInfo.getUserId());
        role.setUpdateDate(DateUtils.getNowServerDateTime());
        this.cmRoleMapper.updateByPrimaryKeySelective(role);

        result.setResult(role);
        result.setSuccess(true);
        return result;
    }

    @Override
    public ServiceResult<CMRole> deleteRecord(LoginUserInfo userInfo, ExtRoleModel record) {
        ServiceResult<CMRole> result = new ServiceResult<>();

        // 更新角色表
        CMRole role = new CMRole();
        role.setRoleId(record.getRoleId());
        role.setDelFlag(record.getDelFlag());
        role.setUpdateGroupCd(userInfo.getDepartmentId());
        role.setUpdateUserCd(userInfo.getUserId());
        role.setUpdateDate(DateUtils.getNowServerDateTime());
        this.cmRoleMapper.updateByPrimaryKeySelective(role);

        // 更新角色菜单关联表
        CMRoleMenuPermissionExample permissionExample = new CMRoleMenuPermissionExample();
        permissionExample.createCriteria().andRoleIdEqualTo(role.getRoleId());
        CMRoleMenuPermission permission = new CMRoleMenuPermission();
        permission.setDelFlag(record.getDelFlag());
        permission.setUpdateGroupCd(userInfo.getDepartmentId());
        permission.setUpdateUserCd(userInfo.getUserId());
        permission.setUpdateDate(DateUtils.getNowServerDateTime());
        this.cmRoleMenuPermissionMapper.updateByExampleSelective(permission, permissionExample);

        // 更新用户角色表
        CMUserRoleExample userRoleExample = new CMUserRoleExample();
        userRoleExample.createCriteria().andRoleIdEqualTo(role.getRoleId());
        CMUserRole userRole = new CMUserRole();
        userRole.setDelFlag(record.getDelFlag());
        userRole.setUpdateGroupCd(userInfo.getDepartmentId());
        userRole.setUpdateUserCd(userInfo.getUserId());
        userRole.setUpdateDate(DateUtils.getNowServerDateTime());
        this.cmUserRoleMapper.updateByExampleSelective(userRole, userRoleExample);

        result.setResult(role);
        result.setSuccess(true);
        return result;
    }

    /**
     * 取得角色菜单列表
     *
     * @param roleId
     * @return
     */
    public ServiceResult<JSONArray> getAdminRoleMenu(String roleId) {
        ServiceResult<JSONArray> result = new ServiceResult<>();
        ExtRoleMenuPermissionModel extRoleMenuPermissionModel = new ExtRoleMenuPermissionModel();
        extRoleMenuPermissionModel.setRoleId(roleId);
        List<ExtRoleMenuPermissionModel> leftMenuList = this.extPermissionMapper.selectRoleMenuPermission(extRoleMenuPermissionModel);
        JSONArray treeMenuList = this.treeMenuList(leftMenuList, ConstantsUtil.TREE_TOP);
        result.setResult(treeMenuList);
        result.setSuccess(true);

        return result;
    }

    /**
     * 菜单树形结构
     *
     * @param menuTreeDBList
     * @param topParentMenuCd
     * @return
     */
    private JSONArray treeMenuList(List<ExtRoleMenuPermissionModel> menuTreeDBList, String topParentMenuCd) {
        JSONArray childNode = new JSONArray();
        if (menuTreeDBList != null && menuTreeDBList.size() > 0) {
            for (ExtRoleMenuPermissionModel menuTreeRecord : menuTreeDBList) {
                ExtRoleMenuPermissionModel menuTree = menuTreeRecord;

                String menuCd = menuTree.getMenuId();
                String parentMenuCd = menuTree.getParentMenuId();

                JSONObject treeNode = new JSONObject();
                treeNode.put("id", parentMenuCd + "_" + menuCd);
                treeNode.put("text", menuTree.getMenuName());
                treeNode.put("icon", menuTree.getMenuIcon());

                JSONObject joAttr = new JSONObject();
                joAttr.put("menuId", menuTreeRecord.getMenuId());
                joAttr.put("parentMenuId", menuTreeRecord.getParentMenuId());
                joAttr.put("menuIcon", menuTreeRecord.getMenuIcon());
                joAttr.put("name", menuTreeRecord.getMenuName());
                joAttr.put("roleId", menuTreeRecord.getRoleId());
                joAttr.put("flag", menuTreeRecord.getFlag());

                if ("2".equals(menuTree.getFlag()) && StringUtils.isNotEmpty(menuTree.getRoleId())) {
                    JSONObject selectObj = new JSONObject();
                    selectObj.put("selected", true);
                    treeNode.put("state", selectObj);
                    joAttr.put("selected", true);
                } else {
                    joAttr.put("selected", false);
                }
                treeNode.put("li_attr", joAttr);

                if (topParentMenuCd.equals(parentMenuCd)) {
                    JSONArray menuTreeList = this.treeMenuList(menuTreeDBList, menuCd);
                    treeNode.put("children", menuTreeList);
                    childNode.add(treeNode);
                }
            }
        }

        return childNode;
    }

    /**
     * 插入或更新[角色菜单权限表]数据
     *
     * @param list
     */
    public ServiceResult<JSONObject> updatePermission(String roleId, LoginUserInfo loginUserInfo, List<CMRoleMenuPermission> list) {
        ServiceResult<JSONObject> result = new ServiceResult<>();

        String nowDate = DateUtils.getNowServerDateTime();
        CMRoleMenuPermissionExample example = new CMRoleMenuPermissionExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        this.cmRoleMenuPermissionMapper.deleteByExample(example);

        HashMap<String, String> hashMap = new HashMap<>();
        if (list != null && list.size() > 0) {
            for (CMRoleMenuPermission record : list) {
                record.setId(UUID.randomUUID().toString());
                record.setDelFlag(ConstantsUtil.FLG_NORMAL);
                record.setCreateDate(nowDate);
                record.setCreateGroupCd(loginUserInfo.getDepartmentId());
                record.setCreateUserCd(loginUserInfo.getUserId());
                record.setUpdateDate(nowDate);
                record.setUpdateGroupCd(loginUserInfo.getDepartmentId());
                record.setUpdateUserCd(loginUserInfo.getUserId());
                cmRoleMenuPermissionMapper.insert(record);
            }
        }
        result.setSuccess(true);
        return result;
    }
}
