/**
 * Description:利用poi导出excel
 * Copyright: Copyright (HYJF Corporation)2015
 * Company: HYJF Corporation
 *
 * @author: 王坤
 * @version: 1.0
 * Created at: 2015年11月26日 下午6:47:27
 * Modification History:
 * Modified by :
 */

package com.website.common.util.file;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @param <T> 应用泛型，代表任意一个符合javabean风格的类
 *            注意这里为了简单起见，boolean型的属性xxx的get器方式为getXxx(),而不是isXxx()
 *            byte[]表jpg格式的图片数据
 */
public class ExportExcel2<T> implements Serializable {

    /**
     * serialVersionUID:序列化id
     */

    private static final long serialVersionUID = -5142024015171582474L;

    /**
     * 创建导出标题
     *
     * @param titles
     * @param sheetName
     * @return
     */
    public static HSSFSheet createHSSFWorkbookTitle(HSSFWorkbook workbook, String[] titles, String sheetName) {

        // 生成一个表格
        HSSFSheet sheet = workbook.createSheet(sheetName);
        Row row = sheet.createRow(0);
        for (int celLength = 0; celLength < titles.length; celLength++) {
            // 创建相应的单元格
            Cell cell = row.createCell(celLength);
            cell.setCellValue(titles[celLength]);
        }

        return sheet;
    }

    /**
     * 创建导出标题
     *
     * @param titles
     * @param sheetName
     * @return
     */
    public static HSSFWorkbook createHSSFWorkbookInfo(String[] titles, List<Map<String, String>> infoList, String sheetName) {
        // 生成一个表格
        XSSFWorkbook xBook = new XSSFWorkbook();// 2007版本用此workbook解析
        HSSFWorkbook workbook = new HSSFWorkbook();
        int rowNumber = 0;
        HSSFSheet sheet = workbook.createSheet(sheetName);

        CellStyle style = workbook.createCellStyle();
        DataFormat format = workbook.createDataFormat();
        style.setDataFormat(format.getFormat("@"));

        Row row = sheet.createRow(rowNumber);
        for (int celLength = 0; celLength < titles.length; celLength++) {
            // 创建相应的单元格
            Cell cell = row.createCell(celLength);
            cell.setCellValue(titles[celLength]);

            sheet.setDefaultColumnStyle(celLength, style);
        }

        if (infoList != null && infoList.size() > 0) {
            for (Map<String, String> info : infoList) {
                rowNumber++;
                row = sheet.createRow(rowNumber);
                for (int celLength = 0; celLength < titles.length; celLength++) {
                    // 创建相应的单元格
                    Cell cell = row.createCell(celLength);
                    cell.setCellValue(info.get(titles[celLength]));

                    sheet.setDefaultColumnStyle(celLength, style);
                }
            }
        }

        return workbook;
    }

    /**
     * 输出附件
     *
     * @param fileName
     * @return
     */
    public static void writeExcelFile(HttpServletRequest request, HttpServletResponse response, HSSFWorkbook workbook, String fileName) {
        // 根据列名填充相应的数据
        ServletOutputStream out = null;
        try {
            out = response.getOutputStream();
            response.reset();
            response.setContentType("application/msexcel;charset=utf-8");
            //response.setHeader("content-disposition", "attachment;filename=" + new String((fileName).getBytes("UTF-8"), "ISO8859-1"));
            String userAgent = request.getHeader("user-agent");
            if (userAgent != null && userAgent.indexOf("Edge") >= 0 ) {
            	fileName = URLEncoder.encode(fileName, "UTF8"); 
            }else if (userAgent.indexOf("Firefox") >= 0 || userAgent.indexOf("Chrome") >= 0
                    || userAgent.indexOf("Safari") >= 0) {
                fileName = new String((fileName).getBytes("UTF-8"), "ISO8859-1");
            } else {
                fileName = URLEncoder.encode(fileName, "UTF8"); //其他浏览器
            }
            response.setHeader("content-disposition", "attachment;filename=" + fileName);

            workbook.write(out);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.flush();
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static Date getYYYYMMDDHHMMSSDate(String date) {
        if (StringUtils.isEmpty(date)) {
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return format.parse(date + ":00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getYYYYMMDDDate(Date thisDate) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(thisDate);
    }

    public static Date getStartTime(String date) {
        if (StringUtils.isEmpty(date)) {
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return format.parse(date + " 00:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date getEndTime(String date) {
        if (StringUtils.isEmpty(date)) {
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return format.parse(date + " 23:59:59");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 计算时间
     *
     * @param date
     * @param day
     * @return
     */
    public static Date calDate(Date date, long day) {
        return new Date(date.getTime() + (day + 1) * 24L * 3600000L);
    }


    /**
     * 计算时间
     *
     * @param date
     * @param day
     * @return
     */
    public static String calDateYYYYMMDD(Date date, long day) {
        Date thisDate = calDate(date, day);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(thisDate);
    }

    public static int DAYS = 7;
}