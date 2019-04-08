package com.entity;

public class CommodityBaseExamine {

	// 审核id
	private int examineId;

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

	// 审核步骤
	private int commodityExamine;
	// 出版社
	private String commodityPress;
	// 作者
	private String commodityAuthor;

	public int getExamineId() {
		return examineId;
	}

	public void setExamineId(int examineId) {
		this.examineId = examineId;
	}

	public int getCommodityExamine() {
		return commodityExamine;
	}

	public void setCommodityExamine(int commodityExamine) {
		this.commodityExamine = commodityExamine;
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

	public String getCommodityPress() {
		return commodityPress;
	}

	public void setCommodityPress(String commodityPress) {
		this.commodityPress = commodityPress;
	}

	public String getCommodityAuthor() {
		return commodityAuthor;
	}

	public void setCommodityAuthor(String commodityAuthor) {
		this.commodityAuthor = commodityAuthor;
	}

}
