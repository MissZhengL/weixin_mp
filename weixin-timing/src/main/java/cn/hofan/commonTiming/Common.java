package cn.hofan.commonTiming;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Common {

	/**
	 * 是否为空
	 * 
	 * @param str
	 * @return 为空 :null
	 */
	public static String isnull(String str) {
		try {
			if (isNullBoolean(str)) {
				return null;
			}
			return str;
		} catch (Exception ex) {
			return null;
		}
	}

	/**
	 * 是否为空
	 * 
	 * @param str
	 * @return 为空 :null
	 */
	public static String isnull(Object str) {
		try {
			if (isNullBoolean(str)) {
				return null;
			}
			return str.toString();
		} catch (Exception ex) {
			return null;
		}
	}

	/**
	 * 验证是否为空
	 * 
	 * @param str
	 * @return 为空：true
	 */
	public static boolean isNullBoolean(String str) {
		try {
			if (str == null || str.length() < 1) {
				return true;
			}
			return false;
		} catch (Exception ex) {
			return true;
		}
	}

	/**
	 * 验证是否为空
	 * 
	 * @param str
	 * @return 为空：true
	 */
	public static boolean isNullBoolean(Object str) {
		try {
			if (str == null || str.toString().length() < 1) {
				return true;
			}
			return false;
		} catch (Exception ex) {
			return true;
		}
	}

	/**
	 * String 转Double
	 * 
	 * @param str
	 * @return Double
	 */
	public static Double toDouble(String str) {
		try {
			if (isNullBoolean(str)) {
				return null;
			}
			return Double.parseDouble(str);
		} catch (Exception ex) {
			return null;
		}
	}

	/**
	 * String 转 Integer
	 * 
	 * @param str
	 * @return Integer
	 */
	public static Integer toInteger(String str) {
		try {
			if (isNullBoolean(str)) {
				return null;
			}
			return Integer.parseInt(str);
		} catch (Exception ex) {
			return null;
		}
	}

	/**
	 * String 转 Date
	 * 
	 * @param str
	 * @return Date 格式（yyyy-MM-dd hh:mm:ss）
	 */
	public static Date toDate(String str) {
		try {
			if (isNullBoolean(str)) {
				return null;
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date date = sdf.parse(str);
			return date;
		} catch (Exception ex) {
			return null;
		}
	}
	/**
	 * Date 转 String
	 * 
	 * @param date
	 * @return String 格式（yyyy-MM-dd hh:mm:ss）
	 */
	public static String DateToString(Date date) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			return sdf.format(date);
		} catch (Exception ex) {
			return null;
		}
	}
	
    /**
     * 转换utf-8格式
     * @param str
     * @return  String
     */
	public static String toUTF_8(String str) {
		try {
			if (isNullBoolean(str)) {
				return null;
			}
			String utf_8 = new String(str.getBytes("ISO-8859-1"),"UTF-8");
            return utf_8;
		} catch (Exception ex) {
			return null;
		}
	}
	
	  /**  
     * 计算两个日期之间相差的天数  
     * @param smdate 较小的时间 
     * @param bdate  较大的时间 
     * @return 相差天数 
     * @throws ParseException  
	 * @throws java.text.ParseException 
     */    
    public static int daysBetween(Date smdate,Date bdate) throws ParseException    
    {    
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
        smdate=sdf.parse(sdf.format(smdate));  
        bdate=sdf.parse(sdf.format(bdate));  
        Calendar cal = Calendar.getInstance();    
        cal.setTime(smdate);    
        long time1 = cal.getTimeInMillis();                 
        cal.setTime(bdate);    
        long time2 = cal.getTimeInMillis();         
        long between_days=(time2-time1)/(1000*3600*24);  
       return Integer.parseInt(String.valueOf(between_days));           
    }    
    
    public static Date dateAddDay(Date date,int day)
    {
    	Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, day);
    	return  toDate(DateToString(calendar.getTime()));
    }
}
