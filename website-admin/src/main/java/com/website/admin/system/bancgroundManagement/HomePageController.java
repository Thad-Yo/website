package com.website.admin.system.bancgroundManagement;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.website.admin.base.BaseController;
import com.website.admin.base.BaseDefine;
import com.website.common.util.bean.ServiceResult;
import com.website.common.util.date.DateUtils;
import com.website.common.util.file.FileUtils;
import com.website.common.util.image.ReduceImage;
import com.website.common.util.paginator.Paginator;
import com.website.common.util.properties.PropertyUtil;
import com.website.common.util.session.SessionUtils;
import com.website.mybatis.bean.auto.WebsiteBasic;
import com.website.mybatis.bean.auto.WebsiteBasicWithBLOBs;
import com.website.mybatis.bean.auto.WebsiteConfigBanner;
import com.website.mybatis.bean.auto.WebsiteIntroduce;
import com.website.mybatis.bean.ext.ExtWebsiteConfigBannerModel;
import com.website.mybatis.mapper.ext.ExtWebsiteBasicMapper;
import com.website.service.pro.HomePageService;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * @author GOGTZ
 * @version V1.0  
 * @date Tue Jul 12 16:47:53 CST 2016
 */
@Controller
@RequestMapping(value = "/system/backgroundManageMent/homePageController")
public class HomePageController extends BaseController {

    @Autowired
    private HomePageService homePageService;
    @Autowired
    private ExtWebsiteBasicMapper extWebsiteBasicMapper;


    /**
     * 画面初始化
     *
     * @param request
     * @param form
     * @return
     */
    @RequestMapping(value = "init")
    public ModelAndView init(HttpServletRequest request, RedirectAttributes attr, @ModelAttribute(BaseDefine.FORM) WebsiteBasic form) {
        ModelAndView modelAndView = new ModelAndView("/system/backgroundManagement/homePage/banner_list");
        return modelAndView;
    }
    /**
     * 画面初始化
     *
     * @param request
     * @param form
     * @return
     */
    @RequestMapping(value = "basicsInit")
    public ModelAndView basicsInit(HttpServletRequest request, RedirectAttributes attr, @ModelAttribute(BaseDefine.FORM) ExtWebsiteConfigBannerModel form) {
    	ModelAndView modelAndView = new ModelAndView("/system/backgroundManagement/homePage/basics_edit");
    	WebsiteBasicWithBLOBs a = this.extWebsiteBasicMapper.select("1");
        modelAndView.addObject("row", a);
    	return modelAndView;
    }
    /**
     * 新增编辑界面
     *
     * @param request
     * @param form
     * @return
     */
    @RequestMapping(value = "addInfo")
    public ModelAndView addInfo(HttpServletRequest request, RedirectAttributes attr, @ModelAttribute(BaseDefine.FORM) ExtWebsiteConfigBannerModel form) {
    	ModelAndView modelAndView = new ModelAndView("/system/backgroundManagement/homePage/banner_edit");
    	return modelAndView;
    }
    /**
     * 编辑界面
     *
     * @param request
     * @param form
     * @return
     */
    @RequestMapping(value = "editInfo")
    public ModelAndView editInfo(HttpServletRequest request, RedirectAttributes attr, @ModelAttribute(BaseDefine.FORM) ExtWebsiteConfigBannerModel form) {
    	ModelAndView modelAndView = new ModelAndView("/system/backgroundManagement/homePage/banner_edit");
    	WebsiteConfigBanner banner = this.homePageService.getConfigBanner(form);
    	modelAndView.addObject("row", banner);
    	return modelAndView;
    }
    /**
     * 查看界面
     *
     * @param request
     * @param form
     * @return
     */
    @RequestMapping(value = "checkInfo")
    public ModelAndView checkInfo(HttpServletRequest request, RedirectAttributes attr, @ModelAttribute(BaseDefine.FORM) ExtWebsiteConfigBannerModel form) {
    	ModelAndView modelAndView = new ModelAndView("/system/backgroundManagement/homePage/banner_check");
    	WebsiteConfigBanner banner = this.homePageService.getConfigBanner(form);
    	modelAndView.addObject("row", banner);
    	return modelAndView;
    }

    /**
     * 画面初始化
     *
     * @param request
     * @param form
     * @return
     */
    @RequestMapping(value = "searchAction")
    public JSONObject searchAction(HttpServletRequest request, RedirectAttributes attr, @ModelAttribute(BaseDefine.FORM) ExtWebsiteConfigBannerModel form) {
        // 创建分页
        return this.createPage(request, form);
    }

