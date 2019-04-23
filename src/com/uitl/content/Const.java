package com.uitl.content;

public class Const {

	// 表名
	public static final String TABLE_COMMODITY_BASE = "commodity_base";
	public static final String TABLE_HANDICAPPED = "handicapped";
	public static final String TABLE_ORDERS = "orders";
	public static final String TABLE_REJECTED = "rejected";
	public static final String TABLE_SHOPPING_CART = "shopping_cart";
	public static final String TABLE_COMMENT = "comment";
	public static final String TABLE_USER = "user";
	public static final String TABLE_EXAMINE = "commodity_base_examine";

	// bean类名
	public static final String BEAN_COMMODITY_BASE = "com.entity.CommodityBase";
	public static final String BEAN_HANDICAPPED = "com.entity.Handicapped";
	public static final String BEAN_ORDERS = "com.entity.Orders";
	public static final String BEAN_REJECTED = "com.entity.Rejected";
	public static final String BEAN_SHOPPING_CART = "com.entity.ShoppingCart";
	public static final String BEAN_USER = "com.entity.User";
	public static final String BEAN_COMMENT = "com.entity.Comment";
	public static final String BEAN_COMMODITY_SHOPPING_CART = "com.entity.CommodityShoppingCart";
	public static final String BEAN_COMMODITY_BASE_EXAMINE = "com.entity.CommodityBaseExamine";

	// 商品表字段
	public static final String COLUNM_COMMODITY_ID = "commodityId";
	public static final String COLUNM_COMMODITY_PICTURE = "commodityPicture";
	public static final String COLUNM_COMMODITY_TYPE = "commodityType";
	public static final String COLUNM_COMMODITY_PRICE = "commodityPrice";
	public static final String COLUNM_COMMODITY_INTRODUCE = "commodityIntroduce";
	public static final String COLUNM_COMMODITY_SURPLUS = "commoditySurplus";
	public static final String COLUNM_COMMODITY_RATE = "commodityRate";
	public static final String COLUNM_COMMODITY_NAME = "commodityName";
	public static final String COLUNM_COMMODITY_SHELVES = "commodityShelves";
	public static final String COLUNM_COMMODITY_PRESS = "commodityPress";
	public static final String COLUNM_COMMODITY_AUTHOR = "commodityAuthor";
	public static final String COLUNM_COMMODITY_LIST = "commodityList";
	public static final String COLUNM_COMMODITY_CONTENT = "commodityContent";
	public static final String COLUNM_COMMODITY_INPRICE = "commodityInPrice";

	// 审核表
	public static final String COLUNM_EXAMINE_ID = "examineId";
	public static final String COLUNM_EXAMINE_COMMODITY_PICTURE = "commodityPicture";
	public static final String COLUNM_EXAMINE_COMMODITY_TYPE = "commodityType";
	public static final String COLUNM_EXAMINE_COMMODITY_PRICE = "commodityPrice";
	public static final String COLUNM_EXAMINE_COMMODITY_INTRODUCE = "commodityIntroduce";
	public static final String COLUNM_EXAMINE_COMMODITY_NAME = "commodityName";
	public static final String COLUNM_EXAMINE_EXAMINE = "commodityExamine";
	public static final String COLUNM_EXAMINE__PRESS = "commodityPress";
	public static final String COLUNM_EXAMINE__AUTHOR = "commodityAuthor";

	// 用户表字段
	public static final String COLUNM_USER_ID = "userId";
	public static final String COLUNM_USER_NAME = "userName";
	public static final String COLUNM_USER_PASSWORD = "userPassword";
	public static final String COLUNM_USER_TYPE = "userType";
	public static final String COLUNM_USER_PHONENUMBER = "userPhoneNumber";
	public static final String COLUNM_USER_ADDR1 = "userAddr1";
	public static final String COLUNM_USER_ADDR2 = "userAddr2";
	public static final String COLUNM_USER_ADDR3 = "userAddr3";
	public static final String COLUNM_USER_ADDR4 = "userAddr4";
	public static final String COLUNM_USER_ADDR5 = "userAddr5";
	public static final String COLUNM_USER_MONEY = "money";

	// 购物车表字段
	public static final String COLUNM_SHOPPING_CARTID = "ShoppingCartId";
	public static final String COLUNM_COMMODITY_NUMBER = "CommodityNumber";
	public static final String COLUNM_REGISTERED_DTIME = "registeredDTime";

	// 订单表字段
	public static final String COLUNM_ORDER_ID = "OrderId";
	public static final String COLUNM_ORDER_PRICE = "OrderPrice";
	public static final String COLUNM_ORDER_STATUS = "OrderStatus";
	public static final String COLUNM_ORDER_DTIME = "OrderDTime";
	public static final String COLUNM_DELIVERY_DTIME = "DeliveryDTime";
	public static final String COLUNM_RECEIVE_DTIME = "ReceiveDTime";
	public static final String COLUNM_ORDER_RATE = "OrderRate";
	public static final String COLUNM_PHONENUMBER = "PhoneNumber";
	public static final String COLUNM_ORDER_ADDR = "OrderAddr";

	// 退货表字段
	public static final String COLUNM_REJECTED_ID = "rejectedId";
	public static final String COLUNM_REJECTED_STATUS = "RejectedStatus";
	public static final String COLUNM_REJECTED_DTIME = "rejectedDTime";

	// 评论表字段
	public static final String COLUNM_COMMENT_ID = "commentId";
	public static final String COLUNM_COMMENT_CONTENT = "commentContent";
	public static final String COLUNM_COMMENT_DTIME = "commentDTime";

	public enum SearchCondition {
		// 相等
		EQUAL,
		// 小于
		LESSTHAN,
		// 大于
		MORETHAN,
		// 小于等于
		LESSEQUAL,
		// 大于等于
		MOREEQUAL
	}

	public enum DisabilityType {
		视力残疾, 听力残疾, 言语残疾, 智力残疾, 精神残疾, 肢体残疾,
	}
}
