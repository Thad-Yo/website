package com.website.web.system.recruit;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.website.common.util.bean.ServiceResult;
import com.website.common.util.properties.PropertyUtil;
import com.website.mybatis.bean.auto.HrConfigPosition;
import com.website.mybatis.bean.ext.ExtConfig;
import com.website.service.impl.BaseServiceImpl;
import com.website.service.recruit.WebsiteConfigPositionService;
import com.website.service.recruit.WebsiteRecruitPositionService;

public class HrconfigTask extends BaseServiceImpl{
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(HrconfigTask.class);
	 
	@Autowired
    WebsiteRecruitPositionService websiteRecruitPositionService;
    @Autowired
    WebsiteConfigPositionService websiteConfigPositionService;
    
	public void Hrconfig() {
		 
		ServiceResult<String> serviceStr = new ServiceResult<>();
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
           ExtConfig config = JSON.parseObject(str, ExtConfig.class);
           //先删除全部数据 再插入
           this.websiteRecruitPositionService.delete("");
           for (HrConfigPosition hrConfigPosition : config.getResult()) {
           	this.websiteRecruitPositionService.insertHrRecord(hrConfigPosition);
			}
       } catch (Exception e) {
           serviceStr.setSuccess(false);
           serviceStr.setMessage("获取Hr数据失败，请稍后再试");
           e.printStackTrace();
       }
	 }
}