    /**
     * 创建分页机能
     *
     * @param request
     * @param form
     */
    private JSONObject createPage(HttpServletRequest request, ExtWebsiteConfigBannerModel form) {
        JSONObject object = new JSONObject();
        List<ExtWebsiteConfigBannerModel> recordList = new ArrayList<>();

        // 翻页
        HashMap<String, Integer> pageNumSizeMap = Paginator.getPageNumPageSize(request);
        PageHelper.startPage(pageNumSizeMap.get("pageNum"), pageNumSizeMap.get("pageSize"));

        // 取得内容
        ServiceResult<List<ExtWebsiteConfigBannerModel>> recordResult = this.homePageService.getRecordList(form);

        if (recordResult != null && recordResult.isSuccess() && recordResult.getResult() != null) {
            recordList = recordResult.getResult();
            PageInfo paginator = new PageInfo(recordList);// 默认8页数据
            object.put("rows", paginator.getList());
            object.put("total", paginator.getTotal());
        }


        return object;
    }

    
    
    /**
     * 上传文件
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "uploadImageAction", produces = BaseDefine.JSON)
    public String uploadImageAction(HttpServletRequest request, HttpServletResponse response) {
        ServiceResult<String> resultBean = new ServiceResult<String>();

        try {
            CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
            MultipartHttpServletRequest multipartRequest = commonsMultipartResolver.resolveMultipart(request);

            Iterator<String> itr = multipartRequest.getFileNames();
            MultipartFile multipartFile = null;
            while (itr.hasNext()) {
                multipartFile = multipartRequest.getFile(itr.next());
                // 文件名
                final String fileName = multipartFile.getOriginalFilename();
                // 文件扩展名
                final String suffix = FileUtils.getSuffix(multipartFile.getOriginalFilename());
                // 文件大小
                final long fileSize = multipartFile.getSize();
                //系统生成文件名
                final String fileNameAuto = DateUtils.DateToString(new Date(), "yyyyMMddHHmmss_" + StringUtils.leftPad(Integer.toString(RandomUtils.nextInt(1, 200)), 3, "0")) + "."+suffix;
                // 保存路径
                final String bathPath = PropertyUtil.getSystemResourcesPropertieValue("file.basepath");
                final String uploadPath = PropertyUtil.getSystemResourcesPropertieValue("file.uploadpath");
                final String tempPath = "banner/";
                final String fileDirPath = bathPath + uploadPath + tempPath;
                final String filePath = fileDirPath + fileNameAuto;
                if(!(new File(fileDirPath)).isDirectory()){
    				(new File(fileDirPath)).mkdirs();
    			}
                //FileUtils.CreateDirectory(fileDirPath);

                boolean saveFlag = FileUtils.SaveFileByPhysicalDir(filePath, multipartFile.getInputStream());
                if (saveFlag) {
                    String finalName = fileNameAuto;
//                    try{
//                        ReduceImage.resize(filePath,fileDirPath+finalName,1d,1.0f);
//                    }catch (Exception e){
//                        resultBean.setResult(uploadPath + tempPath+fileNameAuto);
//                        resultBean.setSuccess(true);
//                        resultBean.setCode("0");
//                        resultBean.setMessage("文件上传成功");
//                    }
                    resultBean.setResult(uploadPath + tempPath+finalName);
                    resultBean.setSuccess(true);
                    resultBean.setCode("0");
                    resultBean.setMessage("文件上传成功");
                } else {
                    resultBean.setSuccess(false);
                    resultBean.setCode("1");
                    resultBean.setMessage("文件上传失败");
                }
            }
        } catch (Exception e) {
            //log.error("", e);
            e.printStackTrace();
            resultBean.setSuccess(false);
            resultBean.setCode("1");
            resultBean.setMessage("文件上传失败");
        }
        return resultBean.toString();
    }
    /**
     * 上传文件
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "uploadVideoAction", produces = BaseDefine.JSON)
    public String uploadVideoAction(HttpServletRequest request, HttpServletResponse response) {
    	ServiceResult<String> resultBean = new ServiceResult<String>();
    	
    	try {
    		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
    		MultipartHttpServletRequest multipartRequest = commonsMultipartResolver.resolveMultipart(request);
    		
    		Iterator<String> itr = multipartRequest.getFileNames();
    		MultipartFile multipartFile = null;
    		while (itr.hasNext()) {
    			multipartFile = multipartRequest.getFile(itr.next());
    			// 文件名
    			final String fileName = multipartFile.getOriginalFilename();
    			// 文件扩展名
    			final String suffix = FileUtils.getSuffix(multipartFile.getOriginalFilename());
    			// 文件大小
    			final long fileSize = multipartFile.getSize();
    			//系统生成文件名
    			final String fileNameAuto = DateUtils.DateToString(new Date(), "yyyyMMddHHmmss_" + StringUtils.leftPad(Integer.toString(RandomUtils.nextInt(1, 200)), 3, "0")) + "."+suffix;
    			// 保存路径
    			final String bathPath = PropertyUtil.getSystemResourcesPropertieValue("file.basepath");
    			final String uploadPath = PropertyUtil.getSystemResourcesPropertieValue("file.uploadpath");
    			final String tempPath = "basics/";
    			final String fileDirPath = bathPath + uploadPath + tempPath;
    			final String filePath = fileDirPath + fileNameAuto;
    			if(!(new File(fileDirPath)).isDirectory()){
    				(new File(fileDirPath)).mkdirs();
    			}
    			//FileUtils.CreateDirectory(fileDirPath);
    			
    			boolean saveFlag = FileUtils.SaveFileByPhysicalDir(filePath, multipartFile.getInputStream());
    			if (saveFlag) {
    				resultBean.setResult(uploadPath + tempPath + fileNameAuto);
    				resultBean.setSuccess(true);
    				resultBean.setCode("0");
    				resultBean.setMessage("文件上传成功");
    			} else {
    				resultBean.setSuccess(false);
    				resultBean.setCode("1");
    				resultBean.setMessage("文件上传失败");
    			}
    		}
    	} catch (Exception e) {
    		//log.error("", e);
    		resultBean.setSuccess(false);
    		resultBean.setCode("1");
    		resultBean.setMessage("文件上传失败");
    	}
    	return resultBean.toString();
    }
    
    /**
     * 新增编辑
     */
    @ResponseBody
    @RequestMapping(value = "saveAction")
    public ServiceResult<JSONObject> saveAction(HttpServletRequest request, ExtWebsiteConfigBannerModel form) {
    	ServiceResult<JSONObject> ret = new ServiceResult<JSONObject>();
    	form.setUpdateUserId(SessionUtils.getLoginUserInfo().getUserId());
    	form.setUpdateUserName(SessionUtils.getLoginUserInfo().getRealName());
    	ServiceResult<ExtWebsiteConfigBannerModel> recordResult = this.homePageService.insertRecord(form);
    	if(form.getDropImg()!=null&&form.getDropImg().size()>0){
            final String bathPath = PropertyUtil.getSystemResourcesPropertieValue("file.basepath");
			for(String e:form.getDropImg()){
				File file = new File(bathPath+e);
				file.delete();  
			}
    	}
    	ret.setSuccess(recordResult.getSuccess());
    	ret.setMessage(recordResult.getMessage());
    	return ret;
    }
    
