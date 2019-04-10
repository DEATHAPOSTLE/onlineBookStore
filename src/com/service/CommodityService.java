package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import com.entity.CommodityBase;
import com.entity.CommodityGroupBy;
import com.entity.User;
import com.uitl.content.Const;
import com.util.dbTools.DBTools;

public class CommodityService {
	// 根据类型推荐商品
	public List<CommodityBase> getCommodityByType(User user) throws SQLException {
		DBTools dbTools = new DBTools();
		// 残疾人信息结果集
		ResultSet handRs = dbTools.conditionalSearch(Const.TABLE_HANDICAPPED, "待定", user.getUserName());
		String handicappedType = null;
		List<CommodityBase> recommendShoplist = new ArrayList<CommodityBase>();

		while (handRs.next()) {
			handicappedType = handRs.getString("待定");
		}
		System.out.println(handicappedType);
		// 根据登陆者的伤残部位推荐商品。
		ResultSet shopRs = dbTools.conditionalSearch(Const.TABLE_COMMODITY_BASE, Const.COLUNM_COMMODITY_TYPE,
				handicappedType);
		while (shopRs.next()) {
			CommodityBase shop = new CommodityBase();
			if ("2".equals(shopRs.getString(Const.COLUNM_COMMODITY_SHELVES)))
				continue;
			shop.setCommodityId(shopRs.getInt(Const.COLUNM_COMMODITY_ID));
			shop.setCommodityPicture(shopRs.getString(Const.COLUNM_COMMODITY_PICTURE));
			shop.setCommodityType(shopRs.getString(Const.COLUNM_COMMODITY_TYPE));
			shop.setCommodityPrice(shopRs.getInt(Const.COLUNM_COMMODITY_PRICE));
			shop.setCommodityIntroduce(shopRs.getString(Const.COLUNM_COMMODITY_INTRODUCE));
			shop.setCommoditySurplus(shopRs.getInt(Const.COLUNM_COMMODITY_SURPLUS));
			shop.setCommodityRate(shopRs.getString(Const.COLUNM_COMMODITY_RATE));
			shop.setCommodityName(shopRs.getString(Const.COLUNM_COMMODITY_NAME));
			shop.setCommodityShelves(shopRs.getString(Const.COLUNM_COMMODITY_SHELVES));

			recommendShoplist.add(shop);

		}
		dbTools.closeDB();
		return recommendShoplist;

	}

	// 根据评价推荐商品
	public List<CommodityBase> getCommodityByEvaluate() throws SQLException {
		DBTools dbTools = new DBTools();
		// 残疾人信息结果集
		List<CommodityBase> recommendShoplist = new ArrayList<CommodityBase>();

		// 根据登陆者的伤残部位推荐商品。
		ResultSet shopRs = dbTools.selectAllOrderBy(Const.TABLE_COMMODITY_BASE, Const.COLUNM_COMMODITY_RATE);
		while (shopRs.next()) {
			CommodityBase shop = new CommodityBase();
			if ("2".equals(shopRs.getString(Const.COLUNM_COMMODITY_SHELVES)))
				continue;
			shop.setCommodityId(shopRs.getInt(Const.COLUNM_COMMODITY_ID));
			shop.setCommodityPicture(shopRs.getString(Const.COLUNM_COMMODITY_PICTURE));
			shop.setCommodityType(shopRs.getString(Const.COLUNM_COMMODITY_TYPE));
			shop.setCommodityPrice(shopRs.getInt(Const.COLUNM_COMMODITY_PRICE));
			shop.setCommodityIntroduce(shopRs.getString(Const.COLUNM_COMMODITY_INTRODUCE));
			shop.setCommoditySurplus(shopRs.getInt(Const.COLUNM_COMMODITY_SURPLUS));
			shop.setCommodityRate(shopRs.getString(Const.COLUNM_COMMODITY_RATE));
			shop.setCommodityName(shopRs.getString(Const.COLUNM_COMMODITY_NAME));
			shop.setCommodityShelves(shopRs.getString(Const.COLUNM_COMMODITY_SHELVES));

			recommendShoplist.add(shop);

		}
		dbTools.closeDB();
		return recommendShoplist;

	}

