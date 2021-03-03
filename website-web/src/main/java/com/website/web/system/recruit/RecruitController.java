package com.website.web.system.recruit;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.github.pagehelper.StringUtil;
import com.website.common.util.bean.ServiceResult;
import com.website.common.util.constants.ConstantsUtil;
import com.website.common.util.date.DateUtils;
import com.website.common.util.file.FileUtils;
import com.website.common.util.properties.PropertyUtil;
import com.website.common.util.validator.KeyValueBean;
import com.website.mybatis.bean.auto.*;
import com.website.mybatis.bean.auto.system.CMDepartment;
import com.website.mybatis.bean.auto.system.CTAttachment;
import com.website.mybatis.bean.ext.ExtHrResumeModel;
import com.website.mybatis.bean.ext.ExtWebsiteRecruitPositionModel;
import com.website.mybatis.bean.ext.system.AdminMenuBean;
import com.website.mybatis.bean.ext.system.ExtAttachment;
import com.website.mybatis.bean.ext.system.ExtDepartmentModel;
import com.website.service.AttachmentService;
import com.website.service.contactUs.WebsiteFeedbackService;
import com.website.service.maintenance.DepartmentService;
import com.website.service.recruit.WebsiteConfigPositionService;
import com.website.service.recruit.WebsiteRecruitPositionService;
import com.website.web.base.BaseController;
import com.website.web.base.BaseDefine;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/**
 * @Auther: hzm
 * @Date: 2018/6/21 13:48
 * @Description:
 */
@Controller
@RequestMapping(value="/system/recruit")
public class RecruitController extends BaseController {
    @Autowired
    private WebsiteFeedbackService websiteFeedbackService;
    @Autowired
    AttachmentService attachmentService;
    @Autowired
    WebsiteRecruitPositionService websiteRecruitPositionService;
    @Autowired
    WebsiteConfigPositionService websiteConfigPositionService;
    @Autowired
    private DepartmentService departmentService;

