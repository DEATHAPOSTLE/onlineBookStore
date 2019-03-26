package com.entity;

public class rejected {

	// 退货单号
	private int rejectedId;

	// 订单编号    private int orderId;

    // 用户编号    private int userId;

    // 退货状态    private String rejectedStatus;

    // 退货时间    private String rejectedDTime;
    public int getRejectedId(){
        return this.rejectedId;
    }
    public void setRejectedId(int rejectedId){
        this.rejectedId = rejectedId;
    }
    public int getOrderId(){
        return this.orderId;
    }
    public void setOrderId(int orderId){
        this.orderId = orderId;
    }
    public int getUserId(){
        return this.userId;
    }
    public void setUserId(int userId){
        this.userId = userId;
    }
    public String getRejectedStatus(){
        return this.rejectedStatus;
    }
    public void setRejectedStatus(String rejectedStatus){
        this.rejectedStatus = rejectedStatus;
    }
    public String getRejectedDTime(){
        return this.rejectedDTime;
    }
    public void setRejectedDTime(String rejectedDTime){
        this.rejectedDTime = rejectedDTime;
    }
}
