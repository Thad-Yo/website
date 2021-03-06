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
import com.website.common.util.validator.ValidatorAjaxCheckResult;
import com.website.mybatis.bean.auto.WebsiteConfigBanner;
import com.website.mybatis.bean.auto.WebsiteDev;
import com.website.mybatis.bean.auto.WebsiteHonor;
import com.website.mybatis.bean.auto.WebsiteIntroduce;
import com.website.mybatis.bean.auto.WebsiteScope;
import com.website.mybatis.bean.ext.ExtWebsiteConfigBannerModel;
import com.website.mybatis.bean.ext.ExtWebsiteScopeModel;
import com.website.mybatis.mapper.auto.WebsiteIntroduceMapper;
import com.website.mybatis.mapper.auto.WebsiteScopeMapper;
import com.website.mybatis.mapper.ext.ExtWebsiteIntroduceMapper;
import com.website.mybatis.mapper.ext.ExtWebsiteScopeMapper;
import com.website.service.pro.AboutUsService;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author xzx
 * @version V1.0  
 * @date Tue Jul 12 16:47:53 CST 2016
 */
@Controller
@RequestMapping(value = "/system/backgroundManageMent/aboutUsController")
public class AboutUsController extends BaseController {

    @Autowired
    private AboutUsService aboutUsService;
    @Autowired
	protected ExtWebsiteIntroduceMapper extWebsiteIntroduceMapper;
    @Autowired
   	protected ExtWebsiteScopeMapper extWebsiteScopeMapper;
    @Autowired
   	protected WebsiteScopeMapper websiteScopeMapper;

