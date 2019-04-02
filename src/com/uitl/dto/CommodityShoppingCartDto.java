package com.uitl.dto;

public class CommodityShoppingCartDto {

	// 商品ID
	private int commodityId;

	// 商品名称
	private String commodityName;

	// 商品图片
	private String commodityPicture;

	// 商品种类
	private String commodityType;

	// 商品价格
	private double commodityPrice;

	// 商品介绍
	private String commodityIntroduce;

	// 商品剩余数量
	private int commoditySurplus;

	// 商品评价
	private String commodityRate;

	// 购物车编号
	private int shoppingCartId;

	// 用户ID
	private String userId;

	// 商品数量
	private String commodityNumber;

	// 添加时间
	private String registeredDTime;

	public int getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(int commodityId) {
		this.commodityId = commodityId;
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

	public String getCommodityType() {
		return commodityType;
	}

	public void setCommodityType(String commodityType) {
		this.commodityType = commodityType;
	}

	public double getCommodityPrice() {
		return commodityPrice;
	}

	public void setCommodityPrice(double commodityPrice) {
		this.commodityPrice = commodityPrice;
	}

	public String getCommodityIntroduce() {
		return commodityIntroduce;
	}

	public void setCommodityIntroduce(String commodityIntroduce) {
		this.commodityIntroduce = commodityIntroduce;
	}

	public int getCommoditySurplus() {
		return commoditySurplus;
	}

	public void setCommoditySurplus(int commoditySurplus) {
		this.commoditySurplus = commoditySurplus;
	}

	public String getCommodityRate() {
		return commodityRate;
	}

	public void setCommodityRate(String commodityRate) {
		this.commodityRate = commodityRate;
	}

	public int getShoppingCartId() {
		return shoppingCartId;
	}

	public void setShoppingCartId(int shoppingCartId) {
		this.shoppingCartId = shoppingCartId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCommodityNumber() {
		return commodityNumber;
	}

	public void setCommodityNumber(String commodityNumber) {
		this.commodityNumber = commodityNumber;
	}

	public String getRegisteredDTime() {
		return registeredDTime;
	}

	public void setRegisteredDTime(String registeredDTime) {
		this.registeredDTime = registeredDTime;
	}

	@Override
	public String toString() {
		return "CommodityShoppingCartDto [commodityId=" + commodityId + ", commodityName=" + commodityName
				+ ", commodityPicture=" + commodityPicture + ", commodityType=" + commodityType + ", commodityPrice="
				+ commodityPrice + ", commodityIntroduce=" + commodityIntroduce + ", commoditySurplus="
				+ commoditySurplus + ", commodityRate=" + commodityRate + ", shoppingCartId=" + shoppingCartId
				+ ", userId=" + userId + ", commodityNumber=" + commodityNumber + ", registeredDTime=" + registeredDTime
				+ "]";
	}

}
