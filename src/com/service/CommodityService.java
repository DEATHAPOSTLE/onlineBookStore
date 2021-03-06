package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import com.entity.CommodityBase;
import com.entity.CommodityGroupBy;
import com.entity.Favorites;
import com.entity.User;
import com.uitl.content.Const;
import com.uitl.dto.CommoditySalesDto;
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
			shop.setCommodityPress(shopRs.getString(Const.COLUNM_COMMODITY_PRESS));
			shop.setCommodityAuthor(shopRs.getString(Const.COLUNM_COMMODITY_AUTHOR));

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
			shop.setCommodityPress(shopRs.getString(Const.COLUNM_COMMODITY_PRESS));
			shop.setCommodityAuthor(shopRs.getString(Const.COLUNM_COMMODITY_AUTHOR));

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
			shop.setCommodityPress(rs.getString(Const.COLUNM_COMMODITY_PRESS));
			shop.setCommodityAuthor(rs.getString(Const.COLUNM_COMMODITY_AUTHOR));

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
				if ("2".equals(rs.getString(Const.COLUNM_COMMODITY_SHELVES)))
					continue;
				shop.setCommodityId(commdityRs.getInt(Const.COLUNM_COMMODITY_ID));
				shop.setCommodityPicture(commdityRs.getString(Const.COLUNM_COMMODITY_PICTURE));
				shop.setCommodityType(commdityRs.getString(Const.COLUNM_COMMODITY_TYPE));
				shop.setCommodityPrice(commdityRs.getInt(Const.COLUNM_COMMODITY_PRICE));
				shop.setCommodityIntroduce(commdityRs.getString(Const.COLUNM_COMMODITY_INTRODUCE));
				shop.setCommoditySurplus(commdityRs.getInt(Const.COLUNM_COMMODITY_SURPLUS));
				shop.setCommodityRate(commdityRs.getString(Const.COLUNM_COMMODITY_RATE));
				shop.setCommodityName(commdityRs.getString(Const.COLUNM_COMMODITY_NAME));
				shop.setCommodityShelves(commdityRs.getString(Const.COLUNM_COMMODITY_SHELVES));
				shop.setCommodityPress(rs.getString(Const.COLUNM_COMMODITY_PRESS));
				shop.setCommodityAuthor(rs.getString(Const.COLUNM_COMMODITY_AUTHOR));

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

	// 返回全部商品，不返回下架产品
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
			shop.setCommodityPress(rs.getString(Const.COLUNM_COMMODITY_PRESS));
			shop.setCommodityAuthor(rs.getString(Const.COLUNM_COMMODITY_AUTHOR));

			allShoplist.add(shop);
		}
		dbTools.closeDB();
		return allShoplist;
	}

	public List<CommodityBase> getAllCommodity() throws SQLException {
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
			shop.setCommodityPress(rs.getString(Const.COLUNM_COMMODITY_PRESS));
			shop.setCommodityAuthor(rs.getString(Const.COLUNM_COMMODITY_AUTHOR));
			shop.setCommodityInPrice(rs.getDouble(Const.COLUNM_COMMODITY_INPRICE));

			allShoplist.add(shop);
		}
		dbTools.closeDB();
		return allShoplist;

	}

	public List<CommodityBase> getAllCommoditySalesVolume() throws SQLException {
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
			shop.setCommodityPress(rs.getString(Const.COLUNM_COMMODITY_PRESS));
			shop.setCommodityAuthor(rs.getString(Const.COLUNM_COMMODITY_AUTHOR));
			shop.setCommodityInPrice(rs.getDouble(Const.COLUNM_COMMODITY_INPRICE));

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

	// 多条件模糊查询
	public List<CommodityBase> getCommoditysLike(LinkedHashMap<String, Object> condition) throws SQLException {
		DBTools dbTools = new DBTools();
		ResultSet rs = dbTools.multiConditionalSearchLike(Const.TABLE_COMMODITY_BASE, condition);
		List<CommodityBase> list = new ArrayList<CommodityBase>();
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
			shop.setCommodityPress(rs.getString(Const.COLUNM_COMMODITY_PRESS));
			shop.setCommodityAuthor(rs.getString(Const.COLUNM_COMMODITY_AUTHOR));

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
			shop.setCommodityPress(rs.getString(Const.COLUNM_COMMODITY_PRESS));
			shop.setCommodityAuthor(rs.getString(Const.COLUNM_COMMODITY_AUTHOR));

		}
		dbTools.closeDB();
		return shop;
	}

	// 按条件查询
	public List<CommodityBase> getCommodityByType(String name, String type) throws SQLException {
		DBTools dbTools = new DBTools();
		ResultSet rs = dbTools.conditionalSearch(Const.TABLE_COMMODITY_BASE, type, name);
		List<CommodityBase> list = new ArrayList<CommodityBase>();
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
			shop.setCommodityPress(rs.getString(Const.COLUNM_COMMODITY_PRESS));
			shop.setCommodityAuthor(rs.getString(Const.COLUNM_COMMODITY_AUTHOR));
			list.add(shop);
		}
		dbTools.closeDB();
		return list;
	}

	// 按条件查询不含下架
	public CommodityBase getCommodityById(String id) throws SQLException {
		DBTools dbTools = new DBTools();
		ResultSet rs = dbTools.conditionalSearch(Const.TABLE_COMMODITY_BASE, Const.COLUNM_COMMODITY_ID, id);
		CommodityBase shop = new CommodityBase();
		while (rs.next()) {
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
			shop.setCommodityPress(rs.getString(Const.COLUNM_COMMODITY_PRESS));
			shop.setCommodityAuthor(rs.getString(Const.COLUNM_COMMODITY_AUTHOR));
			shop.setCommodityContent(rs.getString(Const.COLUNM_COMMODITY_CONTENT));
			shop.setCommodityList(rs.getString(Const.COLUNM_COMMODITY_LIST));
		}
		dbTools.closeDB();
		return shop;
	}

	// 按条件查询含下架
	public CommodityBase getCommodityByIdShelves(String id) throws SQLException {
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
			shop.setCommodityPress(rs.getString(Const.COLUNM_COMMODITY_PRESS));
			shop.setCommodityAuthor(rs.getString(Const.COLUNM_COMMODITY_AUTHOR));

		}
		dbTools.closeDB();
		return shop;
	}

	// 按条件查询
	public List<CommodityBase> getCommodityByIds(List<String> ids) throws SQLException {
		DBTools dbTools = new DBTools();
		List<CommodityBase> commodityBases = new ArrayList<CommodityBase>();
		ResultSet rs = dbTools.pluralSearch(Const.TABLE_COMMODITY_BASE, ids, Const.COLUNM_COMMODITY_ID);
		;
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
			shop.setCommodityPress(rs.getString(Const.COLUNM_COMMODITY_PRESS));
			shop.setCommodityAuthor(rs.getString(Const.COLUNM_COMMODITY_AUTHOR));

			commodityBases.add(shop);
		}
		dbTools.closeDB();
		return commodityBases;
	}

	public int updateRate(String rate, String commodityId) {
		DBTools dbTools = new DBTools();

		LinkedHashMap<String, Object> condition = new LinkedHashMap<>();
		LinkedHashMap<String, Object> colunmValue = new LinkedHashMap<>();

		condition.put(Const.COLUNM_COMMODITY_ID, commodityId);
		colunmValue.put(Const.COLUNM_COMMODITY_RATE, rate);
		int result = dbTools.multiConditionalUpdate(Const.TABLE_COMMODITY_BASE, condition, colunmValue);
		return result;
	}

	public int addCommodity(CommodityBase commodity) {
		DBTools dbTools = new DBTools();
		int result = dbTools.insertAll(commodity);
		return result;
	}

	// 查询收藏夹
	public List<Favorites> getUserFavorites(Integer uid) throws SQLException {
		DBTools dbTools = new DBTools();
		List<Favorites> favoritess = new ArrayList<Favorites>();
		ResultSet rs = dbTools.conditionalSearch(Const.TABLE_FAVORITES, Const.COLUNM_USER_ID, String.valueOf(uid));
		while (rs.next()) {
			Favorites favorites = new Favorites();
			favorites.setUserId(Integer.valueOf(rs.getString(Const.COLUNM_USER_ID)));
			favorites.setFavoritesId(Integer.valueOf(rs.getString(Const.COLUNM_FAVORITES_ID)));
			favorites.setNum(Integer.valueOf(rs.getString(Const.COLUNM_FAVORITES_NUM)));
			favorites.setCommodityId(rs.getString(Const.COLUNM_COMMODITY_ID));
			favoritess.add(favorites);
		}
		return favoritess;
	}

	// 查询单独收藏夹
	public Favorites getUserOneFavorites(Integer uid, Integer commodityId) throws SQLException {
		DBTools dbTools = new DBTools();
		LinkedHashMap<String, Object> condition = new LinkedHashMap<String, Object>();
		condition.put(Const.COLUNM_FAVORITES_USER_ID, uid);
		condition.put(Const.COLUNM_FAVORITES_COMMODITY_ID, commodityId);
		ResultSet rs = dbTools.multiConditionalSearch(Const.TABLE_FAVORITES, condition);
		Favorites favorites = new Favorites();
		while (rs.next()) {
			favorites.setUserId(Integer.valueOf(rs.getString(Const.COLUNM_USER_ID)));
			favorites.setFavoritesId(Integer.valueOf(rs.getString(Const.COLUNM_FAVORITES_ID)));
			favorites.setNum(Integer.valueOf(rs.getString(Const.COLUNM_FAVORITES_NUM)));
			favorites.setCommodityId(rs.getString(Const.COLUNM_COMMODITY_ID));
		}
		return favorites;
	}

	// 插入收藏
	public int insertFavorites(Integer userId, Integer commodityId) {
		Favorites favorites = new Favorites();
		DBTools dbTools = new DBTools();
		favorites.setCommodityId(String.valueOf(commodityId));
		favorites.setNum(1);
		favorites.setUserId(userId);
		int result = dbTools.insertAll(favorites);
		return result;
	}

	// 删除收藏
	public int deleteFavorites(Integer userId, Integer commodityId) {
		LinkedHashMap<String, Object> condition = new LinkedHashMap<>();
		DBTools dbTools = new DBTools();
		condition.put(Const.COLUNM_USER_ID, userId);
		condition.put(Const.COLUNM_COMMODITY_ID, String.valueOf(commodityId));
		int result = dbTools.multiConditionalDelete(Const.TABLE_FAVORITES, condition);
		return result;
	}

	public List<CommoditySalesDto> selectCountOrdersByCommodityId() throws SQLException {
		List<CommoditySalesDto> commoditySalesDtos = new ArrayList<CommoditySalesDto>();
		DBTools dbTools = new DBTools();
		String sql = "select * from commodity_base t1 join (select commodityID, count(*) as salesCount from orders group by commodityID) t2 on t1.commodityId = t2.commodityID;";
		ResultSet rs = dbTools.selectBySql(sql);
		// 全部商品
		while (rs.next()) {
			CommoditySalesDto commoditySalesDto = new CommoditySalesDto();
			commoditySalesDto.setCommodityId(rs.getInt(Const.COLUNM_COMMODITY_ID));
			commoditySalesDto.setCommodityPicture(rs.getString(Const.COLUNM_COMMODITY_PICTURE));
			commoditySalesDto.setCommodityType(rs.getString(Const.COLUNM_COMMODITY_TYPE));
			commoditySalesDto.setCommodityPrice(rs.getInt(Const.COLUNM_COMMODITY_PRICE));
			commoditySalesDto.setCommodityIntroduce(rs.getString(Const.COLUNM_COMMODITY_INTRODUCE));
			commoditySalesDto.setCommoditySurplus(rs.getInt(Const.COLUNM_COMMODITY_SURPLUS));
			commoditySalesDto.setCommodityRate(rs.getString(Const.COLUNM_COMMODITY_RATE));
			commoditySalesDto.setCommodityName(rs.getString(Const.COLUNM_COMMODITY_NAME));
			commoditySalesDto.setCommodityShelves(rs.getString(Const.COLUNM_COMMODITY_SHELVES));
			commoditySalesDto.setCommodityPress(rs.getString(Const.COLUNM_COMMODITY_PRESS));
			commoditySalesDto.setCommodityAuthor(rs.getString(Const.COLUNM_COMMODITY_AUTHOR));
			commoditySalesDto.setCommodityInPrice(rs.getDouble(Const.COLUNM_COMMODITY_INPRICE));
			commoditySalesDto.setSalesCount(rs.getInt(Const.COLUNM_SALES_COUNT));
			commoditySalesDtos.add(commoditySalesDto);
		}
		dbTools.closeDB();

		return commoditySalesDtos;
	}

}
