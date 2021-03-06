package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import com.entity.CommodityBaseExamine;
import com.uitl.content.Const;
import com.util.dbTools.DBTools;

public class ExamineService {

	// 返回全部商品，包括下架
	public List<CommodityBaseExamine> getAllExamineCommodity() throws SQLException {
		DBTools dbTools = new DBTools();
		// 商品结果集
		ResultSet rs = dbTools.selectAll(Const.TABLE_EXAMINE);
		// 全部商品
		List<CommodityBaseExamine> allShoplist = new ArrayList<CommodityBaseExamine>();
		while (rs.next()) {
			CommodityBaseExamine commodityBaseExamine = new CommodityBaseExamine();
			commodityBaseExamine.setCommodityExamine(rs.getInt(Const.COLUNM_EXAMINE_EXAMINE));
			commodityBaseExamine.setCommodityPicture(rs.getString(Const.COLUNM_EXAMINE_COMMODITY_PICTURE));
			commodityBaseExamine.setCommodityType(rs.getString(Const.COLUNM_EXAMINE_COMMODITY_TYPE));
			commodityBaseExamine.setCommodityPrice(rs.getInt(Const.COLUNM_EXAMINE_COMMODITY_PRICE));
			commodityBaseExamine.setCommodityIntroduce(rs.getString(Const.COLUNM_EXAMINE_COMMODITY_INTRODUCE));
			commodityBaseExamine.setCommodityName(rs.getString(Const.COLUNM_EXAMINE_COMMODITY_NAME));
			commodityBaseExamine.setExamineId(rs.getInt(Const.COLUNM_EXAMINE_ID));
			commodityBaseExamine.setCommodityPress(rs.getString(Const.COLUNM_EXAMINE__PRESS));
			commodityBaseExamine.setCommodityAuthor(rs.getString(Const.COLUNM_EXAMINE__AUTHOR));

			allShoplist.add(commodityBaseExamine);
		}
		dbTools.closeDB();
		return allShoplist;

	}

	// 按待审核
	public List<CommodityBaseExamine> getNoExamineCommodity(String type) throws SQLException {
		DBTools dbTools = new DBTools();
		List<CommodityBaseExamine> list = new ArrayList<CommodityBaseExamine>();

		ResultSet rs = dbTools.conditionalSearch(Const.TABLE_EXAMINE, Const.COLUNM_EXAMINE_EXAMINE, type);
		while (rs.next()) {
			CommodityBaseExamine commodityBaseExamine = new CommodityBaseExamine();
			commodityBaseExamine.setCommodityExamine(rs.getInt(Const.COLUNM_EXAMINE_EXAMINE));
			commodityBaseExamine.setCommodityPicture(rs.getString(Const.COLUNM_EXAMINE_COMMODITY_PICTURE));
			commodityBaseExamine.setCommodityType(rs.getString(Const.COLUNM_EXAMINE_COMMODITY_TYPE));
			commodityBaseExamine.setCommodityPrice(rs.getInt(Const.COLUNM_EXAMINE_COMMODITY_PRICE));
			commodityBaseExamine.setCommodityIntroduce(rs.getString(Const.COLUNM_EXAMINE_COMMODITY_INTRODUCE));
			commodityBaseExamine.setCommodityName(rs.getString(Const.COLUNM_EXAMINE_COMMODITY_NAME));
			commodityBaseExamine.setExamineId(rs.getInt(Const.COLUNM_EXAMINE_ID));
			commodityBaseExamine.setCommodityPress(rs.getString(Const.COLUNM_EXAMINE__PRESS));
			commodityBaseExamine.setCommodityAuthor(rs.getString(Const.COLUNM_EXAMINE__AUTHOR));
			list.add(commodityBaseExamine);
		}
		dbTools.closeDB();
		return list;
	}

	// 修改审核阶段
	public int updateExamine(CommodityBaseExamine commodityBaseExamine) throws SQLException {
		DBTools dbTools = new DBTools();
		LinkedHashMap<String, Object> conditionMap = new LinkedHashMap<String, Object>();
		LinkedHashMap<String, Object> colunmValueMap = new LinkedHashMap<String, Object>();
		conditionMap.put("examineId", commodityBaseExamine.getExamineId());
		colunmValueMap.put("commodityExamine", commodityBaseExamine.getCommodityExamine());

		int result = dbTools.multiConditionalUpdate(Const.TABLE_EXAMINE, conditionMap, colunmValueMap);
		dbTools.closeDB();
		return result;
	}

	// 注册
	public int addExamine(CommodityBaseExamine commodityBaseExamine) throws SQLException {
		DBTools dbTools = new DBTools();
		int result = dbTools.insertAll(commodityBaseExamine);
		dbTools.closeDB();
		return result;
	}

	// 按条件查询
	public CommodityBaseExamine getExamineCommodityById(String id) throws SQLException {
		DBTools dbTools = new DBTools();
		ResultSet rs = dbTools.conditionalSearch(Const.TABLE_EXAMINE, Const.COLUNM_EXAMINE_ID, id);
		CommodityBaseExamine commodityBaseExamine = new CommodityBaseExamine();
		while (rs.next()) {
			commodityBaseExamine.setCommodityExamine(rs.getInt(Const.COLUNM_EXAMINE_EXAMINE));
			commodityBaseExamine.setCommodityPicture(rs.getString(Const.COLUNM_EXAMINE_COMMODITY_PICTURE));
			commodityBaseExamine.setCommodityType(rs.getString(Const.COLUNM_EXAMINE_COMMODITY_TYPE));
			commodityBaseExamine.setCommodityPrice(rs.getInt(Const.COLUNM_EXAMINE_COMMODITY_PRICE));
			commodityBaseExamine.setCommodityIntroduce(rs.getString(Const.COLUNM_EXAMINE_COMMODITY_INTRODUCE));
			commodityBaseExamine.setCommodityName(rs.getString(Const.COLUNM_EXAMINE_COMMODITY_NAME));
			commodityBaseExamine.setExamineId(rs.getInt(Const.COLUNM_EXAMINE_ID));
			commodityBaseExamine.setCommodityAuthor(rs.getString(Const.COLUNM_EXAMINE__AUTHOR));
			commodityBaseExamine.setCommodityPress(rs.getString(Const.COLUNM_EXAMINE__PRESS));
		}
		dbTools.closeDB();
		return commodityBaseExamine;
	}

}
