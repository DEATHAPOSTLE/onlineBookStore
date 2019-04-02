package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import com.entity.Orders;
import com.entity.User;
import com.uitl.content.Const;
import com.util.dbTools.DBTools;

public class OrderService {

	// 用户个人订单查询
	public List<Orders> getOrderByUserId(User user) throws SQLException {
		DBTools dbTools = new DBTools();

		ResultSet orderResult = dbTools.conditionalSearch(Const.TABLE_ORDERS, "userId", user.getUserId());
		List<Orders> orderslist = new ArrayList<Orders>();
		while (orderResult.next()) {
			Orders orders = new Orders();
			orders.setCommodityID(orderResult.getInt(Const.COLUNM_COMMODITY_ID));
			orders.setDeliveryDTime(orderResult.getString(Const.COLUNM_DELIVERY_DTIME));
			orders.setOrderDTime(orderResult.getString(Const.COLUNM_ORDER_DTIME));
			orders.setOrderId(orderResult.getInt(Const.COLUNM_ORDER_ID));
			orders.setOrderPrice(orderResult.getDouble(Const.COLUNM_ORDER_PRICE));
			orders.setOrderStatus(orderResult.getString(Const.COLUNM_ORDER_STATUS));
			orders.setReceiveDTime(orderResult.getString(Const.COLUNM_RECEIVE_DTIME));
			orders.setUserId(orderResult.getInt(Const.COLUNM_USER_ID));
			orders.setPhoneNumber(orderResult.getString(Const.COLUNM_PHONENUMBER));
			orders.setOrderAddr(orderResult.getString(Const.COLUNM_ORDER_ADDR));
			orders.setOrderRate(orderResult.getString(Const.COLUNM_ORDER_RATE));

			orderslist.add(orders);
		}
		dbTools.closeDB();
		return orderslist;

	}

	// 添加商品至订单表
	public int setOrder(Orders orders) throws SQLException {
		DBTools dbTools = new DBTools();
		int result = dbTools.insertAll(orders);
		dbTools.closeDB();
		return result;

	}

	// 检索所有定单
	public ResultSet getAllOrders() {
		DBTools dbTools = new DBTools();
		ResultSet resultSet = dbTools.selectAll(Const.TABLE_ORDERS);
		return resultSet;
	}

	// 检索未发货订单
	public ResultSet getUnshippedOrders() {
		DBTools dbTools = new DBTools();
		ResultSet resultSet = dbTools.conditionalSearch(Const.TABLE_ORDERS, Const.COLUNM_ORDER_STATUS, "1");

		return resultSet;
	}

	// 查询单个订单
	public Orders getOrderById(String id) throws SQLException {
		DBTools dbTools = new DBTools();

		ResultSet orderResult = dbTools.conditionalSearch(Const.TABLE_ORDERS, Const.COLUNM_ORDER_ID, id);
		Orders orders = new Orders();
		while (orderResult.next()) {
			orders.setCommodityID(orderResult.getInt(Const.COLUNM_COMMODITY_ID));
			orders.setDeliveryDTime(orderResult.getString(Const.COLUNM_DELIVERY_DTIME));
			orders.setOrderDTime(orderResult.getString(Const.COLUNM_ORDER_DTIME));
			orders.setOrderId(orderResult.getInt(Const.COLUNM_ORDER_ID));
			orders.setOrderPrice(orderResult.getDouble(Const.COLUNM_ORDER_PRICE));
			orders.setOrderStatus(orderResult.getString(Const.COLUNM_ORDER_STATUS));
			orders.setReceiveDTime(orderResult.getString(Const.COLUNM_RECEIVE_DTIME));
			orders.setUserId(orderResult.getInt(Const.COLUNM_USER_ID));
		}
		dbTools.closeDB();
		return orders;

	}

	// 修改订单状态
	public int UpdateOrder(Orders codition) {
		DBTools dbTools = new DBTools();
		LinkedHashMap<String, Object> conditionMap = new LinkedHashMap<String, Object>();
		LinkedHashMap<String, Object> colunmValueMap = new LinkedHashMap<String, Object>();
		conditionMap.put("orderId", codition.getOrderId());
		colunmValueMap.put("orderStatus", codition.getOrderStatus());
		if (codition.getDeliveryDTime() != null)
			colunmValueMap.put("deliveryDTime", codition.getDeliveryDTime());
		if (codition.getReceiveDTime() != null)
			colunmValueMap.put("receiveDTime", codition.getReceiveDTime());

		int resultSet = dbTools.multiConditionalUpdate(Const.TABLE_ORDERS, conditionMap, colunmValueMap);
		dbTools.closeDB();
		return resultSet;
	}

	// 商品订单查询
	public List<Orders> getOrderByCommodityId(String commodityId) throws SQLException {
		DBTools dbTools = new DBTools();

		ResultSet orderResult = dbTools.conditionalSearch(Const.TABLE_ORDERS, Const.COLUNM_COMMODITY_ID, commodityId);
		List<Orders> orderslist = new ArrayList<Orders>();
		while (orderResult.next()) {
			Orders orders = new Orders();
			orders.setCommodityID(orderResult.getInt(Const.COLUNM_COMMODITY_ID));
			orders.setDeliveryDTime(orderResult.getString(Const.COLUNM_DELIVERY_DTIME));
			orders.setOrderDTime(orderResult.getString(Const.COLUNM_ORDER_DTIME));
			orders.setOrderId(orderResult.getInt(Const.COLUNM_ORDER_ID));
			orders.setOrderPrice(orderResult.getDouble(Const.COLUNM_ORDER_PRICE));
			orders.setOrderStatus(orderResult.getString(Const.COLUNM_ORDER_STATUS));
			orders.setReceiveDTime(orderResult.getString(Const.COLUNM_RECEIVE_DTIME));
			orders.setUserId(orderResult.getInt(Const.COLUNM_USER_ID));
			orders.setPhoneNumber(orderResult.getString(Const.COLUNM_PHONENUMBER));
			orders.setOrderAddr(orderResult.getString(Const.COLUNM_ORDER_ADDR));

			orderslist.add(orders);
		}
		dbTools.closeDB();
		return orderslist;
	}

	// 更新订单评论
	public int updateOrderRateByOrderId(String orderId, String rate) {
		DBTools dbTools = new DBTools();

		LinkedHashMap<String, Object> condition = new LinkedHashMap<>();
		LinkedHashMap<String, Object> colunmValue = new LinkedHashMap<>();

		condition.put(Const.COLUNM_ORDER_ID, orderId);
		colunmValue.put(Const.COLUNM_ORDER_RATE, rate);
		int result = dbTools.multiConditionalUpdate(Const.TABLE_ORDERS, condition, colunmValue);
		return result;
	}

	// 更新订单评论
	public int updateOrderAddrAndNumber(String orderId, String number, String addr) {
		DBTools dbTools = new DBTools();

		LinkedHashMap<String, Object> condition = new LinkedHashMap<>();
		LinkedHashMap<String, Object> colunmValue = new LinkedHashMap<>();

		condition.put(Const.COLUNM_ORDER_ID, orderId);
		colunmValue.put(Const.COLUNM_ORDER_ADDR, addr);
		colunmValue.put(Const.COLUNM_PHONENUMBER, number);

		int result = dbTools.multiConditionalUpdate(Const.TABLE_ORDERS, condition, colunmValue);
		return result;
	}

}