    /**
     * 画面初始化
     *
     * @param request
     * @param form
     * @return
     */
    @RequestMapping(value = "init")
    public ModelAndView init(HttpServletRequest request, RedirectAttributes attr, @ModelAttribute(BaseDefine.FORM) WebsiteIntroduce form) {
        ModelAndView modelAndView = new ModelAndView("/system/backgroundManagement/aboutUs/introduce");
        WebsiteIntroduce a = extWebsiteIntroduceMapper.selectByPrimaryKey(1);
        List<WebsiteScope> ws = extWebsiteScopeMapper.selectByPrimaryKey(1);
        modelAndView.addObject("role", a);
        modelAndView.addObject("websiteScopeList", ws);
        return modelAndView;
    }
    /**
     * 画面初始化
     *
     * @param request
     * @param form
     * @return
     */
    @RequestMapping(value = "devInit")
    public ModelAndView devInit(HttpServletRequest request, RedirectAttributes attr, @ModelAttribute(BaseDefine.FORM) WebsiteDev form) {
    	ModelAndView modelAndView = new ModelAndView("/system/backgroundManagement/aboutUs/dev_list");
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
    public ModelAndView addInfo(HttpServletRequest request, RedirectAttributes attr, @ModelAttribute(BaseDefine.FORM) WebsiteDev form) {
    	ModelAndView modelAndView = new ModelAndView("/system/backgroundManagement/aboutUs/dev_edit");
    	String isEng = request.getParameter("isEng");// 2代表是新增英文，1代表编辑英文，其他代表中文
    	modelAndView.addObject("isEng", isEng);
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
    public ModelAndView editInfo(HttpServletRequest request, RedirectAttributes attr, @ModelAttribute(BaseDefine.FORM) WebsiteDev form) {
    	ModelAndView modelAndView = new ModelAndView("/system/backgroundManagement/aboutUs/dev_edit");
    	WebsiteDev dev = this.aboutUsService.getConfigBanner(form);
    	String id = request.getParameter("id");
    	String isEng = request.getParameter("isEng");// 2代表是新增英文，1代表编辑英文，其他代表中文
    	if("1".equals(isEng)){
    		if(StringUtils.isNotBlank(dev.getDevTextEng())){
    		dev.setImgAddress(dev.getImgAddressEng());
    		dev.setDevDate(dev.getDevDateEng());
    		dev.setDevTitle(dev.getDevTitleEng());
    		dev.setDevText(dev.getDevTextEng());
    		}
    	}
    	modelAndView.addObject("isEng", isEng);
    	modelAndView.addObject("row", dev);
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
    public JSONObject searchAction(HttpServletRequest request, RedirectAttributes attr, @ModelAttribute(BaseDefine.FORM) WebsiteDev form) {
        // 创建分页
        return this.createPage(request, form);
    }

    /**
     * 创建分页机能
     *
     * @param request
     * @param form
     */
    private JSONObject createPage(HttpServletRequest request, WebsiteDev form) {
        JSONObject object = new JSONObject();
        List<WebsiteDev> recordList = new ArrayList<>();

        // 翻页
        HashMap<String, Integer> pageNumSizeMap = Paginator.getPageNumPageSize(request);
        PageHelper.startPage(pageNumSizeMap.get("pageNum"), pageNumSizeMap.get("pageSize"));

        // 取得内容
        ServiceResult<List<WebsiteDev>> recordResult = this.aboutUsService.getRecordList(form);

        if (recordResult != null) {
        	List<WebsiteDev> aaa = recordResult.getResult();
			PageInfo paginator = new PageInfo(aaa);
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
                    String finalName = "res"+fileNameAuto;
                    try{
                        ReduceImage.resize(filePath,fileDirPath+finalName,1d,0.8f);
                    }catch (Exception e){
                        resultBean.setResult(uploadPath + tempPath+fileNameAuto);
                        resultBean.setSuccess(true);
                        resultBean.setCode("0");
                        resultBean.setMessage("文件上传成功");
                    }
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
     *//*
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
    
    *//**
     * 保存  企业介绍
     */
    @ResponseBody
    @RequestMapping(value = "saveAction")
    public ServiceResult<JSONObject> saveAction(HttpServletRequest request, WebsiteIntroduce form) {
    	ServiceResult<JSONObject> ret = new ServiceResult<JSONObject>();
    	ServiceResult<WebsiteIntroduce> recordResult = this.aboutUsService.insertNew(form);
    	
    	ret.setSuccess(recordResult.getSuccess());
    	ret.setMessage(recordResult.getMessage());
    	return ret;
    }
    
    /**
     * 保存  发展规模
     */
    @ResponseBody
    @RequestMapping(value = "saveScoAction")
    public ServiceResult<JSONObject> saveScoAction(HttpServletRequest request, @ModelAttribute ExtWebsiteScopeModel form) {
    	//清空表中数据，再插入新数据
    	extWebsiteScopeMapper.delete(1);
    	List<WebsiteScope> websiteScopeList = null;
    	websiteScopeList=JSONObject.parseArray(form.getConfigVisitJson(), WebsiteScope.class);
    	for(int i=0;i<websiteScopeList.size();i++){
    		WebsiteScope ws = new WebsiteScope();
    		ws.setYear(websiteScopeList.get(i).getYear());
    		ws.setFgsCount(websiteScopeList.get(i).getFgsCount());
    		ws.setKhCount(websiteScopeList.get(i).getKhCount());
    		ws.setRyCount(websiteScopeList.get(i).getRyCount());
    		ws.setShow("1");
    		websiteScopeMapper.insert(ws);
    	}
    	ServiceResult<JSONObject> ret = new ServiceResult<JSONObject>();
    	ret.setSuccess(true);
    	ret.setMessage("保存成功");
    	return ret;
    }
    
    /**
     * 保存   编辑   发展历程
     */
    @ResponseBody
    @RequestMapping(value = "saveUsAction")
    public ServiceResult<JSONObject> saveUsAction(HttpServletRequest request, WebsiteDev form) {
    	ServiceResult<JSONObject> ret = new ServiceResult<JSONObject>();
    	try {  
    		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
    		Date date = df.parse(form.getDevDate());
            long ts = date.getTime();
            form.setDevDate(String.valueOf(ts)); 
         } catch (Exception e) {  
             e.printStackTrace();  
         } 
    	String isEng = request.getParameter("isEng");// 2代表是新增英文，1代表编辑英文，其他代表中文
    	if("1".equals(isEng) || "2".equals(isEng)){
    		form.setImgAddressEng(form.getImgAddress());
    		form.setDevDateEng(form.getDevDate());
    		form.setDevTitleEng(form.getDevTitle());
    		form.setDevTextEng(form.getDevText());
    		form.setImgAddress(null);
    		form.setDevDate(null);
    		form.setDevText(null);
    		form.setDevTitle(null);
    		form.setHasEng("3");
    	}
    	ServiceResult<WebsiteDev> recordResult = this.aboutUsService.updateDevNew(form);
    	
    	ret.setSuccess(recordResult.getSuccess());
    	ret.setMessage(recordResult.getMessage());
    	return ret;
    }
   /**
     * 删除banner
     */
    @ResponseBody
    @RequestMapping(value = "deleteAction")
    public ServiceResult<JSONObject> deleteAction(HttpServletRequest request, WebsiteDev form) {
    	ServiceResult<JSONObject> ret = new ServiceResult<JSONObject>();
    	form.setUpdateUserId(SessionUtils.getLoginUserInfo().getUserId());
    	form.setUpdateUserName(SessionUtils.getLoginUserInfo().getRealName());
    	ServiceResult<WebsiteDev> recordResult = this.aboutUsService.deleteAction(form);
    	ret.setSuccess(recordResult.getSuccess());
    	ret.setMessage(recordResult.getMessage());
    	return ret;
    }
    
    /**
     * 检查年份唯一性
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "ajaxCheckAction", method = RequestMethod.POST)
    public int ajaxCheckAction(HttpServletRequest request,@RequestParam String year) {
        String id = request.getParameter("id");
        String param = request.getParameter("param");
        
        // 检查角色名称唯一性
        ServiceResult<Integer> result = aboutUsService.count(id,year);
        int cnt = result.getResult();
        return cnt;
    }
    
    
    
    
    
    
    
    
    

}

