package com.entity;

public class orders {

	// 订单ID(主键自增长)
	private int orderId;

	// 商品ID    private int commodityID;

    // 商品价格    private double orderPrice;

    // 用户ID    private int userId;

    // 订单状态    private String orderStatus;

    // 下单时间    private String orderDTime;

    // 发货时间    private String deliveryDTime;

    // 收货时间    private String receiveDTime;

    // 订单评分    private String orderRate;

    // 联系电话    private String phoneNumber;

    // v    private String orderAddr;
    public int getOrderId(){
        return this.orderId;
    }
    public void setOrderId(int orderId){
        this.orderId = orderId;
    }
    public int getCommodityID(){
        return this.commodityID;
    }
    public void setCommodityID(int commodityID){
        this.commodityID = commodityID;
    }
    public double getOrderPrice(){
        return this.orderPrice;
    }
    public void setOrderPrice(double orderPrice){
        this.orderPrice = orderPrice;
    }
    public int getUserId(){
        return this.userId;
    }
    public void setUserId(int userId){
        this.userId = userId;
    }
    public String getOrderStatus(){
        return this.orderStatus;
    }
    public void setOrderStatus(String orderStatus){
        this.orderStatus = orderStatus;
    }
    public String getOrderDTime(){
        return this.orderDTime;
    }
    public void setOrderDTime(String orderDTime){
        this.orderDTime = orderDTime;
    }
    public String getDeliveryDTime(){
        return this.deliveryDTime;
    }
    public void setDeliveryDTime(String deliveryDTime){
        this.deliveryDTime = deliveryDTime;
    }
    public String getReceiveDTime(){
        return this.receiveDTime;
    }
    public void setReceiveDTime(String receiveDTime){
        this.receiveDTime = receiveDTime;
    }
    public String getOrderRate(){
        return this.orderRate;
    }
    public void setOrderRate(String orderRate){
        this.orderRate = orderRate;
    }
    public String getPhoneNumber(){
        return this.phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public String getOrderAddr(){
        return this.orderAddr;
    }
    public void setOrderAddr(String orderAddr){
        this.orderAddr = orderAddr;
    }
}
