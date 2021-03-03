package com.website.common.util.http;

import com.website.common.util.string.StringPool;
import com.website.common.util.validator.Validator;

public class HttpUtil {
    public static String encodeURL(String url) {
        return encodeURL(url, false);
    }

    public static String encodeURL(String url, boolean escapeSpaces) {
        if (Validator.isNull(url)) {
            return url;
        }

        return URLCodec.encodeURL(url, StringPool.UTF8, escapeSpaces);
    }
}
