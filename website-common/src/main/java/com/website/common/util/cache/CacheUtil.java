package com.website.common.util.cache;

import java.util.HashMap;

/**
 * Created by Administrator on 2016/7/13.
 */
public class CacheUtil {
    private static HashMap<String, Object> cache;

    public static Object get(String key) {
        if (cache == null) {
            return null;
        }
        return cache.get(key);
    }

    public static String getString(String key) {
        Object obj = get(key);
        if (obj != null) {
            return obj.toString();
        }
        return null;
    }

    public static void put(String key, Object value) {
        if (cache == null) {
            cache = new HashMap<>();
        }
        cache.put(key, value);
    }

    public static void remove(String key) {
        if (cache == null) {
            cache = new HashMap<>();
        }
        if (cache.containsKey(key)) {
            cache.remove(key);
        }
    }
}
