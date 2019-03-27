package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.entity.user;
import com.uitl.content.Const;
import com.util.dbTools.DBTools;

public class UserService {

	// 根据用户name获取用户
	public user getUserByName(String userName) throws SQLException {
		DBTools dbTools = new DBTools();
		user user = new user();
		ResultSet rs = dbTools.conditionalSearch(Const.TABLE_USER, "userName", userName);
		while (rs.next()) {

			user.setUserId(rs.getInt(Const.COLUNM_USER_ID));
			user.setUserName(Const.COLUNM_USER_NAME);
			user.setUserPassword(Const.COLUNM_USER_PASSWORD);
			user.setUserType(rs.getString(Const.COLUNM_USER_TYPE));
			user.setUserPhoneNumber(rs.getString(Const.COLUNM_USER_PHONENUMBER));
			user.setUserAddr1(rs.getString(Const.COLUNM_USER_ADDR1));
			user.setUserAddr2(rs.getString(Const.COLUNM_USER_ADDR2));
			user.setUserAddr3(rs.getString(Const.COLUNM_USER_ADDR3));
			user.setUserAddr4(rs.getString(Const.COLUNM_USER_ADDR4));
			user.setUserAddr5(rs.getString(Const.COLUNM_USER_ADDR5));
			System.out.println("登陆成功：" + user.toString());

		}
		dbTools.closeDB();
		return user;

	}

	// 根据用户id获取用户
	public user getUserById(String id) throws SQLException {
		DBTools dbTools = new DBTools();
		user user = new user();
		ResultSet rs = dbTools.conditionalSearch(Const.TABLE_USER, "userId", id);
		while (rs.next()) {

			user.setUserId(rs.getInt(Const.COLUNM_USER_ID));
			user.setUserName(Const.COLUNM_USER_NAME);
			user.setUserPassword(Const.COLUNM_USER_PASSWORD);
			user.setUserType(rs.getString(Const.COLUNM_USER_TYPE));
			user.setUserPhoneNumber(rs.getString(Const.COLUNM_USER_PHONENUMBER));
			user.setUserAddr1(rs.getString(Const.COLUNM_USER_ADDR1));
			user.setUserAddr2(rs.getString(Const.COLUNM_USER_ADDR2));
			user.setUserAddr3(rs.getString(Const.COLUNM_USER_ADDR3));
			user.setUserAddr4(rs.getString(Const.COLUNM_USER_ADDR4));
			user.setUserAddr5(rs.getString(Const.COLUNM_USER_ADDR5));
			System.out.println("登陆成功：" + user.toString());
		}
		dbTools.closeDB();
		return user;

	}

	// 注册
	public user setUser(String password, String userName) throws SQLException {
		DBTools dbTools = new DBTools();
		user user = new user();
		user.setUserName(userName);
		user.setUserPassword(password);
		user.setUserPhoneNumber("");
		user.setUserAddr1("");
		user.setUserAddr2("");
		user.setUserAddr3("");
		user.setUserAddr4("");
		user.setUserAddr5("");
		// 1为用户，2为管理员，默认注册为用户。
		user.setUserType("1");
		dbTools.insertAll(user);
		dbTools.closeDB();
		return user;
	}

}
