/*
 * Copyright 2015-2016 the original author or authors..
 *
 * Licensed under the 青岛高软盛信息技术有限公司 License, Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.gogtz.com/licenses/LICENSE-1.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 */
package com.website.common.util.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期类型的格式转换.
 *
 * @author GOGTZ-Z
 * @version 0.0.1
 * @since 1.0
 */
public class DateFormat {

    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String YYYY__MM__DD = "yyyy年MM月dd日";

    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String YYYY__MM__DD__HH__MM__SS = "yyyy年MM月dd日 HH时mm分ss秒";

    public static final String YYYYMMDD = "yyyyMMdd";

    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    public static final String YYYYMMDDHHMMSSSS = "yyyyMMddHHmmssSS";

    public static final String HH_MM = "HH:mm";
    public static final String HH_MM_SS = "HH:mm:ss";

    public static final String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";

    /**
     * <p>
     * 将日期Date格式转换为字符串格式
     * </p>
     *
     * @param data
     * @param format
     * @return
     */
    public static String dateToString(Date data, String format) {
        SimpleDateFormat sformat = new SimpleDateFormat(format);
        return sformat.format(data);
    }

    /**
     * <p>
     * 将日期字符串格式转换为Date格式
     * </p>
     *
     * @param dateString
     * @return
     */
    public static Date stringToDate(String dateString) {
        SimpleDateFormat sformat = new SimpleDateFormat(YYYY_MM_DD_HH_MM);
        Date date = null;
        try {
            date = sformat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * <p>
     * 将日期字符串格式转换为Date格式
     * </p>
     *
     * @param data
     * @param format
     * @return
     */
    public static Date stringToDate(String dateString, String format) {
        SimpleDateFormat sformat = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = sformat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * <p>
     * 将日期Date格式转换为Calendar格式
     * </p>
     *
     * @param date
     * @return Calendar
     */
    public static Calendar dateToCalendar(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    /**
     * <p>
     * 将日期字符串格式转换为Calendar格式
     * </p>
     *
     * @param date
     * @return Calendar
     */
    public static Calendar dateToCalendar(String dateString) {
        Date date = DateFormat.stringToDate(dateString, DateFormat.YYYY_MM_DD_HH_MM_SS);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    /**
     * <p>
     * 时间戳转换为字符串
     * </p>
     *
     * @param timeParam
     * @param format
     * @return
     */
    public static String timestampToString(long timeParam, String format) {
        if (String.valueOf(timeParam).length() == 10) {
            timeParam = timeParam * 1000;
        }
        return DateFormat.dateToString(new Date(timeParam), format);
    }

    /**
     * <p>
     * 时间戳转换为字符串
     * </p>
     *
     * @param timeParam
     * @param format
     * @return
     */
    public static String timestampToString(String timeParam, String format) {
        long time = Long.valueOf(timeParam);
        if (String.valueOf(timeParam).length() == 10) {
            time = time * 1000;
        }
        return DateFormat.dateToString(new Date(time), format);
    }

    /**
     * <p>
     * 时间戳转换为日期
     * </p>
     *
     * @param timeParam
     * @param format
     * @return
     */
    public static Date timestampToDate(long timeParam) {
        if (String.valueOf(timeParam).length() == 10) {
            timeParam = timeParam * 1000;
        }
        return new Date(timeParam);
    }

    /**
     * <p>
     * 获得时间开始 例：传入 2015-12-03 返回 2015-12-03 00:00:00
     * </p>
     *
     * @param curDate
     * @return
     */
    public static String getDayStart(String curDate) {
        return curDate + " 00:00:00";
    }

    /**
     * <p>
     * 获得时间结束 例：传入 2015-12-03 返回 2015-12-03 23:59:59
     * </p>
     *
     * @param curDate
     * @return
     */
    public static String getDayEnd(String curDate) {
        return curDate + " 23:59:59";
    }


    public static String getTermHour(Integer nextInviteHour) {
        String timeStr = "";
        if (nextInviteHour == 6) {
            timeStr = " 6:00-7:00";
        } else if (nextInviteHour == 7) {
            timeStr = " 7:00-8:00  ";
        } else if (nextInviteHour == 8) {
            timeStr = " 8:00-9:00  ";
        } else if (nextInviteHour == 9) {
            timeStr = " 9:00-10:00 ";
        } else if (nextInviteHour == 10) {
            timeStr = " 10:00-11:00";
        } else if (nextInviteHour == 11) {
            timeStr = " 11:00-12:00";
        } else if (nextInviteHour == 12) {
            timeStr = " 12:00-13:00";
        } else if (nextInviteHour == 13) {
            timeStr = " 13:00-14:00";
        } else if (nextInviteHour == 14) {
            timeStr = " 14:00-15:00";
        } else if (nextInviteHour == 15) {
            timeStr = " 15:00-16:00";
        } else if (nextInviteHour == 16) {
            timeStr = " 16:00-17:00";
        } else if (nextInviteHour == 17) {
            timeStr = " 17:00-18:00";
        } else if (nextInviteHour == 18) {
            timeStr = " 18:00-19:00";
        } else if (nextInviteHour == 19) {
            timeStr = " 19:00-20:00";
        } else if (nextInviteHour == 20) {
            timeStr = " 20:00-21:00";
        } else if (nextInviteHour == 21) {
            timeStr = " 21:00-22:00";
        } else if (nextInviteHour == 22) {
            timeStr = " 22:00-23:00";
        } else if (nextInviteHour == 23) {
            timeStr = " 23:00-24:00";
        } else {
            timeStr = "";
        }
        return timeStr;
    }
}
