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

import java.util.Calendar;
import java.util.Date;

/**
 * 日期类型的计算
 *
 * @author GOGTZ-Z
 * @since 1.0
 * @version 0.0.1
 */
public class DateCalculate {

	/**
	 * <p>
	 * 获得指定日期的周的某一天
	 * </p>
	 *
	 * @param date
	 * @param count
	 *            1:周日 2:周一.....7:周六
	 * @return
	 */
	public static Date getWeekDay(Date date, int count) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_WEEK, count);
		return calendar.getTime();
	}

	/**
	 * 获取指定日期的月份的第一天
	 *
	 * @param date
	 * @return
	 */
	public static Date getCurrentMonthStartDate(Date date) {
		Calendar calander = Calendar.getInstance();
		calander.setTime(date);
		calander.set(Calendar.DATE, 1);
		return calander.getTime();
	}

	/**
	 * 获取指定日期的月份的最后一天
	 *
	 * @param date
	 * @return
	 */
	public static Date getCurrentMonthEndDate(Date date) {
		Calendar calander = Calendar.getInstance();
		calander.setTime(date);
		calander.set(Calendar.DATE, calander.getActualMaximum(Calendar.DAY_OF_MONTH));
		return calander.getTime();
	}

	/**
	 * 当前指定日期的季度的开始时间
	 *
	 * @param date
	 * @return
	 */
	public Date getCurrentQuarterStartDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int currentMonth = calendar.get(Calendar.MONTH) + 1;
		Date now = null;
		try {
			if (currentMonth >= 1 && currentMonth <= 3)
				calendar.set(Calendar.MONTH, 0);
			else if (currentMonth >= 4 && currentMonth <= 6)
				calendar.set(Calendar.MONTH, 3);
			else if (currentMonth >= 7 && currentMonth <= 9)
				calendar.set(Calendar.MONTH, 4);
			else if (currentMonth >= 10 && currentMonth <= 12)
				calendar.set(Calendar.MONTH, 9);
			calendar.set(Calendar.DATE, 1);
			now = calendar.getTime();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}

	/**
	 * 当前指定日期的季度的结束时间
	 *
	 * @param date
	 * @return
	 */
	public Date getCurrentQuarterEndDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int currentMonth = calendar.get(Calendar.MONTH) + 1;
		Date now = null;
		try {
			if (currentMonth >= 1 && currentMonth <= 3) {
				calendar.set(Calendar.MONTH, 2);
				calendar.set(Calendar.DATE, 31);
			} else if (currentMonth >= 4 && currentMonth <= 6) {
				calendar.set(Calendar.MONTH, 5);
				calendar.set(Calendar.DATE, 30);
			} else if (currentMonth >= 7 && currentMonth <= 9) {
				calendar.set(Calendar.MONTH, 8);
				calendar.set(Calendar.DATE, 30);
			} else if (currentMonth >= 10 && currentMonth <= 12) {
				calendar.set(Calendar.MONTH, 11);
				calendar.set(Calendar.DATE, 31);
			}
			now = calendar.getTime();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}

	/**
	 * 日期加减
	 *
	 * @param before
	 *            几天前或几天后，若是几天前，则为负值
	 * @return
	 */
	public static Date calculateCurrentDay(Date date, int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, days);
		Date result = calendar.getTime();
		return result;
	}

	public static void main(String[] args) {
		System.out.println(DateFormat.dateToString(getWeekDay(new Date(), 7), DateFormat.YYYY_MM_DD_HH_MM_SS));
		;
	}
}
