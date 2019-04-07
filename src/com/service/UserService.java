package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import com.entity.User;
import com.uitl.content.Const;
import com.util.dbTools.DBTools;

public class UserService {

	// 根据用户name获取用户
	public User getUserAll(String table) throws SQLException {
		DBTools dbTools = new DBTools();
		User user = new User();
		ResultSet rs = dbTools.selectAll(Const.TABLE_USER);
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

	// 根据用户name获取用户
	public User getUserByName(String userName) throws SQLException {
		DBTools dbTools = new DBTools();
		User user = new User();
		ResultSet rs = dbTools.conditionalSearch(Const.TABLE_USER, Const.COLUNM_USER_NAME, userName);
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
	public User getUserById(String id) throws SQLException {
		DBTools dbTools = new DBTools();
		User user = new User();
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
	public User setUser(String password, String userName) throws SQLException {
		DBTools dbTools = new DBTools();
		User user = new User();
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

	// 根据用户id查询用户
	public List<User> getUserByIds(List<Integer> userIds) throws SQLException {
		DBTools dbTools = new DBTools();
		ResultSet rs = dbTools.pluralSearch(Const.TABLE_USER, userIds, Const.COLUNM_USER_ID);
		List<User> users = new ArrayList<User>();
		while (rs.next()) {
			User user = new User();
			user.setUserName(Const.COLUNM_USER_NAME);
			user.setUserPassword(rs.getString(Const.COLUNM_USER_PASSWORD));
			user.setUserPhoneNumber(rs.getString(Const.COLUNM_USER_PHONENUMBER));
			user.setUserAddr1(rs.getString(Const.COLUNM_USER_ADDR1));
			user.setUserAddr2(rs.getString(Const.COLUNM_USER_ADDR2));
			user.setUserAddr3(rs.getString(Const.COLUNM_USER_ADDR3));
			user.setUserAddr4(rs.getString(Const.COLUNM_USER_ADDR4));
			user.setUserAddr5(rs.getString(Const.COLUNM_USER_ADDR5));
			// 1为用户，2为管理员，默认注册为用户。
			user.setUserType(rs.getString(Const.COLUNM_USER_TYPE));
			user.setUserId(rs.getInt(Const.COLUNM_USER_ID));
			users.add(user);
		}
		dbTools.closeDB();
		return users;
	}

	// 修改用户
	public int updateUserById(User updateUser) throws SQLException {
		DBTools dbTools = new DBTools();
		LinkedHashMap<String, Object> colunmValue = new LinkedHashMap<>();
		LinkedHashMap<String, Object> condition = new LinkedHashMap<>();
		condition.put(Const.COLUNM_USER_ID, updateUser.getUserId());
		colunmValue.put(Const.COLUNM_USER_PASSWORD, updateUser.getUserPassword());
		colunmValue.put(Const.COLUNM_USER_TYPE, updateUser.getUserType());
		colunmValue.put(Const.COLUNM_USER_PHONENUMBER, updateUser.getUserPhoneNumber());
		colunmValue.put(Const.COLUNM_USER_ADDR1, updateUser.getUserAddr1());
		colunmValue.put(Const.COLUNM_USER_ADDR2, updateUser.getUserAddr2());
		colunmValue.put(Const.COLUNM_USER_ADDR3, updateUser.getUserAddr3());
		colunmValue.put(Const.COLUNM_USER_ADDR4, updateUser.getUserAddr4());
		colunmValue.put(Const.COLUNM_USER_ADDR5, updateUser.getUserAddr5());
		colunmValue.put(Const.COLUNM_USER_NAME, updateUser.getUserName());
		colunmValue.put(Const.COLUNM_USER_MONEY, updateUser.getMoney());

		int result = dbTools.multiConditionalUpdate(Const.TABLE_USER, condition, colunmValue);
		return result;
	}

}
