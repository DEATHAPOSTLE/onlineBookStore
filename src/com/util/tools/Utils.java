package com.util.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
	
	public static String getSystemDTime(){
		//我要获取当前的日期
        Date date = new Date();
        //设置要获取到什么样的时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH：mm：ss");
        //获取String类型的时间
        String createdate = sdf.format(date);
        
        return createdate;
		
	}

}
