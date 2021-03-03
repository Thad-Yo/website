package com.website.admin.system.aboutus;

import java.io.File;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.website.common.util.image.ReduceImage;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alibaba.fastjson.JSONObject;
import com.website.admin.base.BaseDefine;
import com.website.common.util.bean.ServiceResult;
import com.website.common.util.date.DateUtils;
import com.website.common.util.date.GetDate;
import com.website.common.util.file.FileUtils;
import com.website.common.util.properties.PropertyUtil;
import com.website.common.util.session.LoginUserInfo;
import com.website.common.util.session.SessionUtils;
import com.website.mybatis.bean.auto.system.CMUser;
import com.website.mybatis.bean.auto.system.CTAttachment;
import com.website.mybatis.bean.ext.ExtWebsiteConfigBannerModel;
import com.website.mybatis.bean.ext.system.ExtAttachment;
import com.website.service.AttachmentService;

@Controller
@RequestMapping("/system/aboutus/partnersController")
public class PartnersController {
	

	@Autowired
	private AttachmentService attachmentService;
	/**
     * 画面初始化
     *
     * @param request
     * @param form
     * @return
     */
    @RequestMapping(value = "init")
    public ModelAndView init(HttpServletRequest request, RedirectAttributes attr, @ModelAttribute(BaseDefine.FORM) ExtWebsiteConfigBannerModel form) {
        ModelAndView modelAndView = new ModelAndView("/system/aboutUs/partners/partners");
        List<CTAttachment> list = getImg();
        modelAndView.addObject("listCtattchment", list);
        modelAndView.addObject("count", list.size());
        return modelAndView;
    }
    private List<CTAttachment> getImg(){
    	ExtAttachment ctattachment = new ExtAttachment();
    	ctattachment.setFileId("partnersfile");
    	ctattachment.setSort("id");
    	ctattachment.setOrder("desc");
    	List<CTAttachment> list = attachmentService.getRecordList(ctattachment).getResult();
    	return list;
    }
    /**
     * 图片导入
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "importAction", produces = BaseDefine.JSON)
    public ServiceResult<JSONObject> uploadAction(HttpServletRequest request,HttpServletResponse response){
    	ServiceResult<JSONObject> resultBean = new ServiceResult<JSONObject>();
    	ShiroHttpServletRequest shiroRequest = (ShiroHttpServletRequest) request;
    	CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        MultipartFile multipartFile = null;
        try {
        	MultipartHttpServletRequest multipartRequest = commonsMultipartResolver.resolveMultipart((HttpServletRequest) shiroRequest.getRequest());
        	Iterator<String> itr = multipartRequest.getFileNames();
        	while (itr.hasNext()) {
        		multipartFile = multipartRequest.getFile(itr.next());
        		// 文件名
        		String fileName = multipartFile.getOriginalFilename().split("\\.")[0]+"_"+GetDate.getServerDateTime(8, new Date())+"."+multipartFile.getOriginalFilename().split("\\.")[1];
        		// 文件扩展名
        		final String suffix = FileUtils.getSuffix(multipartFile.getOriginalFilename());
        		// 文件大小
        		final long fileSize = multipartFile.getSize();
        		// 保存路径
        		final String bathPath = PropertyUtil.getSystemResourcesPropertieValue("file.basepath");
        		final String uploadPath = PropertyUtil.getSystemResourcesPropertieValue("file.uploadpath");
        		final String tempPath = "partners/";
        		final String fileDirPath = bathPath + uploadPath + tempPath;
        		final String filePath = fileDirPath + fileName;
        		System.out.println("文件保存路径为:" + filePath);
        		File file = new File(fileDirPath);
        		if (!file.exists()) {
                    file.mkdirs();
                }
        		boolean saveFlag = FileUtils.SaveFileByPhysicalDir(filePath, multipartFile.getInputStream());
        		String finalPath = filePath;
				String finalName = "";
        		if (saveFlag) {
					finalName = fileName;
					finalPath = fileDirPath + finalName;
//					try{
//						ReduceImage.resize(filePath,finalPath,1d,0.8f);
//					}catch (Exception e){
//						// 用户信息
//						LoginUserInfo userInfo = SessionUtils.getLoginUserInfo();
//						CMUser user = new CMUser();
//						user.setUserId(userInfo.getUserId());
//						ExtAttachment ctattachment = new ExtAttachment();
//						ctattachment.setFileId("partnersfile");
//						ctattachment.setFileName(fileName);
//						ctattachment.setItemId("");
//						ctattachment.setAttType("");
//						ctattachment.setFileType("1");
//						ctattachment.setExtension(suffix);
//						ctattachment.setFileSize(fileSize);
//						ctattachment.setSavePath(filePath);
//						ctattachment.setDelFlag("0");
//						ctattachment.setCreateUserCd(user.getUserId());
//						ctattachment.setUpdateUserCd(user.getUserId());
//						ctattachment.setUpdateDate(DateUtils.getNowServerDate());
//						attachmentService.insertRecord(user, ctattachment);
//						resultBean.setSuccess(true);
//						resultBean.setCode("0");
//						resultBean.setMessage("文件上传成功");
//					}
        			resultBean.setSuccess(true);
        			resultBean.setCode("0");
        			resultBean.setMessage("文件上传成功");
        		} else {
        			resultBean.setSuccess(false);
        			resultBean.setCode("1");
        			resultBean.setMessage("文件上传失败");
        		}
        		// 用户信息
        		LoginUserInfo userInfo = SessionUtils.getLoginUserInfo();
        		CMUser user = new CMUser();
        		user.setUserId(userInfo.getUserId());
                ExtAttachment ctattachment = new ExtAttachment();
                ctattachment.setFileId("partnersfile");
                ctattachment.setFileName(fileName);
                ctattachment.setItemId("");
                ctattachment.setAttType("");
                ctattachment.setFileType("1");
                ctattachment.setExtension(suffix);
                ctattachment.setFileSize(fileSize);
                ctattachment.setSavePath(finalPath);
                ctattachment.setDelFlag("0");
                ctattachment.setCreateUserCd(user.getUserId());
                ctattachment.setUpdateUserCd(user.getUserId());
                ctattachment.setUpdateDate(DateUtils.getNowServerDate());
                attachmentService.insertRecord(user, ctattachment);
        	}
		} catch (Exception e) {
			resultBean.setSuccess(false);
            resultBean.setCode("1");
            resultBean.setMessage("文件上传失败");
		}
    	return resultBean;
    } 
    @ResponseBody
    @RequestMapping("imgDelete")
    public ServiceResult<JSONObject> imgDelete(String id){
    	ServiceResult<JSONObject> resultBean = new ServiceResult<JSONObject>();
    	ExtAttachment record = null;
    	File file = null;
    	try{
    		String[] idArr = id.split(",");
    		for (String str : idArr) {//删除附件表
    			record = new ExtAttachment();
    			record.setId(Integer.parseInt(str));
    			CTAttachment cat = attachmentService.getRecord(record).getResult();
    			if(null != cat){
    				attachmentService.deleteRecordByid(cat.getId());
    				//删除图片文件
    				file = new File(cat.getSavePath());
    				if(file.exists()){
    					file.delete();
    				}
    			}
			}
    		resultBean.setSuccess(true);
			resultBean.setCode("0");
			resultBean.setMessage("文件删除成功");
    	}catch (Exception e) {
    		resultBean.setSuccess(false);
			resultBean.setCode("0");
			resultBean.setMessage("文件删除失败");
		}
    	return resultBean;
    }
}
