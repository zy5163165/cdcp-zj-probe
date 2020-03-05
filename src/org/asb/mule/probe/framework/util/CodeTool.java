package org.asb.mule.probe.framework.util;

import com.alcatelsbell.nms.util.SysProperty;
import com.alcatelsbell.nms.valueobject.BObject;
import org.asb.mule.probe.framework.service.Constant;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

public class CodeTool {
	public static long uniquekey = 1;
	
	private static long getUniquekey(){
		uniquekey ++;
		return uniquekey;
	}
	public static String getKey(){
		
		long now = new Date().getTime();
		String key = now + "-" + getUniquekey();
		
		return key;
	}
	
	public static void usleep(int millisec) {
		try {
			Thread.sleep(millisec);
		} catch (Exception e) {
		}
	}

	public static void sleep(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (Exception e) {
		}
	}


	public static String isoToGbkold(String str) {
		if (str == null) return null;
		try {
			return new String(str.getBytes("ISO-8859-1"), "GBK");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}

    public static String isoToGbk(String str) {
        if (str == null) return null;
        String decoding = SysProperty.getString("sbi.charset.decoding","ISO-8859-1");
        String encoding = SysProperty.getString("sbi.charset.encoding","GBK");
        try {
       //     return new String(str.getBytes("ISO-8859-1"), "GBK");
            return new String(str.getBytes(decoding), encoding);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

	
public static String isoToIso(String str) {
		
		try {
			return new String(str.getBytes("ISO-8859-1"), "ISO-8859-1");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
	
public static String UTF8ToGbk(String str) {
		
		try {
			return new String(str.getBytes("UTF-8"), "GBK");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
	
	public static String GbkToIso(String str) {
		try {
			return new String(str.getBytes("GBK"), "ISO-8859-1");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
	
	public static String IsoToUtf8(String str) {
		try {
			return new String(str.getBytes("ISO-8859-1"), "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
	public static String encode(String str, String from, String to) {
		try {
			return new String(str.getBytes(from), to);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
	/**
	 * copy from
	 * http://www.omniorb-support.com/pipermail/omniorb-list/2007-June/
	 * 028657.html CORBA's time format comes from DCE. The number in it is the
	 * number of 100 nanosecond intervals since 15th October 1582. There's
	 * nothing in omniORB that knows anything about that, but I happen to have a
	 * little function that handles it:
	 * 
	 * 
	 * # Number of seconds between Unix epoch and DCE epoch
	 * UNIX_TO_UTC_OFFSET_SECS = 12219292800L
	 * 
	 * def convertToUnix(utc): """convertToUnix(dtime) -> time in Unix format"""
	 * 
	 * sinceunix = utc - (UNIX_TO_UTC_OFFSET_SECS * 10000000) secs = sinceunix /
	 * 10000000.0 return secs
	 * 
	 * 
	 * The convertToUnix function converts the DCE time to Unix time as a
	 * floating point value. You can then give it to standard things like
	 * time.ctime() to convert it to a string.
	 * 
	 * @param utcT
	 * @return
	 */
	public static String utcT2LocaleString(long utcT) {
		String localString = "";

		long offset = 12219292800L;
		long now = (utcT - offset * 10000000) / 10000;
		Date date = new Date(now);

		localString = date.toLocaleString();

		return localString;
	}

	/**
	 * 
	 * 
	 * @param alarm
	 * @param key
	 * @param defult
	 * @return value
	 */

	public static String getStrFromHash(HashMap alarm, String key, String defult) {
		try {
			return alarm.get(key) == null ? defult : alarm.get(key).toString()
					.trim();
		} catch (Exception e) {
			return defult;
		}
	}

	/**
	 * 
	 * 
	 * @param date
	 * @return pre2date
	 */
	public static Date getPre2Date(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int day = calendar.get(Calendar.DATE);
		calendar.set(Calendar.DATE, day - 2);
		return calendar.getTime();
	}

	/**
	 * @return  yyyy_MM_dd HH:mm:ss S
	 */
	public static String printTimeStamp(long intTime) {
		String str_Time = "";
		try {
			Timestamp currentTime = new Timestamp(intTime);
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss S");
			str_Time = f.format(currentTime);
		} catch (Exception e) {
			return "";
		}
		return str_Time;
	}
	/**
	 * 
	 * @param str the whole string
	 * @param toplevel separator
	 * @param second level seprator
	 * @param i number
	 * @return 
	 * if alarmLoc name = a,name2=b,name3=c
	 * then s1=",",s2="="
	 * if i=2 
	 * return c
	 */
	public static String parseStr(String str, String s1,
			String s2, int i) {
		String[] strArray = str.split(s1);
		int m=0;
        for (Object o : strArray)
        {
            String[] subArray = o.toString().split(s2);
            if (subArray.length > 1)
            {
                if (m==i) 
                {
                    return subArray[1];
                }
                m++;

            }
        }
        return "";
	}
	
	public static String getField(String msg, String start, String over)
	  {
	    String field = "";

	    if ((msg == null) || (msg.length() == 0)) return "";

	    int begin = msg.indexOf(start);
	    if (begin > -1) {
	      String tmp = msg.substring(begin+start.length());
	      int end = tmp.indexOf(over);
	      if (end > -1) {
	        field = tmp.substring(0, end);
	      }

	    }

	    return field; 
	  }

	public static String getFullField(String msg, String start, String over)
	  {
	    String field = "";

	    if ((msg == null) || (msg.length() == 0)) return "";

	    int begin = msg.indexOf(start);
	    if (begin > -1) {
	      String tmp = msg.substring(begin);
	      if(over.length() == 0)	return tmp;
	      int end = tmp.indexOf(over);
	      if (end > -1) {
	        field = tmp.substring(0, end + over.length());
	      }

	    }

	    return field; 
	  }
	  public static String replaceX(String str, String src, String dst) {
	    if ((str == null) || (src == null) || (dst == null)) { return str;
	    }

	    if (str.indexOf(src) > -1) {
	      str = str.replace(src, dst);
	      str = replaceX(str, src, dst);
	    }

	    return str; }

	  public static String trimbyte(byte[] a, int bt) {
	    int cnt = 0;

	    byte[] tmp = new byte[a.length];
	    for (int loop = 0; loop < a.length; ++loop)
	      if (a[loop] != bt) {
	        tmp[cnt] = a[loop];
	        ++cnt;
	      }

	    byte[] b = new byte[cnt];
	    for (int loop = 0; loop < cnt; ++loop) {
	      b[loop] = tmp[loop];
	    }

	    String dest = new String(b);

	    return dest;
	  }
	  public static String trimbyte(String src, int bt) {
		    int cnt = 0;
		    byte[] a = src.getBytes();
		    byte[] tmp = new byte[a.length];
		    for (int loop = 0; loop < a.length; ++loop)
		      if (a[loop] != bt) {
		        tmp[cnt] = a[loop];
		        ++cnt;
		      }

		    byte[] b = new byte[cnt];
		    for (int loop = 0; loop < cnt; ++loop) {
		      b[loop] = tmp[loop];
		    }

		    String dest = new String(b);

		    return dest;
		  }
	  
	  public static long getCurrentTime(){
			Date now = new Date();
			long nowTime = now.getTime();
			return nowTime;
	}
	  public static String trimzero(byte[] a) {
		    int cnt = 0;
		    byte[] b = new byte[a.length];
		    for (int loop = 0; loop < a.length; ++loop) {
		      if (a[loop] != 0) {
		        b[cnt] = a[loop];
		        ++cnt;
		      }
		    }

		    byte[] c = new byte[cnt];
		    for (int loop = 0; loop < cnt; ++loop) {
		      c[loop] = b[loop];
		    }
		    String dest = new String(c);

		    return dest;
	  }
	  
	  
	  public static String getMsgList(ArrayList<String> msgList, String message, String start, String over){
		  
		  if ((message == null) || (message.length() == 0)) return "";
		  
		  while(true){
			  String field = "";
			  int begin = message.indexOf(start);
			  int end = -1;
			  if (begin > -1) {
			      String tmp = message.substring(begin);
			      end = tmp.indexOf(over);
			      if (end > -1) {
			    	  end += over.length();
			    	  field = tmp.substring(0, end);
			    	  msgList.add(field);
			      }
			  }
//			  System.out.println("["+field+"]");
			  if(end != -1)	message = message.substring(begin+end);
			  else break;
		  }
		  
		  return message;
	  }
	  
	  /**
		 * 锟街凤拷时锟斤拷锟�
		 * 时锟斤拷锟绞轿�012-02-09 15:58:29 
		 * @param args
		 */
		public static long compareDate(String beginDate, String endDate){

			long between = 0L;
			try{
				SimpleDateFormat   df   =   new   SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
				Date   begin =   df.parse(beginDate);   
				Date   end   =   df.parse(endDate);   
				between=(end.getTime()-begin.getTime())/1000;//锟斤拷锟斤拷1000锟斤拷为锟斤拷转锟斤拷锟斤拷锟斤拷   
			}
			catch(Exception e){
//				e.printStackTrace();
				between = -1;
			}
			 
			return between;
		}
		
		/**
		 * 锟街凤拷时锟斤拷转锟斤拷锟斤拷int
		 * 时锟斤拷锟绞轿�012-02-09 15:58:29 
		 * @param args
		 */
		public static int convertDate(String date){
			
			try{
				SimpleDateFormat   df   =   new   SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
				Date  d = new Date();
				if(date.length()!=0)
				{
				
					d =   df.parse(date);   
				}
					 
				return (int) (d.getTime()/1000);
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
			return (int) (getCurrentTime()/1000);
		}
		public static String getCurDate(){
			SimpleDateFormat   sdf   =   new   SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
			String ret =   sdf.format(new Date());   
			return ret;
		}
		public static String getDatetime(){
			SimpleDateFormat   sdf   =   new   SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
			String ret =   sdf.format(new Date());   
			return ret;
		}
		public static String getDatetimeStr(){
			SimpleDateFormat   sdf   =   new   SimpleDateFormat("yyyy-MM-dd-HHmmss");
			String ret =   sdf.format(new Date());   
			return ret;
		}
		public static String getDate(){
			SimpleDateFormat   sdf   =   new   SimpleDateFormat("yyyy-MM-dd");   
			String ret =   sdf.format(new Date());   
			return ret;
		}
		public static String getTime(){
			SimpleDateFormat   sdf   =   new   SimpleDateFormat("HH:mm:ss");   
			String ret =   sdf.format(new Date());   
			return ret;
		}

     public static String array2String(String[] strings) {
         StringBuilder sb = new StringBuilder();
         for (int i = 0; i < strings.length; i++) {
             String string = strings[i];
             sb.append(string);
             if (i < strings.length - 1)
                 sb.append(Constant.listSplit);
         }
         return sb.toString();
     }

    public static String list2String(List<String> strings) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strings.size(); i++) {
            String string = strings.get(i);
            sb.append(string);
            if (i < strings.size() - 1)
                sb.append(Constant.listSplit);
        }
        return sb.toString();
    }

	  public static void main(String[] args){
          System.out.println(extractValue("HZ-U2000-2-P@720897@/rack=1/shelf=1/slot=3","slot"));
          System.out.println(extractValue("HZ-U2000-2-P@720897@/rack=1/shelf=1/slot=3","rack"));
          System.out.println(extractValue("HZ-U2000-2-P@720897@/rack=1/shelf=1/slot=3","shelf"));//		  String message = "xxxx<root>A</root>";
//		  byte[] bt = new byte[2];
//		  bt[0] = 0x0C;
//		  bt[1] = 0x0A;
//		  message += new String(bt) + "XXX";
//
//		  String oldChar = new String(bt);
//		  String newChar = "";
//		  System.out.println("[" + message + "]," + message.length());
//		  String t1 = CodeTool.trimbyte(message, 0x0C);
//		  System.out.println("[" + t1 + "]," + t1.length());
//		  String t2 = message.replace(oldChar, newChar);
//		  System.out.println("[" + t2 + "]," + t2.length());
	  }

    /**
     * HZ-U2000-2-P@720897@/rack=1/shelf=1/slot=3
     *
     * key = rack, return 1
     * @param str
     * @param key
     * @return
     */
     public static String extractValue(String str,String key) {
         int i = str.indexOf(key + "=");
         if (i >= 0) {
            int j = str.indexOf("/",i);
             if (j >= 0 && j > i) {
                 return str.substring(i+key.length()+1,j);
             } else
                 return str.substring(i+key.length()+1);
         }
         return null;
     }


}
