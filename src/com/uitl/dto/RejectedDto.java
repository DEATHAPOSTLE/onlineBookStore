package com.uitl.dto;

public class RejectedDto {
	// 退货id
	private int rejectedId;

	// 退货状态
	private String rejectedStatus;

	// 退货时间
	private String rejectedDTime;

	// 订单金额
	private double orderPrice;

	// 订单状态
	private String orderStatus;

	// 下单时间
	private String orderDTime;

	// 用户类型
	private String userType;

	// 电话号码
	private String userPhoneNumber;

	// 姓名
	private String handicappedName;

	// 收货地址1
	private String userAddr1;

	// 商品名称
	private String commodityName;

	// 商品图片
	private String commodityPicture;

	// 商品价格
	private double commodityPrice;

	public int getRejectedId() {
		return rejectedId;
	}

	public void setRejectedId(int rejectedId) {
		this.rejectedId = rejectedId;
	}

	public String getHandicappedName() {
		return handicappedName;
	}

	public void setHandicappedName(String handicappedName) {
		this.handicappedName = handicappedName;
	}

	public String getRejectedStatus() {
		return rejectedStatus;
	}

	public void setRejectedStatus(String rejectedStatus) {
		this.rejectedStatus = rejectedStatus;
	}

	public String getRejectedDTime() {
		return rejectedDTime;
	}

	public void setRejectedDTime(String rejectedDTime) {
		this.rejectedDTime = rejectedDTime;
	}

	public double getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getOrderDTime() {
		return orderDTime;
	}

	public void setOrderDTime(String orderDTime) {
		this.orderDTime = orderDTime;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}

	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}

	public String getUserAddr1() {
		return userAddr1;
	}

	public void setUserAddr1(String userAddr1) {
		this.userAddr1 = userAddr1;
	}

	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public String getCommodityPicture() {
		return commodityPicture;
	}

	public void setCommodityPicture(String commodityPicture) {
		this.commodityPicture = commodityPicture;
	}

	public double getCommodityPrice() {
		return commodityPrice;
	}

	public void setCommodityPrice(double commodityPrice) {
		this.commodityPrice = commodityPrice;
	}

}
