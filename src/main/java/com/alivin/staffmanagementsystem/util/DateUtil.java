package com.alivin.staffmanagementsystem.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Description:日期处理工具类
 * @Version:1.1.0
 */

public class DateUtil {

	private static final Log Logger = LogFactory.getLog(DateUtil.class);

	public static String dateFormat(Date st) {
		SimpleDateFormat myFmt2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return myFmt2.format(st);
	}

	public static long subDate(Date st1, Date st2) {
		long minutes = 0;
		try {
			if (null != st1 || null != st2) {
				// 这样得到的差值是微秒级别
				long diff = st1.getTime() - st2.getTime();
				minutes = diff / (1000);
			}
		} catch (Exception e) {
			Logger.error("subDate error:", e);
		}
		return minutes;
	}

	public static String getDateFromLong(long lSysTime) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		// 前面的lSysTime是秒数，先乘1000得到毫秒数，再转为java.util.Date类型
		Date dt = new Date(lSysTime * 1000);
		// 得到精确到秒的表示：08/31/2006 21:08:00
		return sdf.format(dt);
	}

	// 比较日期大小
	public static boolean compareDate(Date d1, Date d2) {
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.setTime(d1);
		c2.setTime(d2);

		int result = c1.compareTo(c2);
		if (result >= 0)
			return true;
		else
			return false;
	}

	public static Date parseDateTime(String time) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = sdf.parse(time);
		} catch (ParseException e) {
			Logger.error("parse time error:", e);

		}
		return date;
	}
	public static Date parseDate(String dateString) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			 date = sdf.parse(dateString);
		} catch (Exception e) {
			Logger.error("parse time error:", e);

		}
		return date;
	}
	public static void main(String[] args) {
		
		
		String dateStr = "2020-05-27";
		if(dateStr.length()==10){
			System.out.print(parseDate("2020-05-27"));
		}else{
			System.out.print(parseDateTime("2020-05-27"));
		}
		
	}
	
	public static boolean equalsMonth(String s1, String s2) {
		Date date1 = null;
		Date date2 = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			date1 = sdf.parse(s1);
			date2 = sdf.parse(s2);
			Calendar calendar1 = Calendar.getInstance();
			calendar1.setTime(date1);

			Calendar calendar2 = Calendar.getInstance();
			calendar2.setTime(date2);

			return calendar1.get(Calendar.YEAR) == calendar2.get(Calendar.YEAR) && calendar1.get(Calendar.MONTH) == calendar2.get(Calendar.MONTH);

		} catch (ParseException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static String getYearAndMonth(String dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMM");
		Long fastTime = 0L;
		String yearAndMonth = null;
		try {
			fastTime = sdf.parse(dateStr).getTime();
			yearAndMonth = sdf2.format(new Date(fastTime));
		} catch (ParseException e) {

			e.printStackTrace();
		}
		return yearAndMonth;

	}

	public static boolean isEqualMonth(long fastTime1, long fastTime2) {
		Date d1 = new Date(fastTime1);
		Calendar calendar1 = Calendar.getInstance();
		calendar1.setTime(d1);
		int month1 = calendar1.get(Calendar.MONTH) + 1;
		Date d2 = new Date(fastTime1);
		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(d2);
		int month2 = calendar2.get(Calendar.MONTH) + 1;
		return month1 == month2;
	}

	public static String getDay(Long fastTime) {
		Date date = new Date(fastTime);
		SimpleDateFormat myFmt2 = new SimpleDateFormat("yyyy-MM-dd");
		return myFmt2.format(date);
	}

	public static String getYestoday() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		Date time = cal.getTime();
		return new SimpleDateFormat("yyyy-MM-dd").format(time);
	}

	public static Date getDate(Long fastTime) throws ParseException {
		SimpleDateFormat myFmt2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Long time = new Long(fastTime);
		String d = myFmt2.format(time);
		return myFmt2.parse(d);
	}

	public static String getDayTime(Long fastTime) {
		Date date = new Date(fastTime);
		SimpleDateFormat myFmt2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return myFmt2.format(date);
	}

	public static int getMonthSpce(String startTime, String endTime) {
		int month = 0;
		int result = 0;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Calendar bef = Calendar.getInstance();
			Calendar aft = Calendar.getInstance();
			bef.setTime(sdf.parse(startTime));
			aft.setTime(sdf.parse(endTime));
			result = aft.get(Calendar.MONTH) - bef.get(Calendar.MONTH);
			month = (aft.get(Calendar.YEAR) - bef.get(Calendar.YEAR)) * 12;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return Math.abs(month + result);
	}

	/**
	 * @Title: getFirstDayOfMonth @Description: 获取当前月份的第一天 @param @return
	 *         参数 @return String 返回类型 @throws
	 */
	public static String getFirstDayOfMonth() {
		Calendar cal = Calendar.getInstance();// 获取当前日期
		cal.add(Calendar.MONTH, 0);
		cal.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
		String firstDay = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
		return firstDay;
	}

	public static List<String> getMonthBetween(String minDate, String maxDate) {
		ArrayList<String> result = new ArrayList<String>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");// 格式化为年月

		Calendar min = Calendar.getInstance();
		Calendar max = Calendar.getInstance();
		try {
			min.setTime(sdf.parse(minDate));
			min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);

			max.setTime(sdf.parse(maxDate));
			max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);

			Calendar curr = min;
			while (curr.before(max)) {
				result.add(sdf.format(curr.getTime()));
				curr.add(Calendar.MONTH, 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * @Title: daysBetween @Description: 天数差值 @param @param smdate @param @param
	 *         bdate @param @return @param @throws ParseException 参数 @return int
	 *         返回类型 @throws
	 */
	public static int daysBetween(String smdate, String bdate) {
		long between_days = -1;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal = Calendar.getInstance();
			cal.setTime(sdf.parse(smdate));
			long time1 = cal.getTimeInMillis();
			cal.setTime(sdf.parse(bdate));
			long time2 = cal.getTimeInMillis();
			between_days = (time2 - time1) / (1000 * 3600 * 24);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return Integer.parseInt(String.valueOf(between_days));
	}

	/**
	 * @Title: monthsBetween @Description: 月份差值 @param @param
	 *         startTime @param @param endTime @param @return @param @throws
	 *         ParseException 参数 @return int 返回类型 @throws
	 */
	public static int monthsBetween(String startTime, String endTime) {
		int between_months = 0;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal = Calendar.getInstance();
			cal.setTime(sdf.parse(startTime));
			int month1 = cal.get(Calendar.MONTH);
			cal.setTime(sdf.parse(endTime));
			int month2 = cal.get(Calendar.MONTH);
			between_months = (month2 - month1);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return between_months;
	}

	public String transferLongToDate(Long millSec) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date(millSec);
		return sdf.format(date);
	}

	public static String getDayTimeByDate(Date outTime) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		return sdf.format(outTime);

	}

	public static Date dateAdd(Date date, int i) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, i);// 把日期往后增加一天.整数往后推,负数往前移动
		date = calendar.getTime(); // 这个时间就是日期往后推一天的结果
		try {
			return sdf.parse(sdf.format(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

}