    /**
     * 画面初始化
     *
     * @return
     */
    @RequestMapping("init")
    public ModelAndView init(HttpServletRequest request,@ModelAttribute(BaseDefine.FORM) ExtWebsiteRecruitPositionModel form) {
        ModelAndView modelAndView = new ModelAndView("/recruit");
        ExtWebsiteRecruitPositionModel model = new ExtWebsiteRecruitPositionModel();
        List<WebsiteRecruitPosition> list = new ArrayList<>();
        ExtAttachment ctattachment = new ExtAttachment();
        ctattachment.setFileId("workEnvironment");
        ctattachment.setDelFlag("0");
        ctattachment.setSort("id");
        ctattachment.setOrder("desc");
        List<CTAttachment> attachmentlist = attachmentService.getRecordList(ctattachment).getResult();//招聘办公环境

        ServiceResult<List<WebsiteConfigPosition>> configPosition = this.websiteConfigPositionService
                .findConfigPositionList(new WebsiteConfigPosition());//岗位大类

        WebsiteRecruitPosition recruitPosition = new WebsiteRecruitPosition();//招聘职位
        if(StringUtil.isEmpty(form.getRecruitType())){
            recruitPosition.setRecruitType("2");//如果没值，默认是社会招聘
        }else{
            recruitPosition.setRecruitType(form.getRecruitType());
        }
        recruitPosition.setStatus("y");
        ServiceResult<List<WebsiteRecruitPosition>> recruitPositionList = this.websiteRecruitPositionService
                .findRecruitPositionList(recruitPosition);//招聘岗位getRecordAction
        String recruitCity="";
        for(WebsiteRecruitPosition ps:recruitPositionList.getResult()){
            recruitCity = recruitCity+","+ps.getRecruitCity();
            String poArr[] = ps.getRecruitCityName().split(",");
            for(int i = 0;i<poArr.length;i++){
                WebsiteRecruitPosition wp = new WebsiteRecruitPosition();
                BeanUtils.copyProperties(ps, wp);
                wp.setRecruitCity(ps.getRecruitCity().split(",")[i]);
                wp.setRecruitCityName(poArr[i]);
                list.add(wp);
            }
        }
        List ls = new ArrayList();
        String cityArr[] = recruitCity.split(",");
        for(int i =0;i<cityArr.length;i++){
        	if(StringUtils.isNotBlank(cityArr[i])){
        		ls.add(cityArr[i]);
        	}
        }
        model.setCityList(ls);
        ServiceResult<List<WebsiteRecruitPosition>> cityList = this.websiteRecruitPositionService
                .findProvinceList(model);//省份

        modelAndView.addObject("attachmentRecord",attachmentlist);
        modelAndView.addObject("recruitPositionList",recruitPositionList.getResult());
        modelAndView.addObject("recruitPosition",list);
        modelAndView.addObject("configPosition",configPosition.getResult());
        modelAndView.addObject("cityList",cityList.getResult());
        if(StringUtils.isBlank(form.getRecruitType())){
        	modelAndView.addObject("recruitType","2");
        }else{
        	
        	modelAndView.addObject("recruitType",form.getRecruitType());
        }
        return modelAndView;
    }
    /**
     * 画面初始化
     *
     * @return
     */
    @RequestMapping("getCityListAction")
    public ModelAndView getCityList(HttpServletRequest request,@ModelAttribute(BaseDefine.FORM) ExtWebsiteRecruitPositionModel form) {
    	ModelAndView modelAndView = new ModelAndView("/recruit");
    	ExtWebsiteRecruitPositionModel model = new ExtWebsiteRecruitPositionModel();
    	List<WebsiteRecruitPosition> list = new ArrayList<>();
    	
    	WebsiteRecruitPosition recruitPosition = new WebsiteRecruitPosition();//招聘职位
    	if(StringUtil.isEmpty(form.getRecruitType())){
    		recruitPosition.setRecruitType("2");//如果没值，默认是社会招聘
    	}else{
    		recruitPosition.setRecruitType(form.getRecruitType());
    	}
    	recruitPosition.setStatus("y");
    	ServiceResult<List<WebsiteRecruitPosition>> recruitPositionList = this.websiteRecruitPositionService
    			.findRecruitPositionList(recruitPosition);//招聘岗位getRecordAction
    	String recruitCity="";
    	for(WebsiteRecruitPosition ps:recruitPositionList.getResult()){
    		recruitCity = recruitCity+","+ps.getRecruitCity();
    	}
    	List ls = new ArrayList();
    	String cityArr[] = recruitCity.split(",");
    	for(int i =0;i<cityArr.length;i++){
    		if(StringUtils.isNotBlank(cityArr[i])){
    			ls.add(cityArr[i]);
    		}
    	}
    	model.setCityList(ls);
    	ServiceResult<List<WebsiteRecruitPosition>> cityList = this.websiteRecruitPositionService
    			.findProvinceList(model);//省份
    			
    	modelAndView.addObject("listCity",cityList.getResult());
    	return modelAndView;
    }
    /**
     * 获取满足条件的记录
     *
     * @param request
     * @param form
     * @return
     */
    @RequestMapping(value = "getRecordAction")
    public ServiceResult<List<WebsiteRecruitPosition>> getRecordAction(HttpServletRequest request,@ModelAttribute(BaseDefine.FORM) ExtWebsiteRecruitPositionModel form) {
        ServiceResult<List<WebsiteRecruitPosition>> res = new ServiceResult<>();
        List<WebsiteRecruitPosition> list = new ArrayList<>();
        List<WebsiteRecruitPosition> ls = new ArrayList<>();
        form.setStatus("y");
        form.setDelFlag("0");
        // 取得内容
        ServiceResult<List<WebsiteRecruitPosition>> recordResult = this.websiteRecruitPositionService.getRecordList(form);
        for(WebsiteRecruitPosition ps:recordResult.getResult()){
            String poArr[] = ps.getRecruitCityName().split(",");
            for(int i =0;i<poArr.length;i++){
                WebsiteRecruitPosition wp = new WebsiteRecruitPosition();
                BeanUtils.copyProperties(ps, wp);
                wp.setRecruitCity(ps.getRecruitCity().split(",")[i]);
                wp.setRecruitCityName(poArr[i]);
                list.add(wp);
            }
        }
        if(StringUtils.isEmpty(form.getRecruitCityName())){
            ls=list;
        }else{
            for(WebsiteRecruitPosition wr:list){
                if(form.getRecruitCityName().equals(wr.getRecruitCityName())){
                    ls.add(wr);
                }
            }
        }

        res.setSuccess(recordResult.getSuccess());
        res.setMessage(recordResult.getMessage());
        if(ls != null && ls.size() >0){
        	ls = removeDuplicate(ls);
        }
        res.setResult(ls);
        return res;
    }