	// 返回全部商品，包括下架
	public List<CommodityBase> getAllCommodityOnAdmin() throws SQLException {
		DBTools dbTools = new DBTools();
		// 商品结果集
		ResultSet rs = dbTools.selectAll(Const.TABLE_COMMODITY_BASE);
		// 全部商品
		List<CommodityBase> allShoplist = new ArrayList<CommodityBase>();
		while (rs.next()) {
			CommodityBase shop = new CommodityBase();
			shop.setCommodityId(rs.getInt(Const.COLUNM_COMMODITY_ID));
			shop.setCommodityPicture(rs.getString(Const.COLUNM_COMMODITY_PICTURE));
			shop.setCommodityType(rs.getString(Const.COLUNM_COMMODITY_TYPE));
			shop.setCommodityPrice(rs.getInt(Const.COLUNM_COMMODITY_PRICE));
			shop.setCommodityIntroduce(rs.getString(Const.COLUNM_COMMODITY_INTRODUCE));
			shop.setCommoditySurplus(rs.getInt(Const.COLUNM_COMMODITY_SURPLUS));
			shop.setCommodityRate(rs.getString(Const.COLUNM_COMMODITY_RATE));
			shop.setCommodityName(rs.getString(Const.COLUNM_COMMODITY_NAME));
			shop.setCommodityShelves(rs.getString(Const.COLUNM_COMMODITY_SHELVES));

			allShoplist.add(shop);
		}
		dbTools.closeDB();
		return allShoplist;

	}

	// 根据销量推荐商品
	public List<CommodityBase> getShopBySalesCount() throws SQLException {
		DBTools dbTools = new DBTools();
		ResultSet rs = dbTools.selectCommodityGroupBy();
		CommodityGroupBy commodityGroupBy = new CommodityGroupBy();
		List<CommodityBase> allShoplist = new ArrayList<CommodityBase>();
		while (rs.next()) {
			commodityGroupBy.setCommodityCount(rs.getInt("commodityCount"));
			commodityGroupBy.setCommodityId(rs.getInt("CommodityId"));
			ResultSet commdityRs = dbTools.conditionalSearch(Const.TABLE_COMMODITY_BASE, Const.COLUNM_COMMODITY_ID,
					commodityGroupBy.getCommodityId());
			while (commdityRs.next()) {
				CommodityBase shop = new CommodityBase();
				shop.setCommodityId(commdityRs.getInt(Const.COLUNM_COMMODITY_ID));
				shop.setCommodityPicture(commdityRs.getString(Const.COLUNM_COMMODITY_PICTURE));
				shop.setCommodityType(commdityRs.getString(Const.COLUNM_COMMODITY_TYPE));
				shop.setCommodityPrice(commdityRs.getInt(Const.COLUNM_COMMODITY_PRICE));
				shop.setCommodityIntroduce(commdityRs.getString(Const.COLUNM_COMMODITY_INTRODUCE));
				shop.setCommoditySurplus(commdityRs.getInt(Const.COLUNM_COMMODITY_SURPLUS));
				shop.setCommodityRate(commdityRs.getString(Const.COLUNM_COMMODITY_RATE));
				shop.setCommodityName(commdityRs.getString(Const.COLUNM_COMMODITY_NAME));
				shop.setCommodityShelves(commdityRs.getString(Const.COLUNM_COMMODITY_SHELVES));
				allShoplist.add(shop);
			}
		}
		dbTools.closeDB();
		return allShoplist;
	}

	// 修改商品的数量
	public int updateCommodity(CommodityBase commodityBase) throws SQLException {
		DBTools dbTools = new DBTools();
		LinkedHashMap<String, Object> conditionMap = new LinkedHashMap<String, Object>();
		LinkedHashMap<String, Object> colunmValueMap = new LinkedHashMap<String, Object>();
		conditionMap.put("commodityId", commodityBase.getCommodityId());
		colunmValueMap.put("commoditySurplus", commodityBase.getCommoditySurplus());

		int result = dbTools.multiConditionalUpdate(Const.TABLE_COMMODITY_BASE, conditionMap, colunmValueMap);
		dbTools.closeDB();
		return result;
	}

	// 上下架商品
	public int updateCommodityShelves(CommodityBase commodityBase) throws SQLException {
		DBTools dbTools = new DBTools();
		LinkedHashMap<String, Object> conditionMap = new LinkedHashMap<String, Object>();
		LinkedHashMap<String, Object> colunmValueMap = new LinkedHashMap<String, Object>();
		conditionMap.put("commodityId", commodityBase.getCommodityId());
		colunmValueMap.put("commodityShelves", commodityBase.getCommodityShelves());

		int result = dbTools.multiConditionalUpdate(Const.TABLE_COMMODITY_BASE, conditionMap, colunmValueMap);
		dbTools.closeDB();
		return result;
	}

