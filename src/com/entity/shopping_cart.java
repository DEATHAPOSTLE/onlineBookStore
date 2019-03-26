package com.entity;

public class shopping_cart {

	// 购物车ID(主键自增长)
	private int shoppingCartId;

	// 商品ID    private int commodityId;

    // 用户ID    private String userId;

    // 商品数量    private String commodityNumber;

    // 加入购物车时间    private String registeredDTime;
    public int getShoppingCartId(){
        return this.shoppingCartId;
    }
    public void setShoppingCartId(int shoppingCartId){
        this.shoppingCartId = shoppingCartId;
    }
    public int getCommodityId(){
        return this.commodityId;
    }
    public void setCommodityId(int commodityId){
        this.commodityId = commodityId;
    }
    public String getUserId(){
        return this.userId;
    }
    public void setUserId(String userId){
        this.userId = userId;
    }
    public String getCommodityNumber(){
        return this.commodityNumber;
    }
    public void setCommodityNumber(String commodityNumber){
        this.commodityNumber = commodityNumber;
    }
    public String getRegisteredDTime(){
        return this.registeredDTime;
    }
    public void setRegisteredDTime(String registeredDTime){
        this.registeredDTime = registeredDTime;
    }
}