    /**
     * 保存基础管理
     */
    @ResponseBody
    @RequestMapping(value = "saveBasicAction")
    public ServiceResult<JSONObject> saveBasicAction(HttpServletRequest request, WebsiteBasicWithBLOBs form) {
    	ServiceResult<JSONObject> ret = new ServiceResult<JSONObject>();
    	ServiceResult<WebsiteBasicWithBLOBs> recordResult = this.homePageService.insertBasic(form);
    	ret.setSuccess(recordResult.getSuccess());
    	ret.setMessage(recordResult.getMessage());
    	return ret;
    }
    
    /**
     * 修改banner发布状态
     */
    @ResponseBody
    @RequestMapping(value = "updateIssue")
    public ServiceResult<JSONObject> updateIssue(HttpServletRequest request, ExtWebsiteConfigBannerModel form) {
    	ServiceResult<JSONObject> ret = new ServiceResult<JSONObject>();
    	form.setUpdateUserId(SessionUtils.getLoginUserInfo().getUserId());
    	form.setUpdateUserName(SessionUtils.getLoginUserInfo().getRealName());
    	ServiceResult<ExtWebsiteConfigBannerModel> recordResult = this.homePageService.updateIssue(form);
    	ret.setSuccess(recordResult.getSuccess());
    	ret.setMessage(recordResult.getMessage());
    	return ret;
    }
    /**
     * 删除banner
     */
    @ResponseBody
    @RequestMapping(value = "deleteAction")
    public ServiceResult<JSONObject> deleteAction(HttpServletRequest request, ExtWebsiteConfigBannerModel form) {
    	ServiceResult<JSONObject> ret = new ServiceResult<JSONObject>();
    	form.setUpdateUserId(SessionUtils.getLoginUserInfo().getUserId());
    	form.setUpdateUserName(SessionUtils.getLoginUserInfo().getRealName());
    	ServiceResult<ExtWebsiteConfigBannerModel> recordResult = this.homePageService.deleteAction(form);
    	ret.setSuccess(recordResult.getSuccess());
    	ret.setMessage(recordResult.getMessage());
    	return ret;
    }
    
    
    
    
    
    
    
    
    
    
    

}

