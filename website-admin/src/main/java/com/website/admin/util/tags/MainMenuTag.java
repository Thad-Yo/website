package com.website.admin.util.tags;

import com.website.common.util.constants.ConstantsUtil;
import com.website.common.util.session.SessionUtils;
import com.website.mybatis.bean.ext.system.ExtMenuModel;

import org.apache.commons.lang.StringUtils;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.List;

/**
 * 类描述：菜单标签
 *
 * @version 1.0
 */
public class MainMenuTag extends TagSupport {
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    /**
     * URL前缀
     */
    private String urlPrefix;

    public String getUrlPrefix() {
        return urlPrefix;
    }

    public void setUrlPrefix(String urlPrefix) {
        this.urlPrefix = urlPrefix;
    }

    /**
     * 自定义标签开始
     */
    public int doStartTag() throws JspTagException {
        return EVAL_PAGE;
    }

    /**
     * 自定义标签结束
     */
    public int doEndTag() throws JspTagException {
        try {
            JspWriter out = this.pageContext.getOut();
            StringBuffer sb = new StringBuffer("");

            String fid = SessionUtils.getSession(ConstantsUtil.FUNCTION_ID);
            List<ExtMenuModel> menuInfo = SessionUtils.getSession(ConstantsUtil.MAIN_MENU_TREE);

            if (StringUtils.isEmpty(fid) && menuInfo != null && menuInfo.size() > 0) {
                // 默认第一个菜单被选中
                fid = menuInfo.get(0).getMenuId() + "";
            } // Endif
            this.createMenu(sb, menuInfo, fid, true);
            out.print(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return EVAL_PAGE;
    }

    /**
     * 创建菜单
     *
     * @return
     */
    private void createMenu(StringBuffer sb, List<ExtMenuModel> list, String funId, boolean root) {
        if (list != null && list.size() > 0) {

            boolean hasChild;
            for (ExtMenuModel entity : list) {
                // 是否有子菜单
                hasChild = entity.getMenuTreeClild() != null && !entity.getMenuTreeClild().isEmpty();

                sb.append("<li><a");
                if (!hasChild) {
                    sb.append(" class='J_menuItem' ");
                }
                sb.append(" href='");
                if (StringUtils.isBlank(entity.getMenuUrl())) {
                    sb.append("#");
                } else {
                    sb.append(this.urlPrefix);
                    sb.append("/");
                    sb.append(entity.getMenuUrl());
                }
                sb.append("' data-index='");
                sb.append(entity.getMenuId());
                sb.append("'><i class='");
                sb.append(entity.getMenuIcon());
                sb.append("'></i> <span class='nav-label'>");
                sb.append(entity.getMenuName());
                sb.append("</span>");
                if (hasChild) {
                    sb.append("<span class=\"fa arrow\"></span>");
                }
                sb.append("</a>");
                if (hasChild) {
                    sb.append("<ul class=\"nav nav-second-level collapse\" >");
                    createMenu(sb, entity.getMenuTreeClild(), funId, false);
                    sb.append("</ul>");
                }
                sb.append("</li>");

            } // Endfor
        }

    }

}
