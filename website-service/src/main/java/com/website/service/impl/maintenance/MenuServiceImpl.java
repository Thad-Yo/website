package com.website.service.impl.maintenance;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.website.common.util.bean.ServiceResult;
import com.website.common.util.constants.ConstantsUtil;
import com.website.common.util.constants.ShiroConstants;
import com.website.common.util.date.DateUtils;
import com.website.common.util.session.LoginUserInfo;
import com.website.common.util.validator.Validator;
import com.website.mybatis.bean.auto.*;
import com.website.mybatis.bean.auto.system.CMMenu;
import com.website.mybatis.bean.auto.system.CMMenuExample;
import com.website.mybatis.bean.auto.system.CMMenuPermission;
import com.website.mybatis.bean.auto.system.CMMenuPermissionExample;
import com.website.mybatis.bean.auto.system.CMRoleMenuPermissionExample;
import com.website.mybatis.bean.ext.system.AdminMenuBean;
import com.website.mybatis.bean.ext.system.ExtDepartmentModel;
import com.website.service.maintenance.MenuService;
import com.website.service.impl.BaseServiceImpl;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

@Service
public class MenuServiceImpl extends BaseServiceImpl implements MenuService {
    private static final String THIS_CLASS = MenuServiceImpl.class.getName();
    private static final Logger logger = LoggerFactory.getLogger(MenuServiceImpl.class);

