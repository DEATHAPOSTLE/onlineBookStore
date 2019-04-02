package com.entity;

public class CommodityBase {

	// 商品ID(主键自增长)
	private int commodityId;

	// 商品名称
	private String commodityName;

	// 商品图片
	private String commodityPicture;

	// 商品类型
	private String commodityType;

	// 商品价格
	private double commodityPrice;

	// 商品介绍
	private String commodityIntroduce;

	// 商品剩余数量
	private int commoditySurplus;

	// 商品评分
	private String commodityRate;

	// 商品上下架标记
	private String commodityShelves;

	public int getCommodityId() {
		return this.commodityId;
	}

	public void setCommodityId(int commodityId) {
		this.commodityId = commodityId;
	}

	public String getCommodityName() {
		return this.commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public String getCommodityPicture() {
		return this.commodityPicture;
	}

	public void setCommodityPicture(String commodityPicture) {
		this.commodityPicture = commodityPicture;
	}

	public String getCommodityType() {
		return this.commodityType;
	}

	public void setCommodityType(String commodityType) {
		this.commodityType = commodityType;
	}

	public double getCommodityPrice() {
		return this.commodityPrice;
	}

	public void setCommodityPrice(double commodityPrice) {
		this.commodityPrice = commodityPrice;
	}

	public String getCommodityIntroduce() {
		return this.commodityIntroduce;
	}

	public void setCommodityIntroduce(String commodityIntroduce) {
		this.commodityIntroduce = commodityIntroduce;
	}

	public int getCommoditySurplus() {
		return this.commoditySurplus;
	}

	public void setCommoditySurplus(int commoditySurplus) {
		this.commoditySurplus = commoditySurplus;
	}

	public String getCommodityRate() {
		return this.commodityRate;
	}

	public void setCommodityRate(String commodityRate) {
		this.commodityRate = commodityRate;
	}

	public String getCommodityShelves() {
		return this.commodityShelves;
	}

	public void setCommodityShelves(String commodityShelves) {
		this.commodityShelves = commodityShelves;
	}
}
