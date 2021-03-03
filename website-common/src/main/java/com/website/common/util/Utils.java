package com.website.common.util;

import com.alibaba.fastjson.JSONObject;
import com.website.common.util.constants.ConstantsUtil;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    /**
     * 取得随机数
     *
     * @param length 长度
     * @return
     */
    public static String getRandomCode(int length) {
        String[] sourceCode = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E",
                "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
                "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u",
                "v", "w", "x", "y", "z"};
        List<String> list = Arrays.asList(sourceCode);
        Collections.shuffle(list);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        String afterShuffle = sb.toString();
        String result = afterShuffle.substring(0, length);
        return result;
    }

    /**
     * 获取主机的ip地址
     *
     * @param request
     * @return
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ipAddress = request.getHeader("x-forwarded-for");
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if (ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")) {
                // 根据网卡取本机配置的IP
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                ipAddress = inet.getHostAddress();
            }
        }
        // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if (ipAddress != null && ipAddress.length() > 15) {
            if (ipAddress.indexOf(",") > 0) {
                ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
            }
        }
        return ipAddress;
    }

    public static String getLocalMac(InetAddress ia) throws SocketException {

        // 获取网卡，获取地址
        byte[] mac = NetworkInterface.getByInetAddress(ia).getHardwareAddress();
        System.out.println("mac数组长度：" + mac.length);
        StringBuffer sb = new StringBuffer("");
        for (int i = 0; i < mac.length; i++) {
            if (i != 0) {
                sb.append("-");
            }
            // 字节转换为整数
            int temp = mac[i] & 0xff;
            String str = Integer.toHexString(temp);
            System.out.println("每8位:" + str);
            if (str.length() == 1) {
                sb.append("0" + str);
            } else {
                sb.append(str);
            }
        }
        return sb.toString().toUpperCase();
    }

    public static String getBrowserName(HttpServletRequest request) {

        String agent = request.getHeader("User-Agent").toLowerCase();
        if (agent.indexOf("msie 7") > 0) {
            return "ie7";
        } else if (agent.indexOf("msie 8") > 0) {
            return "ie8";
        } else if (agent.indexOf("msie 9") > 0) {
            return "ie9";
        } else if (agent.indexOf("msie 10") > 0) {
            return "ie10";
        } else if (agent.indexOf("msie") > 0) {
            return "ie";
        } else if (agent.indexOf("opera") > 0) {
            return "opera";
        } else if (agent.indexOf("opera") > 0) {
            return "opera";
        } else if (agent.indexOf("firefox") > 0) {
            return "firefox";
        } else if (agent.indexOf("webkit") > 0) {
            return "webkit";
        } else if (agent.indexOf("gecko") > 0 && agent.indexOf("rv:11") > 0) {
            return "ie11";
        } else {
            return "Others";
        }

    }

    /**
     * 字符串数组转换成字符串LIST
     *
     * @param strings
     * @return
     */
    public static List<String> stringsToList(String[] strings) {
        List<String> stringList = new ArrayList<String>();
        if (strings != null && strings.length > 0) {
            for (String str : strings) {
                stringList.add(str);
            }
        }
        return stringList;
    }

    /**
     * 骆驼峰结构: 比如gmt_modify ==> gmtModify
     *
     * @param columName
     * @return
     */
    public static String camelName(String columName) {
        char[] chars = columName.toCharArray();
        char[] result = new char[chars.length];
        int curpos = 0;
        boolean upperCaseNext = false;
        for (char ch : chars) {
            if (ch == '_') {
                upperCaseNext = true;
            } else if (upperCaseNext) {
                result[curpos++] = Character.toUpperCase(ch);
                upperCaseNext = false;
            } else {
                result[curpos++] = ch;
            }
        }
        return new String(result, 0, curpos);
    }

    public static JSONObject getResultJson(String flag, Object param) {
        if ("0".equals(flag)) {
            return getSuccessJson(param);
        }
        return getErrorJson(param);
    }

    public static JSONObject getSuccessJson(Object param) {
        JSONObject obj = new JSONObject();
        obj.put("success", "0");
        obj.put("result", param);
        return obj;
    }

    public static JSONObject getErrorJson(Object param) {
        JSONObject obj = new JSONObject();
        obj.put("success", "1");
        obj.put("msg", param);
        return obj;
    }

    public static final char UNDERLINE = '_';

    public static String camelToUnderline(String param) {
        if (param == null || "".equals(param.trim())) {
            return "";
        }
        int len = param.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = param.charAt(i);
            if (Character.isUpperCase(c)) {
                sb.append(UNDERLINE);
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static String underlineToCamel(String param) {
        if (param == null || "".equals(param.trim())) {
            return "";
        }
        int len = param.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = param.charAt(i);
            if (c == UNDERLINE) {
                if (++i < len) {
                    sb.append(Character.toUpperCase(param.charAt(i)));
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static String underlineToCamel2(String param) {
        if (param == null || "".equals(param.trim())) {
            return "";
        }
        StringBuilder sb = new StringBuilder(param);
        Matcher mc = Pattern.compile("_").matcher(param);
        int i = 0;
        while (mc.find()) {
            int position = mc.end() - (i++);
            //String.valueOf(Character.toUpperCase(sb.charAt(position)));
            sb.replace(position - 1, position + 1, sb.substring(position, position + 1).toUpperCase());
        }
        return sb.toString();
    }

    /**
     * 取得第一张图片
     *
     * @param content
     * @return
     */
    public static String getFirstImgUrl(String content) {
        if (StringUtils.isNotBlank(content)) {
            String regex = "src=[\"|\']((\\w+?:?//|\\/|\\w*)[^\"]*?)[\"|\']";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(content);
            while (m.find()) {
                int start = m.start();
                int end = m.end();
                String temp = content.substring(start + 5, end - 1);
                return temp;
            }
        }
        return "";
    }

    /**
     * 分割List
     *
     * @param list     待分割的list
     * @param pageSize 每段list的大小
     * @return List<<List<T>>
     */
    public static <T> List<List<T>> splitList(List<T> list, int pageSize) {
        if (list == null || list.size() == 0) {
            return null;
        }
        int listSize = list.size(); // list的大小
        int page = (listSize + (pageSize - 1)) / pageSize;// 页数
        List<List<T>> listArray = new ArrayList<List<T>>();// 创建list数组,用来保存分割后的list
        for (int i = 0; i < page; i++) { // 按照数组大小遍历
            List<T> subList = new ArrayList<T>(); // 数组每一位放入一个分割后的list
            for (int j = 0; j < listSize; j++) {// 遍历待分割的list
                int pageIndex = ((j + 1) + (pageSize - 1)) / pageSize;// 当前记录的页码(第几页)
                if (pageIndex == (i + 1)) {// 当前记录的页码等于要放入的页码时
                    subList.add(list.get(j)); // 放入list中的元素到分割后的list(subList)
                }
                if ((j + 1) == ((j + 1) * pageSize)) {// 当放满一页时退出当前循环
                    break;
                }
            }
            listArray.add(subList);// 将分割后的list放入对应的数组的位中
        }
        return listArray;
    }
}
