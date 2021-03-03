package com.website.common.util.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

public class UploadUtils {
    @SuppressWarnings("unused")
    private static Logger logger = LoggerFactory.getLogger(UploadUtils.class);

    /**
     * 将ShiroHttpServletRequest转换成MultipartHttpServletRequest用于上传
     *
     * @param request
     * @return
     */
    public static MultipartHttpServletRequest getMultipartHttpServletRequest(HttpServletRequest request) {
        ShiroHttpServletRequest shiroRequest = (ShiroHttpServletRequest) request;
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        MultipartHttpServletRequest multipartRequest = commonsMultipartResolver.resolveMultipart((HttpServletRequest) shiroRequest.getRequest());
        return multipartRequest;
    }

    /**
     * 将上传的文件写入磁盘
     *
     * @param fileMap
     * @param filePath
     * @param newFileName
     * @throws IOException
     */
    public static String uploadFile(Map<String, MultipartFile> fileMap, String filePath, String newFileName) throws IOException {
        String originalFileName = null;
        String uploadFileLocation = "";
        for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
            MultipartFile mf = entity.getValue();
            originalFileName = mf.getOriginalFilename();
            String fileExt = originalFileName.substring(originalFileName.lastIndexOf(".") + 1).toLowerCase();

            // 创建文件夹
            File imageFile = new File(filePath);
            if (!imageFile.exists()) {
                imageFile.mkdirs();
            }
            uploadFileLocation = filePath + "\\" + newFileName + "." + fileExt;
            if (uploadInputStream(mf.getInputStream(), uploadFileLocation)) {
                System.out.println(" ------- image upload success");
            }
        }
        return uploadFileLocation;
    }

    /**
     * 将上传的文件写入磁盘
     *
     * @param mf
     * @param filePath
     * @param newFileName
     * @throws IOException
     */
    public static JSONObject uploadFile(MultipartFile mf, String filePath, String newFileName) throws IOException {
        String originalFileName = null;
        String uploadFileLocation = "";
        originalFileName = mf.getOriginalFilename();
        String fileExt = originalFileName.substring(originalFileName.lastIndexOf(".") + 1).toLowerCase();

        // 创建文件夹
        File imageFile = new File(filePath);
        if (!imageFile.exists()) {
            imageFile.mkdirs();
        }
        uploadFileLocation = filePath + File.separator + newFileName + "." + fileExt;
        if (uploadInputStream(mf.getInputStream(), uploadFileLocation)) {
            System.out.println(" ------- image upload success");
        }
        JSONObject obj = new JSONObject();
        obj.put("realFileName", newFileName + "." + fileExt);
        return obj;
    }

    /**
     * @Title: htmlUpload @param @param inputStream 传进一个流 @param @param
     * uploadFile 服务端输出的路径和文件名 @return boolean 返回类型 @throws
     */
    public static boolean uploadInputStream(InputStream inputStream, String uploadFile) {
        FileOutputStream output = null;
        try {

            byte[] buff = new byte[4096]; // 缓冲区
            output = new FileOutputStream(uploadFile); // 输出流
            int bytecount = 1;
            while ((bytecount = inputStream.read(buff, 0, 4096)) != -1) { // 当input.read()方法，不能读取到字节流的时候，返回-1
                output.write(buff, 0, bytecount); // 写入字节到文件
            }
            output.flush();
            output.close();

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            if (output != null) {
                try {
                    output.flush();
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * <b>function:</b>处理后的系统文件路径
     *
     * @param path 文件路径
     * @return 返回处理后的路径
     * @author hoojo
     * @createDate Oct 10, 2010 12:49:31 AM
     */
    public static String getDoPath(String path) {
        path = path.replace("\\", "/");
        String lastChar = path.substring(path.length() - 1);
        if (!"/".equals(lastChar)) {
            path += "/";
        }
        return path;
    }

    /**
     * <b>function:</b> 传入一个文件名，得到这个文件名称的后缀
     *
     * @param fileName 文件名
     * @return 后缀名
     * @author hoojo
     * @createDate Oct 9, 2010 11:30:46 PM
     */
    public static String getSuffix(String fileName) {
        int index = fileName.lastIndexOf(".");
        if (index != -1) {
            String suffix = fileName.substring(index);// 后缀
            return suffix;
        } else {
            return null;
        }
    }
}
