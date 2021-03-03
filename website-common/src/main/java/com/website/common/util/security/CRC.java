package com.website.common.util.security;

/**
 * Created by hanQ on 2017/4/14.
 */

public class CRC {

    /*根据字符串生成CRC*/
    public static final String generate(String signData) {
        java.util.zip.CRC32 crc = new java.util.zip.CRC32();
        crc.update(signData.getBytes());
        long sign = crc.getValue();
        String value = sign + "" + signData.length();
        return value;
    }

}