    /**
     * 获取菜单列表
     *
     * @return
     */
    public ServiceResult<JSONArray> getRecordList(AdminMenuBean form) {
        ServiceResult<JSONArray> result = new ServiceResult<>();
        try {
            CMMenuExample example = new CMMenuExample();
            example.createCriteria().andDelFlagEqualTo(ConstantsUtil.FLG_NORMAL);
            example.setOrderByClause(" sort_key ");
            List<CMMenu> leftMenuList = this.cmMenuMapper.selectByExample(example);

            Map<String, String> map = new HashMap<String, String>();
            map.put(ConstantsUtil.TREE_TOP, "菜单导航");
            if (leftMenuList != null && leftMenuList.size() > 0) {
                for (CMMenu adminMenu : leftMenuList) {
                    map.put(adminMenu.getMenuId(), adminMenu.getMenuName());
                }
            }

            String selectedNode = form.getSelectedNode();
            JSONArray array = this.treeMenuList(leftMenuList, map, selectedNode, ConstantsUtil.TREE_TOP, false);

            JSONArray treeArray = new JSONArray();
            JSONObject jo = new JSONObject();
            jo.put("id", ConstantsUtil.TREE_TOP);
            jo.put("text", "菜单导航");
            jo.put("icon", "fa fa-bars");
            jo.put("children", array);
            JSONObject joAttr = new JSONObject();
            joAttr.put("contextmenu", "create_menu");
            jo.put("li_attr", joAttr);
            treeArray.add(jo);
            result.setResult(treeArray);
            result.setSuccess(true);
        } catch (Exception e) {
            logger.error(THIS_CLASS, "getRecordList", e.getMessage(), e);
            result.setError(e.getMessage());
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
    public ServiceResult<AdminMenuBean> getRecord(String id) {
        ServiceResult<AdminMenuBean> result = new ServiceResult<AdminMenuBean>();
        CMMenu menu = this.cmMenuMapper.selectByPrimaryKey(id);
        CMMenuPermissionExample example = new CMMenuPermissionExample();
        CMMenuPermissionExample.Criteria cra = example.createCriteria();
        cra.andMenuIdEqualTo(id);
        try {
            AdminMenuBean menuBean = new AdminMenuBean();
            BeanUtils.copyProperties(menuBean, menu);
            menuBean.setMenuPermission(this.cmMenuPermissionMapper.selectByExample(example));
            result.setResult(menuBean);
            result.setSuccess(true);
            return result;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        result.setSuccess(false);
        return result;
    }

    /**
     * 菜单树形结构
     *
     * @param menuTreeDBList
     * @param topParentMenuCd
     * @return
     */
    public JSONArray treeMenuList(List<CMMenu> menuTreeDBList, Map<String, String> map, String selectedNode, String topParentMenuCd, boolean flag) {
        JSONArray ja = new JSONArray();
        JSONObject joAttr = new JSONObject();
        if (menuTreeDBList != null && menuTreeDBList.size() > 0) {
            JSONObject jo = null;
            for (CMMenu menuTreeRecord : menuTreeDBList) {
                jo = new JSONObject();

                jo.put("id", menuTreeRecord.getMenuId());
                jo.put("text", menuTreeRecord.getMenuName());
                jo.put("icon", menuTreeRecord.getMenuIcon());
                joAttr = new JSONObject();
                joAttr.put("menuId", menuTreeRecord.getMenuId());
                joAttr.put("parentMenuId", menuTreeRecord.getParentMenuId());
                joAttr.put("parentMenuNm", map.get(menuTreeRecord.getParentMenuId()));
                joAttr.put("menuControllor", menuTreeRecord.getMenuControllor());
                joAttr.put("menuIcon", menuTreeRecord.getMenuIcon());
                joAttr.put("menuName", menuTreeRecord.getMenuName());
                joAttr.put("sortKey", menuTreeRecord.getSortKey());
                joAttr.put("menuUrl", menuTreeRecord.getMenuUrl());
                joAttr.put("status", menuTreeRecord.getStatus());
                joAttr.put("menuName", menuTreeRecord.getMenuName());
                joAttr.put("delFlag", menuTreeRecord.getDelFlag());
                joAttr.put("contextmenu", "create_page");
                if (flag) {
                    joAttr.put("contextmenu", "modify_page");
                }
                jo.put("li_attr", joAttr);
                if (StringUtils.isNotBlank(selectedNode) && selectedNode.equals(menuTreeRecord.getMenuId())) {
                    JSONObject selectObj = new JSONObject();
                    selectObj.put("selected", true);
                    // selectObj.put("opened", true);
                    jo.put("state", selectObj);
                }

                String menuCd = menuTreeRecord.getMenuId();
                String parentMenuCd = menuTreeRecord.getParentMenuId();
                if (topParentMenuCd.equals(parentMenuCd)) {
                    JSONArray array = treeMenuList(menuTreeDBList, map, selectedNode, menuCd, true);
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

    /**
     * 菜单插入
     *
     * @param record
     */
    public ServiceResult<String> insertRecord(LoginUserInfo userInfo, AdminMenuBean record) throws Exception {
        ServiceResult<String> result = new ServiceResult<>();
        if (StringUtils.isNotEmpty(record.getSort())) {
            if (!Validator.isNumber(record.getSort())) {
                result.setMessage("菜单排序不是数字格式!");
                result.setSuccess(false);
                return result;
            } else {
                record.setSortKey(Integer.valueOf(record.getSort()));
            }
        }

        ServiceResult<Integer> result2 = this.isExistsRecord(StringUtils.EMPTY, record.getMenuName());
        if (result2.getSuccess()) {
            record.setMenuId(UUID.randomUUID().toString());
            if (!StringUtils.equals(record.getDelFlag(), "1")) {
                record.setDelFlag(ConstantsUtil.FLG_NORMAL);
            } else {
                record.setDelFlag(ConstantsUtil.FLG_DELETE);
            }
            record.setCreateGroupCd(userInfo.getDepartmentId());
            record.setCreateUserCd(userInfo.getUserId());
            record.setCreateDate(DateUtils.getNowServerDateTime());
            record.setUpdateGroupCd(userInfo.getDepartmentId());
            record.setUpdateUserCd(userInfo.getUserId());
            record.setUpdateDate(DateUtils.getNowServerDateTime());
            int cnt = cmMenuMapper.insert(record);
            // 更新菜单的权限表
            this.updateMenuPermissions(record);
            result.setResult(record.getMenuId());
            result.setSuccess(true);
        } else {
            result.setMessage("菜单名称重复，请重新输入!");
            result.setSuccess(false);
        }
        return result;
    }

    /**
     * 菜单更新
     *
     * @param record
     */
    public ServiceResult<Integer> updateRecord(LoginUserInfo userInfo, AdminMenuBean record) throws Exception {
        ServiceResult<Integer> result = new ServiceResult<>();
        if (StringUtils.isNotEmpty(record.getSort())) {
            if (!Validator.isNumber(record.getSort())) {
                result.setMessage("菜单排序不是数字格式!");
                result.setSuccess(false);
                return result;
            } else {
                record.setSortKey(Integer.valueOf(record.getSort()));
            }
        }
        int cnt = 0;

        if (!StringUtils.equals(record.getDelFlag(), "1")) {
            record.setDelFlag(ConstantsUtil.FLG_NORMAL);
        } else {
            record.setDelFlag(ConstantsUtil.FLG_DELETE);
        }
        record.setUpdateGroupCd(userInfo.getDepartmentId());
        record.setUpdateUserCd(userInfo.getUserId());
        record.setUpdateDate(DateUtils.getNowServerDateTime());
        cnt = cmMenuMapper.updateByPrimaryKeySelective(record);
        this.updateMenuPermissions(record);
        //如果是删除菜单递归删除所有子菜单
        if (StringUtils.equals(record.getDelFlag(), "1")) {
            this.updateMenuRecursive(userInfo, record);
            //清除菜单的权限
            CMMenuPermissionExample permissionExample = new CMMenuPermissionExample();
            CMMenuPermissionExample.Criteria permissionCriteria = permissionExample.createCriteria();
            permissionCriteria.andMenuIdEqualTo(record.getMenuId());
            this.cmMenuPermissionMapper.deleteByExample(permissionExample);
            //清除角色菜单权限关联关系
            CMRoleMenuPermissionExample roleMenuPermissionExample = new CMRoleMenuPermissionExample();
            CMRoleMenuPermissionExample.Criteria roleMenuPermissionCriteria = roleMenuPermissionExample.createCriteria();
            roleMenuPermissionCriteria.andMenuIdEqualTo(record.getMenuId());
            this.cmRoleMenuPermissionMapper.deleteByExample(roleMenuPermissionExample);
        }
        result.setResult(cnt);
        result.setSuccess(true);

        return result;
    }
    
    /**
     * 递归删除父级及其子集的菜单列表
     * @param userInfo
     * @param record
     */
    public void updateMenuRecursive(LoginUserInfo userInfo, AdminMenuBean record){
    	CMMenuExample example = new CMMenuExample();
    	CMMenuExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotEmpty(record.getMenuId())){
        	criteria.andParentMenuIdEqualTo(record.getMenuId());
        }
        List<CMMenu> menuList = this.cmMenuMapper.selectByExample(example);
        if(menuList!=null && menuList.size()>0){
        	CMMenu cmMenu = new CMMenu();
        	cmMenu.setStatus(ConstantsUtil.FLG_NORMAL);
            if (!StringUtils.equals(record.getDelFlag(), "1")) {
            	cmMenu.setDelFlag(ConstantsUtil.FLG_NORMAL);
            } else {
            	cmMenu.setDelFlag(ConstantsUtil.FLG_DELETE);
            }
            cmMenu.setUpdateGroupCd(userInfo.getDepartmentId());
            cmMenu.setUpdateUserCd(userInfo.getUserId());
            cmMenu.setUpdateDate(DateUtils.getNowServerDateTime());
            cmMenuMapper.updateByExampleSelective(cmMenu, example);
            for(CMMenu cmMenuChil : menuList){
                //清除菜单的权限
                CMMenuPermissionExample permissionExample = new CMMenuPermissionExample();
                CMMenuPermissionExample.Criteria permissionCriteria = permissionExample.createCriteria();
                permissionCriteria.andMenuIdEqualTo(cmMenuChil.getMenuId());
                this.cmMenuPermissionMapper.deleteByExample(permissionExample);
                //清除角色菜单权限关联关系
                CMRoleMenuPermissionExample roleMenuPermissionExample = new CMRoleMenuPermissionExample();
                CMRoleMenuPermissionExample.Criteria roleMenuPermissionCriteria = roleMenuPermissionExample.createCriteria();
                roleMenuPermissionCriteria.andMenuIdEqualTo(cmMenuChil.getMenuId());
                this.cmRoleMenuPermissionMapper.deleteByExample(roleMenuPermissionExample);
                //递归
            	AdminMenuBean recordChil = new AdminMenuBean();
            	recordChil.setMenuId(cmMenuChil.getMenuId());
            	recordChil.setDelFlag(record.getDelFlag());
            	updateMenuRecursive(userInfo, recordChil);
        	}
        }else{
        	return;
        }
    }

    /**
     * 取得菜单权限列表
     *
     * @param menuId
     */
    public ServiceResult<List<CMMenuPermission>> getMenuPermissionsList(String menuId) {
        ServiceResult<List<CMMenuPermission>> result = new ServiceResult<>();
        if (StringUtils.isEmpty(menuId)) {
            result.setMessage("您没有选择菜单，请重新选择菜单！");
            result.setSuccess(false);
            return result;
        }
        CMMenuPermissionExample menuPermissionsExample = new CMMenuPermissionExample();
        CMMenuPermissionExample.Criteria cra = menuPermissionsExample.createCriteria();
        cra.andMenuIdEqualTo(menuId);
        cra.andPermissionNotEqualTo(ConstantsUtil.VIEW);

        List<CMMenuPermission> listMenuPermissions = this.cmMenuPermissionMapper.selectByExample(menuPermissionsExample);
        result.setResult(listMenuPermissions);
        result.setSuccess(true);

        return result;
    }

    /**
     * 菜单权限更新
     *
     * @param record
     */
    public void updateMenuPermissions(AdminMenuBean record) {
        String menuId = record.getMenuId();
        CMMenuPermissionExample menuPermissionsExample = new CMMenuPermissionExample();
        menuPermissionsExample.createCriteria().andMenuIdEqualTo(menuId);
        this.cmMenuPermissionMapper.deleteByExample(menuPermissionsExample);

        CMMenuPermission permission = new CMMenuPermission();
        permission.setId(UUID.randomUUID().toString());
        permission.setMenuId(record.getMenuId());
        permission.setPermission(ShiroConstants.PERMISSION_VIEW);
        permission.setPermissionName("查看");
        permission.setDelFlag(ConstantsUtil.FLG_NORMAL);
        permission.setCreateDate(record.getCreateDate());
        permission.setCreateGroupCd(record.getCreateGroupCd());
        permission.setCreateUserCd(record.getCreateUserCd());
        permission.setUpdateGroupCd(record.getUpdateGroupCd());
        permission.setUpdateUserCd(record.getUpdateUserCd());
        permission.setUpdateDate(record.getUpdateDate());
        cmMenuPermissionMapper.insert(permission);

        String permissionsJson = StringEscapeUtils.unescapeHtml4(record.getMenuPermissionJson());
        if (StringUtils.isNotEmpty(permissionsJson)) {
            List<CMMenuPermission> permissionsList = JSONArray.parseArray(permissionsJson, CMMenuPermission.class);
            if (Validator.isNotNull(menuId) && permissionsList != null) {

                for (CMMenuPermission permissions : permissionsList) {
                    permissions.setId(UUID.randomUUID().toString());
                    permissions.setMenuId(record.getMenuId());
                    permissions.setDelFlag(ConstantsUtil.FLG_NORMAL);
                    permissions.setCreateDate(record.getCreateDate());
                    permissions.setCreateGroupCd(record.getCreateGroupCd());
                    permissions.setCreateUserCd(record.getCreateUserCd());
                    permissions.setUpdateGroupCd(record.getUpdateGroupCd());
                    permissions.setUpdateUserCd(record.getUpdateUserCd());
                    permissions.setUpdateDate(record.getUpdateDate());
                    this.cmMenuPermissionMapper.insert(permissions);
                }
            }
        }
    }
}