	public List<CommodityBase> getCommodityWithOutUnShelves() throws SQLException {
		DBTools dbTools = new DBTools();
		// 商品结果集
		ResultSet rs = dbTools.selectAll(Const.TABLE_COMMODITY_BASE);
		// 全部商品
		List<CommodityBase> allShoplist = new ArrayList<CommodityBase>();
		while (rs.next()) {
			CommodityBase shop = new CommodityBase();
			if ("2".equals(rs.getString(Const.COLUNM_COMMODITY_SHELVES)))
				continue;
			shop.setCommodityId(rs.getInt(Const.COLUNM_COMMODITY_ID));
			shop.setCommodityPicture(rs.getString(Const.COLUNM_COMMODITY_PICTURE));
			shop.setCommodityType(rs.getString(Const.COLUNM_COMMODITY_TYPE));
			shop.setCommodityPrice(rs.getInt(Const.COLUNM_COMMODITY_PRICE));
			shop.setCommodityIntroduce(rs.getString(Const.COLUNM_COMMODITY_INTRODUCE));
			shop.setCommoditySurplus(rs.getInt(Const.COLUNM_COMMODITY_SURPLUS));
			shop.setCommodityRate(rs.getString(Const.COLUNM_COMMODITY_RATE));
			shop.setCommodityName(rs.getString(Const.COLUNM_COMMODITY_NAME));
			shop.setCommodityShelves(rs.getString(Const.COLUNM_COMMODITY_SHELVES));

			allShoplist.add(shop);
		}
		dbTools.closeDB();
		return allShoplist;
	}

	// 返回全部商品，不返回下架产品
	public List<CommodityBase> getAllCommodity() throws SQLException {
		DBTools dbTools = new DBTools();
		// 商品结果集
		ResultSet rs = dbTools.selectAll(Const.TABLE_COMMODITY_BASE);
		// 全部商品
		List<CommodityBase> allShoplist = new ArrayList<CommodityBase>();
		while (rs.next()) {
			CommodityBase shop = new CommodityBase();
			shop.setCommodityId(rs.getInt(Const.COLUNM_COMMODITY_ID));
			shop.setCommodityPicture(rs.getString(Const.COLUNM_COMMODITY_PICTURE));
			shop.setCommodityType(rs.getString(Const.COLUNM_COMMODITY_TYPE));
			shop.setCommodityPrice(rs.getInt(Const.COLUNM_COMMODITY_PRICE));
			shop.setCommodityIntroduce(rs.getString(Const.COLUNM_COMMODITY_INTRODUCE));
			shop.setCommoditySurplus(rs.getInt(Const.COLUNM_COMMODITY_SURPLUS));
			shop.setCommodityRate(rs.getString(Const.COLUNM_COMMODITY_RATE));
			shop.setCommodityName(rs.getString(Const.COLUNM_COMMODITY_NAME));
			shop.setCommodityShelves(rs.getString(Const.COLUNM_COMMODITY_SHELVES));

			allShoplist.add(shop);
		}
		dbTools.closeDB();
		return allShoplist;

	}

	// 模糊搜索
	public List<CommodityBase> getCommodityLikeName(String fieldName, String conditionName) throws SQLException {
		DBTools dbTools = new DBTools();
		ResultSet rs = dbTools.fuzzySearch(Const.TABLE_COMMODITY_BASE, fieldName, conditionName);
		List<CommodityBase> list = new ArrayList<CommodityBase>();
		rs.beforeFirst();
		while (rs.next()) {
			CommodityBase shop = new CommodityBase();
			if ("2".equals(rs.getString(Const.COLUNM_COMMODITY_SHELVES)))
				continue;
			shop.setCommodityId(rs.getInt(Const.COLUNM_COMMODITY_ID));
			shop.setCommodityPicture(rs.getString(Const.COLUNM_COMMODITY_PICTURE));
			shop.setCommodityType(rs.getString(Const.COLUNM_COMMODITY_TYPE));
			shop.setCommodityPrice(rs.getInt(Const.COLUNM_COMMODITY_PRICE));
			shop.setCommodityIntroduce(rs.getString(Const.COLUNM_COMMODITY_INTRODUCE));
			shop.setCommoditySurplus(rs.getInt(Const.COLUNM_COMMODITY_SURPLUS));
			shop.setCommodityRate(rs.getString(Const.COLUNM_COMMODITY_RATE));
			shop.setCommodityName(rs.getString(Const.COLUNM_COMMODITY_NAME));
			shop.setCommodityShelves(rs.getString(Const.COLUNM_COMMODITY_SHELVES));
			shop.setCommodityPress(rs.getString(Const.COLUNM_COMMODITY_PRESS));
			shop.setCommodityAuthor(rs.getString(Const.COLUNM_COMMODITY_AUTHOR));

			list.add(shop);
		}
		dbTools.closeDB();
		return list;

	}

