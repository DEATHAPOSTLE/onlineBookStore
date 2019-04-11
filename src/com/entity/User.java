package com.entity;

public class User {
	// 用户ID(主键自增长)
	private int userId;
	// 用户名
	private String userName;

	// 用户密码
	private String userPassword;

	// 用户权限（4上架者/3管理员/1普通/2会员）
	private String userType;

	// 用户电话
	private String userPhoneNumber;

	// 用户地址1
	private String userAddr1;

	// 用户地址2
	private String userAddr2;

	// 用户地址3
	private String userAddr3;

	// 用户地址4
	private String userAddr4;

	// 用户地址5
	private String userAddr5;

	// 余额
	private double money;

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserPhoneNumber() {
		return this.userPhoneNumber;
	}

	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}

	public String getUserAddr1() {
		return this.userAddr1;
	}

	public void setUserAddr1(String userAddr1) {
		this.userAddr1 = userAddr1;
	}

	public String getUserAddr2() {
		return this.userAddr2;
	}

	public void setUserAddr2(String userAddr2) {
		this.userAddr2 = userAddr2;
	}

	public String getUserAddr3() {
		return this.userAddr3;
	}

	public void setUserAddr3(String userAddr3) {
		this.userAddr3 = userAddr3;
	}

	public String getUserAddr4() {
		return this.userAddr4;
	}

	public void setUserAddr4(String userAddr4) {
		this.userAddr4 = userAddr4;
	}

	public String getUserAddr5() {
		return this.userAddr5;
	}

	public void setUserAddr5(String userAddr5) {
		this.userAddr5 = userAddr5;
	}
}
