package com.util.dbTools;

import java.sql.ResultSet;

public class DbTest {

	public static void main(String[] args) {

		DBTools tb = new DBTools();

		ResultSet rSet = tb.selectAll("user");

		System.out.println(rSet);
	}
}