	// 模糊搜索type
	public List<CommodityBase> getCommodityLikeType(String type) throws SQLException {
		DBTools dbTools = new DBTools();
		ResultSet rs = dbTools.fuzzySearch(Const.TABLE_COMMODITY_BASE, Const.COLUNM_COMMODITY_TYPE, type);
		List<CommodityBase> list = new ArrayList<CommodityBase>();
		rs.beforeFirst();
		while (rs.next()) {
			CommodityBase shop = new CommodityBase();
			if ("2".equals(rs.getString(Const.COLUNM_COMMODITY_SHELVES)))
				continue;
			shop.setCommodityId(rs.getInt(Const.COLUNM_COMMODITY_ID));
			shop.setCommodityPicture(rs.getString(Const.COLUNM_COMMODITY_PICTURE));
			shop.setCommodityType(rs.getString(Const.COLUNM_COMMODITY_TYPE));
			shop.setCommodityPrice(rs.getInt(Const.COLUNM_COMMODITY_PRICE));
			shop.setCommodityIntroduce(rs.getString(Const.COLUNM_COMMODITY_INTRODUCE));
			shop.setCommoditySurplus(rs.getInt(Const.COLUNM_COMMODITY_SURPLUS));
			shop.setCommodityRate(rs.getString(Const.COLUNM_COMMODITY_RATE));
			shop.setCommodityName(rs.getString(Const.COLUNM_COMMODITY_NAME));
			shop.setCommodityShelves(rs.getString(Const.COLUNM_COMMODITY_SHELVES));

			list.add(shop);
		}
		dbTools.closeDB();
		return list;

	}

	// 按条件查询
	public CommodityBase getCommodityByName(String name) throws SQLException {
		DBTools dbTools = new DBTools();
		ResultSet rs = dbTools.conditionalSearch(Const.TABLE_COMMODITY_BASE, Const.COLUNM_COMMODITY_NAME, name);
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

	// 按条件查询
	public CommodityBase getCommodityById(String id) throws SQLException {
		DBTools dbTools = new DBTools();
		ResultSet rs = dbTools.conditionalSearch(Const.TABLE_COMMODITY_BASE, Const.COLUNM_COMMODITY_ID, id);
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

	// 按条件查询
	public List<CommodityBase> getCommodityByIds(String[] ids) throws SQLException {
		DBTools dbTools = new DBTools();
		List<CommodityBase> commodityBases = new ArrayList<CommodityBase>();
		ResultSet rs = dbTools.pluralSearch(Const.TABLE_COMMODITY_BASE, Arrays.asList(ids), Const.COLUNM_COMMODITY_ID);
		;
		while (rs.next()) {
			CommodityBase shop = new CommodityBase();
			shop.setCommodityId(rs.getInt(Const.COLUNM_COMMODITY_ID));
			shop.setCommodityPicture(rs.getString(Const.COLUNM_COMMODITY_PICTURE));
			shop.setCommodityType(rs.getString(Const.COLUNM_COMMODITY_TYPE));
			shop.setCommodityPrice(rs.getInt(Const.COLUNM_COMMODITY_PRICE));
			shop.setCommodityIntroduce(rs.getString(Const.COLUNM_COMMODITY_INTRODUCE));
			shop.setCommoditySurplus(rs.getInt(Const.COLUNM_COMMODITY_SURPLUS));
			shop.setCommodityRate(rs.getString(Const.COLUNM_COMMODITY_RATE));
			shop.setCommodityName(rs.getString(Const.COLUNM_COMMODITY_NAME));
			commodityBases.add(shop);
		}
		dbTools.closeDB();
		return commodityBases;
	}

	// 更新评分
	public int updateRate(String rate, String commodityId) {
		DBTools dbTools = new DBTools();

		LinkedHashMap<String, Object> condition = new LinkedHashMap<>();
		LinkedHashMap<String, Object> colunmValue = new LinkedHashMap<>();

		condition.put(Const.COLUNM_COMMODITY_ID, commodityId);
		colunmValue.put(Const.COLUNM_COMMODITY_RATE, rate);
		int result = dbTools.multiConditionalUpdate(Const.TABLE_COMMODITY_BASE, condition, colunmValue);
		return result;
	}

	// 更新评分
	public int addCommodity(CommodityBase commodity) {
		DBTools dbTools = new DBTools();
		int result = dbTools.insertAll(commodity);
		return result;
	}

}
