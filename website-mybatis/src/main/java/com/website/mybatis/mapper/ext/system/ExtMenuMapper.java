package com.website.mybatis.mapper.ext.system;

import java.util.List;

import com.website.mybatis.bean.ext.system.ExtMenuModel;

public interface ExtMenuMapper {

    /**
     * 获取用户的左侧菜单
     *
     * @param extMenuModel
     * @return
     */
    List<ExtMenuModel> selectLeftMenuTree(ExtMenuModel extMenuModel);

}