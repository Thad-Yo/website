package com.website.admin.system.maintenance;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.website.admin.base.BaseController;
import com.website.admin.base.BaseDefine;
import com.website.common.util.bean.ServiceResult;
import com.website.common.util.constants.ConstantsUtil;
import com.website.common.util.date.DateUtils;
import com.website.common.util.paginator.Paginator;
import com.website.common.util.session.SessionUtils;
import com.website.common.util.validator.Validator;
import com.website.mybatis.bean.auto.system.CMName;
import com.website.mybatis.bean.ext.system.ExtNameModel;
import com.website.service.maintenance.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/system/maintenance/name")
public class NameController extends BaseController {

    @Autowired
    private NameService nameService;

    /**
     * 护画面初始化
     *
     * @return
     */
    @RequestMapping("init")
    public ModelAndView init() {
        ModelAndView modelAndView = new ModelAndView("/system/maintenance/name/name_list");
        return modelAndView;
    }

    /**
     * 画面初始化
     *
     * @param request
     * @param form
     * @return
     */
    @ResponseBody
    @RequestMapping("searchAction")
    public JSONObject searchAction(HttpServletRequest request, @ModelAttribute(BaseDefine.FORM) ExtNameModel form) {
        // 创建分页
        return this.createPage(request, form);
    }

    /**
     * 创建分页机能
     *
     * @param request
     * @param form
     */
    private JSONObject createPage(HttpServletRequest request, ExtNameModel form) {

        JSONObject object = new JSONObject();
        // 翻页
        HashMap<String, Integer> pageNumSizeMap = Paginator.getPageNumPageSize(request);
        PageHelper.startPage(pageNumSizeMap.get("pageNum"), pageNumSizeMap.get("pageSize"));

        ServiceResult<List<CMName>> result = this.nameService.getRecordList(form);

        if (result != null) {
            List<CMName> recordList = result.getResult();
            PageInfo paginator = new PageInfo(recordList);// 默认8页数据
            object.put("rows", paginator.getList());
            object.put("total", paginator.getTotal());
        }

        return object;
    }

    /**
     * 画面迁移(含有id更新，不含有id添加)
     *
     * @param request
     * @param form
     * @return
     */
    @RequestMapping("infoAction")
    public ModelAndView info(HttpServletRequest request, @ModelAttribute(BaseDefine.FORM) ExtNameModel form) {
        ModelAndView modelAndView = new ModelAndView("system/maintenance/name/name_info");
        // 根据主键获取相应的数据
        if (Validator.isNotNull(form.getId())) {
            ServiceResult<CMName> result = this.nameService.getRecord(form);

            CMName name = result.getResult();
            modelAndView.addObject("record", name);
            modelAndView.addObject(BaseDefine.FORM, form);
        }
        return modelAndView;
    }

    /**
     * 新增
     */
    @ResponseBody
    @RequestMapping("insertAction")
    public ServiceResult<CMName> insertAction(HttpServletRequest request, @ModelAttribute ExtNameModel form) {
        // 画面验证
        Map<String, String> errorMap = this.validatorFieldCheck(form);
        String loginDepartmentCd = SessionUtils.getLoginDepartmentCd();
        String loginUserCd = SessionUtils.getLoginUserCd();
        String nowDate = DateUtils.getNowServerDateTime();

        form.setCreateGroupCd(loginDepartmentCd);
        form.setCreateUserCd(loginUserCd);
        form.setCreateDate(nowDate);
        form.setUpdateGroupCd(loginDepartmentCd);
        form.setUpdateUserCd(loginUserCd);
        form.setUpdateDate(nowDate);

        ServiceResult<CMName> result = this.nameService.insertRecord(SessionUtils.getLoginUserInfo(), form);
        return result;
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("updateAction")
    public ServiceResult<CMName> updateAction(HttpServletRequest request, @ModelAttribute ExtNameModel form) {

        String loginDepartmentCd = SessionUtils.getLoginDepartmentCd();
        String loginUserCd = SessionUtils.getLoginUserCd();
        String nowDate = DateUtils.getNowServerDateTime();

        form.setUpdateGroupCd(loginDepartmentCd);
        form.setUpdateUserCd(loginUserCd);
        form.setUpdateDate(nowDate);

        return this.nameService.updateRecord(SessionUtils.getLoginUserInfo(), form);
    }

    /**
     * 删除配置信息
     *
     * @param request
     * @param form
     * @return
     */
    @ResponseBody
    @RequestMapping("deleteAction")
    public ServiceResult<CMName> deleteRecordAction(HttpServletRequest request, @ModelAttribute ExtNameModel form) {
        String loginDepartmentCd = SessionUtils.getLoginDepartmentCd();
        String loginUserCd = SessionUtils.getLoginUserCd();
        String nowDate = DateUtils.getNowServerDateTime();

        form.setUpdateGroupCd(loginDepartmentCd);
        form.setUpdateUserCd(loginUserCd);
        form.setUpdateDate(nowDate);
        return this.nameService.deleteRecord(SessionUtils.getLoginUserInfo(), form);
    }

    /**
     * 调用校验表单方法
     */
    private Map<String, String> validatorFieldCheck(ExtNameModel form) {
        Map<String, String> errorMap = new HashMap<>();
        return errorMap;
    }
}

