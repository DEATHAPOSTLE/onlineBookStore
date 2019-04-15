package com.uitl.dto;

public class OrdersDto {
	// 订单编号
	private int orderId;

	// 商品ID
	private int commodityID;

	// 订单金额
	private double orderPrice;

	// 用户ID
	private int userId;

	// 用户姓名
	private String userName;

	// 订单状态
	private String orderStatus;

	// 下单时间
	private String orderDTime;

	// 发货时间
	private String deliveryDTime;

	// 收货时间
	private String receiveDTime;

	private String phoneNumber;

	private String orderAddr;
	// 是否可以退货，七天后无法退货
	// 1代表未到达七天，2代表已超过七天
	private String rejectedStatus;
	// 评价
	private String rateStatus;

	public int getOrderId() {
		return this.orderId;
	}

	public void setOrderId(int OrderId) {
		this.orderId = OrderId;
	}

	public int getCommodityID() {
		return this.commodityID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setCommodityID(int commodityID) {
		this.commodityID = commodityID;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int UserId) {
		this.userId = UserId;
	}

	public String getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(String OrderStatus) {
		this.orderStatus = OrderStatus;
	}

	public String getOrderDTime() {
		return this.orderDTime;
	}

	public double getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}

	public void setOrderDTime(String OrderDTime) {
		this.orderDTime = OrderDTime;
	}

	public String getDeliveryDTime() {
		return this.deliveryDTime;
	}

	public void setDeliveryDTime(String DeliveryDTime) {
		this.deliveryDTime = DeliveryDTime;
	}

	public String getReceiveDTime() {
		return this.receiveDTime;
	}

	public void setReceiveDTime(String ReceiveDTime) {
		this.receiveDTime = ReceiveDTime;
	}

	public String getRejectedStatus() {
		return rejectedStatus;
	}

	public void setRejectedStatus(String rejectedStatus) {
		this.rejectedStatus = rejectedStatus;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getOrderAddr() {
		return orderAddr;
	}

	public void setOrderAddr(String orderAddr) {
		this.orderAddr = orderAddr;
	}

	public String getRateStatus() {
		return rateStatus;
	}

	public void setRateStatus(String rateStatus) {
		this.rateStatus = rateStatus;
	}

}
