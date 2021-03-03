package com.website.common.util.string;

import com.website.common.util.validator.Validator;

public class GetterUtil {

    /**
     * 取得String
     *
     * @param obj
     * @return
     */
    public static String getString(Object obj) {
        if (Validator.isNull(obj)) {
            return "";
        }
        return String.valueOf(obj);
    }

    /**
     * 取得double
     *
     * @param obj
     * @return
     */
    public static double getDouble(Object obj) {
        if (Validator.isNull(obj)) {
            return 0.0;
        }
        try {
            return Double.valueOf(String.valueOf(obj));
        } catch (Exception e) {
            return 0.0;
        }
    }

    /**
     * 取得long
     *
     * @param obj
     * @return
     */
    public static long getLong(Object obj) {
        if (Validator.isNull(obj)) {
            return 0;
        }

        try {
            return Long.valueOf(String.valueOf(obj));
        } catch (Exception e) {
            return 0;
        }

    }

    /**
     * 取得int
     *
     * @param obj
     * @return
     */
    public static int getInteger(Object obj) {
        if (Validator.isNull(obj)) {
            return 0;
        }

        try {
            return Integer.valueOf(String.valueOf(obj));
        } catch (Exception e) {
            return 0;
        }
    }
}