    /**
     * 获取满足条件的记录
     *
     * @param request
     * @param form
     * @return
     */
    @RequestMapping(value = "getProvinceRecordAction")
    public ServiceResult<List<WebsiteRecruitPosition>> getProvinceRecord(HttpServletRequest request, @ModelAttribute(BaseDefine.FORM) ExtWebsiteRecruitPositionModel form) {
        ServiceResult<List<WebsiteRecruitPosition>> res = new ServiceResult<>();
        form.setStatus("y");
        form.setDelFlag("0");
        ServiceResult<List<WebsiteRecruitPosition>> recruitPositionList = this.websiteRecruitPositionService
                .findRecruitPositionList(form);//招聘岗位
        String recruitCity="";
        for(WebsiteRecruitPosition ps:recruitPositionList.getResult()){
            recruitCity = recruitCity+","+ps.getRecruitCity();
        }
        List ls = new ArrayList();
        String cityArr[] = recruitCity.split(",");
        for(int i =0;i<cityArr.length;i++){
            ls.add(cityArr[i]);
        }
        ExtWebsiteRecruitPositionModel model = new ExtWebsiteRecruitPositionModel();
        model.setCityList(ls);
        ServiceResult<List<WebsiteRecruitPosition>> cityList = this.websiteRecruitPositionService
                .findProvinceList(model);//省份
        res.setResult(cityList.getResult());
        res.setSuccess(true);
        return res;
    }
    @RequestMapping(value = "postHrResumeAction")
    public ServiceResult<String> postHrResumeAction(HttpServletRequest request, @ModelAttribute(BaseDefine.FORM) ExtHrResumeModel form) throws Exception{
        ServiceResult<String> serviceStr = new ServiceResult<>();
        List<HrResumeEducation> hrResumeEducationList =JSONObject.parseArray(form.getWebResumeEducationList(), HrResumeEducation.class);
        List<HrResumeWork> hrResumeWorkList =JSONObject.parseArray(form.getWebResumeWorkList(), HrResumeWork.class);
        List<HrResumeProject> hrResumeProjectList =JSONObject.parseArray(form.getWebResumeProjectList(), HrResumeProject.class);
        List<HrResumeLanguage> hrResumeLanguageList =JSONObject.parseArray(form.getWebResumeLanguageList(), HrResumeLanguage.class);
        List<HrResumeDuty> hrResumeDutyList =JSONObject.parseArray(form.getWebResumeHonorList(), HrResumeDuty.class);
        List<HrResumeHonor> hrResumeHonorList =JSONObject.parseArray(form.getWebResumeHonorList(), HrResumeHonor.class);
        List<HrResumeBasic> hrResumeBasicList =JSONObject.parseArray(form.getWebResumeBasic(), HrResumeBasic.class);
        List<CTResumeAttachment> ctResumeAttachmentList = new ArrayList<>();
        ExtHrResumeModel model = new ExtHrResumeModel();

        HrResumeBasic hrResumeBasic = new HrResumeBasic();
        if(hrResumeEducationList.size()>0){
            model.setHrResumeEducationList(hrResumeEducationList);
        }
        if(hrResumeWorkList.size()>0){
            model.setHrResumeWorkList(hrResumeWorkList);
        }
        if(hrResumeProjectList.size()>0){
            model.setHrResumeProjectList(hrResumeProjectList);
        }
        if(hrResumeLanguageList.size()>0){
            model.setHrResumeLanguageList(hrResumeLanguageList);
        }
        if(hrResumeDutyList.size()>0){
            model.setHrResumeDutyList(hrResumeDutyList);
        }
        if(hrResumeHonorList.size()>0){
            model.setHrResumeHonorList(hrResumeHonorList);
        }
        if(hrResumeBasicList.size()>0){
            hrResumeBasic = hrResumeBasicList.get(0);
//            hrResumeBasic.setCompanyId("");
            if(StringUtils.isNotEmpty(hrResumeBasic.getCompanyId())){
                ServiceResult<CMDepartment> result = this.websiteRecruitPositionService.findDepartment(Integer.parseInt(hrResumeBasic.getCompanyId()));
                if(result.getResult()!=null){
                    hrResumeBasic.setCompanyId(result.getResult().getDepartmentCd());
                }
            }
        }
        
        if(StringUtils.isNotEmpty(hrResumeBasic.getPhotoPath())){
        	String photoPath = hrResumeBasic.getPhotoPath().replaceAll("websitedata", "hrdata");
        	photoPath = photoPath.replaceAll("attachments", "website");
        	hrResumeBasic.setPhotoPath(photoPath.substring(photoPath.indexOf("website")-1));
        }
        if(StringUtils.isNotEmpty(hrResumeBasic.getAttachmentPath())){
        	String attachPath = hrResumeBasic.getAttachmentPath().replaceAll("websitedata", "hrdata");
        	attachPath = attachPath.replaceAll("attachments", "website");
        	hrResumeBasic.setAttachmentPath(attachPath.substring(attachPath.indexOf("website")-1));
        }
        if(StringUtils.isNotEmpty(hrResumeBasic.getAttachmentPath())){
        	String attachmentPath = hrResumeBasic.getAttachmentPath();
        	String extension = attachmentPath.substring(attachmentPath.lastIndexOf(".")+1);
        	String filename = attachmentPath.substring(attachmentPath.lastIndexOf("/")+1);
        	String attType = "resumeattachment";
        	CTResumeAttachment attachment = new CTResumeAttachment();
        	attachment.setAttType(attType);
        	attachment.setSavePath(attachmentPath);
        	attachment.setExtension(extension);
        	attachment.setFileName(filename);
        	ctResumeAttachmentList.add(attachment);
        }
        if(ctResumeAttachmentList.size()>0){
            model.setCtResumeAttachmentList(ctResumeAttachmentList);
        }
        
        hrResumeBasic.setDelFlag(ConstantsUtil.FLG_NORMAL);
        hrResumeBasic.setApplyDate(String.valueOf(System.currentTimeMillis()/1000));
        ServiceResult<HrResumeBasic> insertResult = this.websiteRecruitPositionService.insert(hrResumeBasic);//插入本地记录
        if(!insertResult.getSuccess()){
        	serviceStr.setSuccess(false);
            serviceStr.setMessage("投递失败，请稍后再试");
            return serviceStr;
        }
        model.setHrResumeBasic(hrResumeBasic);


        //传入中文参数并设置编码格式
        final String bathPath = PropertyUtil.getSystemResourcesPropertieValue("hrServer.host");
        String url =bathPath+"/system/recruitmentManage/resumelist/getHrResumeModel";//hr接口地址

        try {
            URL realUrl = new URL(url);
            HttpURLConnection httpConn = (HttpURLConnection) realUrl.openConnection();
            httpConn.setRequestMethod("POST");
            httpConn.setDoOutput(true);
            httpConn.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
            PrintWriter pw=new PrintWriter(httpConn.getOutputStream());
            String content = URLEncoder.encode(JSON.toJSONString(model),"UTF-8");
            pw.write(content);
            pw.flush();
            pw.close();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    httpConn.getInputStream(), "UTF-8"));
            String line;
            StringBuffer buffer = new StringBuffer();
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
            reader.close();
            httpConn.disconnect();
            String str= buffer.toString();
            if(StringUtils.isNotEmpty(str)){
            	URLEncoder.encode(str,"UTF-8");
            	JSONObject jsonObject = JSONObject.parseObject(str);
            	JSONObject result = (JSONObject) jsonObject.get("result");
            	String resumeNumber = result.get("resumeNumber").toString(); //推送hr成功后获取简历编号
            	hrResumeBasic.setResumeNumber(Long.parseLong(resumeNumber));
            	hrResumeBasic.setDelFlag(ConstantsUtil.FLG_DELETE);
            	this.websiteRecruitPositionService.update(hrResumeBasic);//更新本地记录()
            	serviceStr.setSuccess(true);
            	serviceStr.setMessage("投递成功");
            }else{
            	serviceStr.setSuccess(false);
                serviceStr.setMessage("投递失败，请稍后再试");
            }
           
        } catch (Exception e) {
            serviceStr.setSuccess(false);
            serviceStr.setMessage("投递失败，请稍后再试");
            e.printStackTrace();
        }
        return serviceStr;
    }
    public static List removeDuplicate(List list) {   
        HashSet h = new HashSet(list);   
        list.clear();   
        list.addAll(h);   
        return list;   
    }
    
    /**
     * 获取hr数据并更新
     */
    @ResponseBody
    @RequestMapping(value = "getHrJson", produces = BaseDefine.JSON)
    public String getHrJson(HttpServletRequest request, HttpServletResponse response) {
    	ServiceResult<String> serviceStr = new ServiceResult<>();
    	 /*HrResumeBasic hrResumeBasic = new HrResumeBasic();*/
    	List<HrConfigPosition> config = new ArrayList<HrConfigPosition>();
    	HrConfigPosition model = new HrConfigPosition();
    	//传入中文参数并设置编码格式
        final String bathPath = PropertyUtil.getSystemResourcesPropertieValue("hrServer.host");
        String url =bathPath+"/system/recruitmentManage/resumelist/getHrList";//hr接口地址

        try {
            URL realUrl = new URL(url);
            HttpURLConnection httpConn = (HttpURLConnection) realUrl.openConnection();
            httpConn.setRequestMethod("POST");
            httpConn.setDoOutput(true);
            httpConn.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
            PrintWriter pw=new PrintWriter(httpConn.getOutputStream());
            String content = URLEncoder.encode(JSON.toJSONString(model),"UTF-8");
            pw.write(content);
            pw.flush();
            pw.close();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    httpConn.getInputStream(), "UTF-8"));
            String line;
            StringBuffer buffer = new StringBuffer();
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
            reader.close();
            httpConn.disconnect();
            String str= buffer.toString();
            config = JSON.parseObject(str, List.class);
            //先删除全部数据 再插入
            this.websiteRecruitPositionService.delete("");
            for (HrConfigPosition hrConfigPosition : config) {
            	this.websiteRecruitPositionService.insertHrRecord(hrConfigPosition);
			}
        } catch (Exception e) {
            serviceStr.setSuccess(false);
            serviceStr.setMessage("获取Hr数据失败，请稍后再试");
            e.printStackTrace();
        }
    	
    	return null;
    }
    
    /**
     * 上传文件
     */
    @ResponseBody
    @RequestMapping(value = "uploadAction", produces = BaseDefine.JSON)
    public String uploadAction(HttpServletRequest request, HttpServletResponse response) {
        ServiceResult<JSONObject> resultBean = new ServiceResult<JSONObject>();

        try {
            CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
            MultipartHttpServletRequest multipartRequest = commonsMultipartResolver.resolveMultipart(request);

            Iterator<String> itr = multipartRequest.getFileNames();
            MultipartFile multipartFile = null;

            while (itr.hasNext()) {
                multipartFile = multipartRequest.getFile(itr.next());
                // 文件名
                final String fileName = UUID.randomUUID().toString().replaceAll("-", "") + "_" +multipartFile.getOriginalFilename();
                // 文件扩展名
                final String suffix = FileUtils.getSuffix(multipartFile.getOriginalFilename());
                // 文件大小
                final long fileSize = multipartFile.getSize();
                // 保存路径
                final String bathPath = PropertyUtil.getSystemResourcesPropertieValue("file.basepath");
                final String uploadPath = PropertyUtil.getSystemResourcesPropertieValue("file.uploadpath");
                final String tempPath = "employee/" + DateUtils.DateToString(new Date(), "yyyyMMdd") + "/";
                final String fileDirPath = bathPath + uploadPath + tempPath;
                final String filePath = fileDirPath + fileName;
                FileUtils.CreateDirectory(fileDirPath);

                boolean saveFlag = FileUtils.SaveFileByPhysicalDir(filePath, multipartFile.getInputStream());
                if (saveFlag) {
                    JSONObject result = new JSONObject();
                    result.put("fileName", multipartFile.getOriginalFilename());
                    result.put("extension", suffix);
                    result.put("fileSize", fileSize);
                    result.put("savePath", bathPath + uploadPath + tempPath + fileName);
                    resultBean.setResult(result);
                    resultBean.setSuccess(true);
                    resultBean.setMessage("文件上传成功");
                } else {
                    resultBean.setSuccess(false);
                    resultBean.setMessage("文件上传失败");
                }
            }
        } catch (Exception e) {
            //log.error("", e);
            resultBean.setSuccess(false);
            resultBean.setMessage("文件上传失败");
        }
        return resultBean.toString();
    }
    /**
     * 获取国内催收中心下的各个分公司
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("getDepartmentByDepartmentPCd")
    public ServiceResult<List<ExtDepartmentModel>> getDepartmentByDepartmentPCd(ExtDepartmentModel  form) {
    	String departmentPCd = "f9358fba-c335-4e56-ada5-5b8ea6d5c57a";//国内催收中心的department_cd
        ServiceResult<List<ExtDepartmentModel>> result = this.departmentService.selectDepartmentRes(form, departmentPCd);
        ServiceResult<List<ExtDepartmentModel>> res = new ServiceResult<>();
        res.setResult(result.getResult());
        res.setSuccess(true);
        return res;
    }
    
    /**
     * 得所有招聘岗位
     *
     * @param request
     * @param departmentId 部门id
     */
    @ResponseBody
    @RequestMapping( "getPositionList")
    public ServiceResult<List<HrConfigPosition>> getPositionList(HrConfigPosition form) {
        ServiceResult<List<HrConfigPosition>> selectResult = this.websiteRecruitPositionService.getPositionListByPositionTypeAll(form);
        List<HrConfigPosition> configPosition = new ArrayList<HrConfigPosition>();
        for (HrConfigPosition result : selectResult.getResult()) {
			if(!result.getPositionName().contains("123")&&!result.getPositionName().contains("111")){
				configPosition.add(result);
			}
		}
        ServiceResult<List<HrConfigPosition>> res = new ServiceResult<>();
        res.setResult(configPosition);
        res.setSuccess(true);
        return res;
    }
}
