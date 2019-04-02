package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import com.entity.CommodityBase;
import com.entity.ShoppingCart;
import com.uitl.content.Const;
import com.util.dbTools.DBTools;

public class ShoppingCarService {
	// 根据userid查询购物车
	public List<ShoppingCart> getShopByUser(String userId) throws SQLException {
		DBTools dbTools = new DBTools();
		ResultSet rs = dbTools.conditionalSearch(Const.TABLE_SHOPPING_CART, Const.COLUNM_USER_ID, userId);
		List<ShoppingCart> list = new ArrayList<ShoppingCart>();
		while (rs.next()) {
			ShoppingCart shop = new ShoppingCart();
			shop.setShoppingCartId(rs.getInt(Const.COLUNM_SHOPPING_CARTID));
			shop.setCommodityId(rs.getInt(Const.COLUNM_COMMODITY_ID));
			shop.setCommodityNumber(rs.getString(Const.COLUNM_COMMODITY_NUMBER));
			shop.setRegisteredDTime(rs.getString(Const.COLUNM_REGISTERED_DTIME));
			shop.setUserId(rs.getString(Const.COLUNM_USER_ID));
			list.add(shop);
		}
		dbTools.closeDB();
		return list;

	}

	// 根据用户id与商品id查询购物车
	public ShoppingCart getShopById(String CommodityId, String userId) throws SQLException {
		DBTools dbTools = new DBTools();
		LinkedHashMap<String, Object> condition = new LinkedHashMap<String, Object>();
		condition.put(Const.COLUNM_COMMODITY_ID, CommodityId);
		condition.put(Const.COLUNM_USER_ID, userId);
		ResultSet rs = dbTools.multiConditionalSearch(Const.TABLE_SHOPPING_CART, condition);
		ShoppingCart shop = new ShoppingCart();
		while (rs.next()) {
			shop.setShoppingCartId(rs.getInt(Const.COLUNM_SHOPPING_CARTID));
			shop.setCommodityId(rs.getInt(Const.COLUNM_COMMODITY_ID));
			shop.setCommodityNumber(rs.getString(Const.COLUNM_COMMODITY_NUMBER));
			shop.setRegisteredDTime(rs.getString(Const.COLUNM_REGISTERED_DTIME));
			shop.setUserId(rs.getString(Const.COLUNM_USER_ID));
		}
		dbTools.closeDB();
		return shop;
	}

	// 按条件查询
	public CommodityBase getShopByShopCar(String CommodityId) throws SQLException {
		DBTools dbTools = new DBTools();
		ResultSet rs = dbTools.conditionalSearch(Const.TABLE_COMMODITY_BASE, Const.COLUNM_COMMODITY_ID, CommodityId);
		CommodityBase shop = new CommodityBase();
		while (rs.next()) {
			shop.setCommodityId(rs.getInt(Const.COLUNM_COMMODITY_ID));
			shop.setCommodityPicture(rs.getString(Const.COLUNM_COMMODITY_PICTURE));
			shop.setCommodityType(rs.getString(Const.COLUNM_COMMODITY_TYPE));
			shop.setCommodityPrice(rs.getInt(Const.COLUNM_COMMODITY_PRICE));
			shop.setCommodityIntroduce(rs.getString(Const.COLUNM_COMMODITY_INTRODUCE));
			shop.setCommoditySurplus(rs.getInt(Const.COLUNM_COMMODITY_SURPLUS));
			shop.setCommodityRate(rs.getString(Const.COLUNM_COMMODITY_RATE));
			shop.setCommodityName(rs.getString(Const.COLUNM_COMMODITY_NAME));
		}
		dbTools.closeDB();
		return shop;

	}

	// 添加进购物车
	public int addShopByShopCar(ShoppingCart shoppingCart) throws SQLException {
		DBTools dbTools = new DBTools();
		int result = dbTools.insertAll(shoppingCart);
		dbTools.closeDB();
		return result;

	}

	// 修改进购物车数量
	public int updateShopByShopCar(ShoppingCart shoppingCart) throws SQLException {
		DBTools dbTools = new DBTools();
		LinkedHashMap<String, Object> conditionMap = new LinkedHashMap<String, Object>();
		LinkedHashMap<String, Object> colunmValueMap = new LinkedHashMap<String, Object>();
		conditionMap.put("ShoppingCartId", shoppingCart.getShoppingCartId());
		colunmValueMap.put("CommodityNumber", shoppingCart.getCommodityNumber());

		int resultSet = dbTools.multiConditionalUpdate(Const.TABLE_SHOPPING_CART, conditionMap, colunmValueMap);
		dbTools.closeDB();
		return resultSet;
	}

	// 删除
	public int delShopByShopCar(String ShoppingCartId) throws SQLException {
		DBTools dbTools = new DBTools();
		int result = dbTools.deleteByCondition(Const.TABLE_SHOPPING_CART, Const.COLUNM_SHOPPING_CARTID, ShoppingCartId);
		dbTools.closeDB();
		return result;
	}

	// 复数id检索
	public List<ShoppingCart> getShoppingCartByIds(String[] ids) throws SQLException {
		DBTools dbTools = new DBTools();
		List<ShoppingCart> shoppingCarts = new ArrayList<ShoppingCart>();
		ResultSet rs = dbTools.pluralSearch(Const.TABLE_SHOPPING_CART, Arrays.asList(ids),
				Const.COLUNM_SHOPPING_CARTID);
		;
		while (rs.next()) {
			ShoppingCart shoppingCart = new ShoppingCart();
			shoppingCart.setShoppingCartId(rs.getInt(Const.COLUNM_SHOPPING_CARTID));
			shoppingCart.setCommodityId(rs.getInt(Const.COLUNM_COMMODITY_ID));
			shoppingCart.setUserId(rs.getString(Const.COLUNM_USER_ID));
			shoppingCart.setCommodityNumber(rs.getString(Const.COLUNM_COMMODITY_NUMBER));
			shoppingCart.setRegisteredDTime(rs.getString(Const.COLUNM_REGISTERED_DTIME));
			shoppingCarts.add(shoppingCart);
		}
		dbTools.closeDB();
		return shoppingCarts;
	}

}
