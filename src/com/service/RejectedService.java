package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import com.entity.Rejected;
import com.uitl.content.Const;
import com.util.dbTools.DBTools;

public class RejectedService {

	// 添加退货信息
	public int setRejected(Rejected rejected) throws SQLException {
		DBTools dbTools = new DBTools();
		int result = dbTools.insertAll(rejected);
		dbTools.closeDB();
		return result;

	}

	// 修改退货状态
	public int updateRejected(Rejected rejected) throws SQLException {
		DBTools dbTools = new DBTools();
		LinkedHashMap<String, Object> conditionMap = new LinkedHashMap<String, Object>();
		LinkedHashMap<String, Object> colunmValueMap = new LinkedHashMap<String, Object>();
		conditionMap.put("rejectedId", rejected.getRejectedId());
		colunmValueMap.put("rejectedStatus", rejected.getRejectedStatus());
		int resultSet = dbTools.multiConditionalUpdate(Const.TABLE_REJECTED, conditionMap, colunmValueMap);
		dbTools.closeDB();
		return resultSet;

	}

	// 查询审核中的订单表
	public List<Rejected> getRejectedListByStatus(String status) throws SQLException {
		DBTools dbTools = new DBTools();
		List<Rejected> list = new ArrayList<Rejected>();
		ResultSet result = dbTools.conditionalSearch(Const.TABLE_REJECTED, Const.COLUNM_REJECTED_STATUS, status);
		while (result.next()) {
			Rejected rejected = new Rejected();
			rejected.setOrderId(result.getInt(Const.COLUNM_ORDER_ID));
			rejected.setRejectedDTime(result.getString(Const.COLUNM_REJECTED_DTIME));
			rejected.setRejectedId(result.getInt(Const.COLUNM_REJECTED_ID));
			rejected.setRejectedStatus(result.getString(Const.COLUNM_REJECTED_STATUS));
			rejected.setUserId(result.getInt(Const.COLUNM_USER_ID));
			list.add(rejected);
		}
		dbTools.closeDB();
		return list;

	}

	// 查询所有订单
	public List<Rejected> getAllRejectedList() throws SQLException {
		DBTools dbTools = new DBTools();
		List<Rejected> list = new ArrayList<Rejected>();
		ResultSet result = dbTools.selectAll(Const.TABLE_REJECTED);
		while (result.next()) {
			Rejected rejected = new Rejected();
			rejected.setOrderId(result.getInt(Const.COLUNM_ORDER_ID));
			rejected.setRejectedDTime(result.getString(Const.COLUNM_REJECTED_DTIME));
			rejected.setRejectedId(result.getInt(Const.COLUNM_REJECTED_ID));
			rejected.setRejectedStatus(result.getString(Const.COLUNM_REJECTED_STATUS));
			rejected.setUserId(result.getInt(Const.COLUNM_USER_ID));
			list.add(rejected);
		}
		dbTools.closeDB();
		return list;

	}

	// 查询订单根据id
	public Rejected getRejectedListById(String id) throws SQLException {
		DBTools dbTools = new DBTools();
		Rejected rejected = new Rejected();
		ResultSet result = dbTools.conditionalSearch(Const.TABLE_REJECTED, Const.COLUNM_REJECTED_ID, id);
		while (result.next()) {
			rejected.setOrderId(result.getInt(Const.COLUNM_ORDER_ID));
			rejected.setRejectedDTime(result.getString(Const.COLUNM_REJECTED_DTIME));
			rejected.setRejectedId(result.getInt(Const.COLUNM_REJECTED_ID));
			rejected.setRejectedStatus(result.getString(Const.COLUNM_REJECTED_STATUS));
			rejected.setUserId(result.getInt(Const.COLUNM_USER_ID));
		}
		dbTools.closeDB();
		return rejected;

	}

}
