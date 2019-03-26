package com.util.dbTools;

import java.util.LinkedHashMap;

import com.uitl.content.Const;

public class DbTest {

	public static void main(String[] args) {
		
		DBTools tb = new DBTools();
		LinkedHashMap<String, Object> condition = new LinkedHashMap<String,Object>();
		LinkedHashMap<String, Object> colunmValue = new LinkedHashMap<String,Object>();
		condition.put(Const.COLUNM_USER_ID, 123);
		colunmValue.put(Const.COLUNM_ORDER_ID, 123);
		int rSet = tb.multiConditionalUpdate(Const.TABLE_REJECTED, condition, colunmValue);
		System.out.println(rSet);
	}
}
