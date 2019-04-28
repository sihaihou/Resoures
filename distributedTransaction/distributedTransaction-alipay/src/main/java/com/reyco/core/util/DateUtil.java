package com.reyco.core.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateUtil {

	 /** 日期+时间的格�? */
    final static public String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    /** 日期的格�? */
    final static public String DATE_FORMAT      = "yyyy-MM-dd";
    /** 小时:分的格式 */
    final static public String HHMM_FORMAT      = "HH:mm";

    final static public String HHMMSS_FORMAT    = "HH:mm:ss";

    /**
     * 将日期字符串解析成指定格式的Date对象
     * 
     * @param dateTime 日期字符�?
     * @param format 指定格式
     * @return （正确格式）日期对象
     * @throws ParseException
     */
    public static Date parse(String dateTime, String format) throws ParseException {
        if (dateTime == null || dateTime.length() <= 0) return null;
        String sDateTime = ((dateTime.indexOf('.') > 0)) ? dateTime.substring(0, dateTime.indexOf('.')) : dateTime;

        DateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.parse(sDateTime);
    }

    /**
     * 将日期类解析成指定格式的日期字符�?
     * 
     * @param date
     * @param format
     * @return
     */
    public static String format(Date date, String format) {
        if (date == null) return null;
        DateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }
    /**
     * 将日期字符串解析�?"yyyy-MM-dd HH:mm:ss"格式的Date对象
     * 
     * @param dateTime 日期字符�?
     * @param format 指定格式
     * @return （正确格式）日期对象
     */
    public static Date parseDateTime(String dateTime) {
        try {
            return parse(dateTime, DATE_TIME_FORMAT);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 将日期类解析�?"yyyy-MM-dd HH:mm:ss"格式的日期字符串
     * 
     * @param date
     * @param format
     * @return
     */
    public static String formatDateTime(Date date) {
        return format(date, DATE_TIME_FORMAT);
    }

    /**
     * 将日期字符串解析�?"yyyy-MM-dd"格式的Date对象
     * 
     * @param dateTime 日期字符�?
     * @param format 指定格式
     * @return （正确格式）日期对象
     * @throws ParseException
     */
    public static Date parseDate(String dateTime) {
        try {
            return parse(dateTime, DATE_FORMAT);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 将日期类解析�?"yyyy-MM-dd"格式的日期字符串
     * 
     * @param date
     * @param format
     * @return
     */
    public static String formatDate(Date date) {
        return format(date, DATE_FORMAT);
    }

    /**
     * 将日期类解析�?"HH:mm"格式的日期字符串
     * 
     * @param date
     * @param format
     * @return
     */
    public static String formatHHmm(Date date) {
        return format(date, HHMM_FORMAT);
    }

    /**
     * 将日期类解析�?"HH:mm:ss"格式的日期字符串
     * 
     * @param date
     * @param format
     * @return
     */
    public static String formatHHmmss(Date date) {
        return format(date, HHMMSS_FORMAT);
    }

    /**
     * 格式化日期类型，返回中文显示的日期时�? 返回String 格式如下�? 2007�?9�?4�? 16:32:35
     * 
     * @param date
     * @return
     */
    public static String formatDateTimeChinaLocale(Date date) {
        if (date == null) return null;
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.DEFAULT, Locale.CHINA);
        return df.format(date);
    }

    /**
     * 格式化日期类型，返回中文显示的日期时�? 返回String 格式如下�? 2007�?9�?4�?
     * 
     * @param date
     * @return
     */
    public static String formatDateChinaLocale(Date date) {
        if (date == null) return null;
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Locale.CHINA);
        return df.format(date);
    }

    private static boolean checkDay(int year, int month, int monthDay) {
        if (month < 0 || month > 11 || monthDay < 1 || monthDay > 31) {
            throw new RuntimeException("The day<" + year + "," + (month + 1) + "," + monthDay + "> is ERROR-DAY!");
        }
        Calendar cal = GregorianCalendar.getInstance();
        cal.set(year, month, 1);
        int maxDay = getMaxDaysOfMonth(cal.getTime());
        if (monthDay > maxDay) {
            throw new RuntimeException("The day<" + year + "," + (month + 1) + "," + monthDay + "> is ERROR-DAY!");
        }
        return true;
    }

    /**
     * 返回日期
     * 
     * @param year
     * @param month 0-11
     * @param monthDay 1-31
     * @return
     */
    public static Date toDate(int year, int month, int day) {
        checkDay(year, month, day);

        Calendar cal = GregorianCalendar.getInstance();
        cal.set(year, month, day, 0, 0, 0);

        return cal.getTime();
    }

    /**
     * 返回四位年份,如果传入的参数为null，将抛出空指针异常�??
     * 
     * @param date
     * @return
     */
    public static int getYear(Date date) {
        Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.YEAR);
    }

    /**
     * 返回月数(0-11) 如果传入的参数为null，将抛出空指针异常�??
     * 
     * @param date
     * @return
     */
    public static int getMonth(Date date) {
        Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.MONTH);
    }

    /**
     * 返回月几(1-31) 如果传入的参数为null，将抛出空指针异常�??
     * 
     * @param date
     * @return
     */
    public static int getDayOfMonth(Date date) {
        Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 返回周几 returned value (<tt>1</tt> = Sunday, <tt>2</tt> = Monday, <tt>3</tt> = Tuesday, <tt>4</tt> = Wednesday,
     * <tt>6</tt> = Thursday, <tt>6</tt> = Friday, <tt>7</tt> = Saturday) 如果传入的参数为null，将抛出空指针异常�??
     * 
     * @param date
     * @return
     */
    public static int getDayOfWeek(Date date) {
        Calendar cal = GregorianCalendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.setTime(date);
        int result = cal.get(Calendar.DAY_OF_WEEK);
        return result;
    }

    /**
     * 返回周几 returned value (<tt>7</tt> = Sunday, <tt>1</tt> = Monday, <tt>2</tt> = Tuesday, <tt>3</tt> = Wednesday,
     * <tt>4</tt> = Thursday, <tt>5</tt> = Friday, <tt>6</tt> = Saturday) 如果传入的参数为null，将抛出空指针异常�??
     * 
     * @param date
     * @return
     */
    private static int getDayOfWeekForChina(Date date) {
        Calendar cal = GregorianCalendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.setTime(date);
        int result = cal.get(Calendar.DAY_OF_WEEK);
        if (result == 1) {
            return 7;
        } else {
            return result - 1;
        }
    }

    /**
     * 返回小时(0-23) 如果传入的参数为null，将抛出空指针异常�??
     * 
     * @param date
     * @return
     */
    public static int getHours(Date date) {
        Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 返回分钟�?0-59�? 如果传入的参数为null，将抛出空指针异常�??
     * 
     * @param date
     * @return
     */
    public static int getMinutes(Date date) {
        Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.MINUTE);
    }

    /**
     * 某年某月某日的所在周的第�?�?(周一)�? 如果传入的参数为null则返回null�?
     * 
     * @param date
     * @return
     */
    public static Date getFirstDayOfWeek(Date date) {
        if (date == null) {
            return null;
        }
        Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_WEEK, 1 - getDayOfWeekForChina(date));

        return cal.getTime();
    }

    /**
     * 某年某月某日的所在周的周末一�?(周日)�? 如果传入的参数为null则返回null�?
     * 
     * @param date
     * @return
     */
    public static Date getLastDayOfWeek(Date date) {
        if (date == null) {
            return null;
        }
        Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_WEEK, 7 - getDayOfWeekForChina(date));

        return cal.getTime();
    }

    /**
     * 参数date�?在月份的第一天�?? 如果传入的参数为null则返回null�?
     * 
     * @param date
     * @return
     */
    public static Date getFirstDayOfMonth(Date date) {
        if (date == null) {
            return null;
        }
        Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

    /**
     * 参数Date�?在月份的�?后一天�?? 如果传入的参数为null则返回null�?
     * 
     * @param date
     * @return
     */
    public static Date getLastDayOfMonth(Date date) {
        if (date == null) {
            return null;
        }
        Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, getMaxDaysOfMonth(date));
        return cal.getTime();
    }

    /**
     * 参数date�?在月份的�?大天数�?? 如果传入的参数为null，则返回-1�?
     * 
     * @param date
     * @return
     */
    public static int getMaxDaysOfMonth(Date date) {
        if (date == null) {
            return -1;
        }

        Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(date);

        return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    /**
     * 比较日期：年月日�?
     * 
     * @param d0
     * @param d1
     * @return the value <code>0</code> if the argument d1 is equal to d0; a value less than <code>0</code> if d0 is
     * before d1 argument; and a value greater than <code>0</code> if d0 is after d1 argument.
     * @exception NullPointerException if d0 or d1 is null.
     */
    public static int compareDay(Date d0, Date d1) {
        return d0.compareTo(d1);
    }

    public static int compareToday(Date d0) {
        return d0.compareTo(new Date());
    }

    /**
     * d0是否在[d1,d2]的日期区间中
     * 
     * @param d0
     * @param d1
     * @param d2
     * @return
     * @exception NullPointerException if d0 or d1 or d2 is null.
     */
    public static boolean isDayInRange(Date d0, Date d1, Date d2) {
        return (compareDay(d0, d1) >= 0 && compareDay(d0, d2) <= 0) ? true : false;
    }

    /**
     * 返回N个月之后（之前）的某天�?? 例外情况：如果找到的天数大于此月的最后一天，则返回此月的�?后一天�?? 比如：输�?(2007-1-31,1)，则返回2007-2-28
     * 
     * @param date
     * @param month
     * @return
     */
    public static Date addMonths(Date date, int monthNumber) {
        if (monthNumber == 0) return date;
        if (date == null) return null;

        Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, monthNumber);

        return cal.getTime();
    }

    /**
     * 返回N天之后（之前）的某天�?
     * 
     * @param date
     * @param days
     * @return
     */
    public static Date addDays(Date date, int days) {
        if (days == 0) return date;
        if (date == null) return null;

        Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_YEAR, days);

        return cal.getTime();
    }

    /**
     * 返回N天之后（之前）的某天�?
     * 
     * @param date
     * @param days
     * @return
     */
    public static Date addHours(Date date, int hours) {
        if (hours == 0) return date;
        if (date == null) return null;

        Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR_OF_DAY, hours);

        return cal.getTime();
    }

    /**
     * 截去time部分，使日期的时间部分变成变�?00:00:00,如果传入的参数为null，则返回null�?
     * 
     * @param date
     * @return
     */
    public static Date truncateDate(Date date) {
        if (date == null) {
            return null;
        }
        Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR, -12);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 将date转为date对应的那�?天的�?后时间，使日期的时间部分变成变成23:59:59.999，如果传入的参数是null，则返回null�?
     * 
     * @param date
     * @return
     */
    public static Date getLastDateTimeOfDate(Date date) {
        if (date == null) {
            return null;
        }
        Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return cal.getTime();
    }

    /**
     * 比较2个日期类型，返回2个日期相差的天数，正数表示前�?个日期比后一个日期晚n天，负数表示前一日期比后�?日期早n�?
     * 
     * @param compareDate
     * @param compareToDate
     * @return
     */
    public static int compareDays(Date d1, Date d2) {
        if (d1 == null || d2 == null) throw new RuntimeException("Not compare between d1<" + d1 + "> and d2<" + d2
                                                                 + ">!");
        d1 = parseDate(formatDate(d1));
        d2 = parseDate(formatDate(d2));

        int i = (int) ((d1.getTime() - d2.getTime()) / (24 * 3600 * 1000));
        return i;
    }

    public static String filter(String ip) {
        String[] ips = ip.split("\\.");
        return ips[0] + ".***.***." + ips[3];
    }
    
    public static int toInteger(String str) {
       return Integer.valueOf(str);
    }
	
	
	
	/**
	 * 根据时间串获得开始时间
	 * @param timePeriod
	 * @return
	 */
	public static int getStartTime(String timePeriod) {
		return timePeriod.indexOf("1");
	}
	
	/**
	 * 根据时间串获得结束时间
	 * @param timePeriod
	 * @return
	 */
	public static int getEndTime(String timePeriod) {
		return timePeriod.lastIndexOf("1");
	}
	
	/**
	 * 根据开始时间和结束时间返回时间串
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public static String launchTime(int startTime,int endTime) {
		String result = "000000000000000000000000";
		if(startTime >= endTime) {
			return result;
		}
		result = "";
		for(int i=0;i<24;i++) {
			if(i>=startTime && i<=endTime) {
				result +="1";
			}
			else {
				result +="0";
			}
		}
		return result;
	}
	
	
	public static void main(String[] arg) {
		String test="/dsp/customer/login.htm";
		String[] test2 = test.split("/");
		String xx = test;
		for(int i=1;i<=test2.length;i++) {
			String temp = test2[test2.length-i];
			xx = xx.replace("/"+temp, "");
			System.out.println(xx);
		}
		
	}
}
