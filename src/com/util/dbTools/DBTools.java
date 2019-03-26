package com.util.dbTools;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import com.uitl.content.Const;
import com.uitl.content.Const.SearchCondition;

public class DBTools {

	Connection conn = null;

	Statement stmt = null;

	ResultSet rs = null;

	PreparedStatement pstmt = null;

	public Connection getConnection() {

		String driverName = "";

		String url = "";

		String username = "";

		String pwd = "";

		try {
			// 数据库连接配置文件路径
			InputStream in = this.getClass().getResourceAsStream("dbconfig.properties");

			Properties pros = new Properties();

			pros.load(in);

			// 驱动名
			driverName = pros.getProperty("database.driver");
			// 连接地址
			url = pros.getProperty("database.url");
			// 用户名
			username = pros.getProperty("database.user");
			// 连接密码
			pwd = pros.getProperty("database.password");

			System.out.println(driverName + "==" + url);

			Class.forName(driverName);

			// 获取连接
			conn = DriverManager.getConnection(url, username, pwd);

		} catch (SQLException e) {
		} catch (ClassNotFoundException e) {
		} catch (IOException e) {
		}
		return conn;
	}

	// 查询表数据总数
	public ResultSet selectCountAll(String tableName) {
		conn = getConnection();
		String sql = "select count(*) from " + tableName;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println("executeQuery:" + e.getMessage());
		}
		return rs;
	}

	// 查询表数据总数
	public ResultSet selectCommodityGroupBy() {
		conn = getConnection();
		String sql = "SELECT CommodityId, COUNT(*) AS commodityCount FROM orders WHERE OrderStatus = 3 GROUP BY CommodityId ORDER BY commodityCount DESC";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println("executeQuery:" + e.getMessage());
		}
		return rs;
	}

	// 查询符合条件的总数
	public ResultSet conditionalSearchCount(String tableName, String colunmName, String codition) {
		String sql = "select count(*) from " + tableName + " where " + colunmName + " = '" + codition + "'";
		conn = getConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println("executeQuery:" + e.getMessage());
		}
		return rs;
	}

	// 全表排序
	public ResultSet selectAllOrderBy(String tableName, String orderBy) {
		conn = getConnection();
		String sql = "select * from " + tableName + " ORDER BY " + orderBy + " DESC";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println("executeQuery:" + e.getMessage());
		}

		return rs;
	}

	// 条件检索排序
	public ResultSet conditionalSearchOrderBy(String tableName, String colunmName, String codition, String orderBy) {
		String sql = "select * from " + tableName + " where " + colunmName + " = '" + codition + "' " + " ORDER BY "
				+ orderBy + " DESC";
		conn = getConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println("executeQuery:" + e.getMessage());
		}

		return rs;
	}

	// 检索全表
	public ResultSet selectAll(String tableName) {
		conn = getConnection();
		String sql = "select * from " + tableName;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println("executeQuery:" + e.getMessage());
		}

		return rs;
	}

	// 条件检索
	public ResultSet conditionalSearch(String tableName, String colunmName, Object codition) {
		String sql = "";
		if (codition instanceof String) {
			sql = "select * from " + tableName + " where " + colunmName + " = '" + codition + "'";
		} else {
			sql = "select * from " + tableName + " where " + colunmName + " = " + codition;
		}

		conn = getConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println("executeQuery:" + e.getMessage());
		}

		return rs;
	}

	// 多条件检索
	public ResultSet multiConditionalSearch(String tableName, LinkedHashMap<String, Object> condition) {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from ");
		sb.append(tableName);
		sb.append(" where ");
		int i = 0;
		for (String key : condition.keySet()) {
			Object value = condition.get(key);
			if (value instanceof String) {
				sb.append(key);
				sb.append(" = '");
				sb.append(value);
				sb.append("'");
			} else {
				sb.append(key);
				sb.append(" = ");
				sb.append(value);
			}
			if (i < condition.keySet().size() - 1) {
				sb.append(" AND ");
			}
			i++;
		}
		String sql = sb.toString();
		conn = getConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println("executeQuery:" + e.getMessage());
		}

		return rs;
	}

	// 复数检索
	public ResultSet pluralSearch(String tableName, List<? extends Object> conditions, String colunmName) {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from ");
		sb.append(tableName);
		sb.append(" where ");

		for (Object condithon : conditions) {
			if (condithon instanceof String) {
				sb.append(colunmName);
				sb.append(" = ");
				sb.append("'");
				sb.append(condithon);
				sb.append("'");
				sb.append(" or ");
			} else {
				sb.append(colunmName);
				sb.append(" = ");
				sb.append(condithon);
				sb.append(" or ");
			}
		}
		String sql = sb.toString();
		int idx = sql.lastIndexOf("or");
		String str1 = sql.substring(0, idx);
		// 通过截取逗号前的字符串
		String str2 = sql.substring(idx + 2, sql.length());// 截取逗号后的字符串
		sql = str1 + str2;
		conn = getConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println("executeQuery:" + e.getMessage());
		}
		return rs;
	}

	// 多条件更新
	public int multiConditionalUpdate(String tableName, LinkedHashMap<String, Object> condition,
			LinkedHashMap<String, Object> colunmValue) {
		StringBuffer sb = new StringBuffer();
		sb.append("update ");
		sb.append(tableName);
		sb.append(" set ");
		int result = 0;
		int i = 0;
		for (String key : colunmValue.keySet()) {
			Object value = colunmValue.get(key);
			if (value instanceof String) {
				sb.append(key);
				sb.append(" = '");
				sb.append(value);
				sb.append("',");
			} else {
				sb.append(key);
				sb.append(" = ");
				sb.append(value);
				sb.append(",");

			}
		}
		sb.append(" where ");
		for (String key : condition.keySet()) {
			Object value = condition.get(key);
			if (value instanceof String) {
				sb.append(key);
				sb.append(" = '");
				sb.append(value);
				sb.append("'");
			} else {
				sb.append(key);
				sb.append(" = ");
				sb.append(value);
			}
			if (i < condition.keySet().size() - 1) {
				sb.append(" AND ");
			}
			i++;
		}
		String sql = sb.toString();
		int idx = sql.lastIndexOf(",");
		String str1 = sql.substring(0, idx);
		;// 通过截取逗号前的字符串
		String str2 = sql.substring(idx + 1, sql.length());// 截取逗号后的字符串
		sql = str1 + str2;
		conn = getConnection();
		try {
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("executeQuery:" + e.getMessage());
		}

		return result;
	}

	// 条件检索
	public ResultSet conditionalSearch(String tableName, Integer colunmName, int codition,
			SearchCondition searchCondition) {
		conn = getConnection();
		String sql = "";

		switch (searchCondition) {
		// 等于
		case EQUAL:
			sql = "select * from " + tableName + " where " + colunmName + " = " + codition;
			break;
		// 小于
		case LESSEQUAL:
			sql = "select * from " + tableName + " where " + colunmName + " < " + codition;
			break;
		case LESSTHAN:
			sql = "select * from " + tableName + " where " + colunmName + " > " + codition;
			break;
		case MOREEQUAL:
			sql = "select * from " + tableName + " where " + colunmName + " <= " + codition;
			break;
		case MORETHAN:
			sql = "select * from " + tableName + " where " + colunmName + " >= " + codition;
			break;
		default:
			break;
		}
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println("executeQuery:" + e.getMessage());
		}

		return rs;
	}

	// 主键检索
	public ResultSet primarykeySearch(String tableName, int primaryKey) {
		conn = getConnection();
		DatabaseMetaData dbmd = null;
		try {
			dbmd = conn.getMetaData();
			rs = dbmd.getPrimaryKeys(null, null, tableName);
			String tablePk = rs.getString("COLUMN_NAME");
			String sql = "select * from " + tableName + " where " + tablePk + " = " + primaryKey;

			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println("executeQuery:" + e.getMessage());
		}

		return rs;
	}

	// 条件删除
	public int deleteByCondition(String tableName, String colunmName, String codition) {
		conn = getConnection();
		int i = 1;
		String sql = "DELETE from " + tableName + " where " + colunmName + " = " + codition;
		try {
			stmt = conn.createStatement();
			i = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("executeQuery:" + e.getMessage());
		}

		return i;
	}

	// 插入
	public int insertAll(Object bean) {
		conn = getConnection();
		int result = 0;
		String tableName = "";
		String beanName = bean.getClass().getName();
		switch (beanName) {
		case Const.BEAN_COMMODITY_BASE:
			tableName = Const.TABLE_COMMODITY_BASE;
			break;
		case Const.BEAN_HANDICAPPED:
			tableName = Const.TABLE_HANDICAPPED;
			break;
		case Const.BEAN_ORDERS:
			tableName = Const.TABLE_ORDERS;
			break;
		case Const.BEAN_REJECTED:
			tableName = Const.TABLE_REJECTED;
			break;
		case Const.BEAN_SHOPPING_CART:
			tableName = Const.TABLE_SHOPPING_CART;
			break;
		case Const.BEAN_USER:
			tableName = Const.TABLE_USER;
			break;
		case Const.BEAN_COMMENT:
			tableName = Const.TABLE_COMMENT;
			break;
		case Const.BEAN_COMMODITY_SHOPPING_CART:
			tableName = Const.TABLE_COMMENT;
			break;
		default:
			break;
		}
		StringBuffer sb = new StringBuffer();
		LinkedHashMap<String, Object> valueMap = getFieldValueMap(bean);
		sb.append("insert into ");
		sb.append(tableName);
		sb.append(" values (");
		for (String key : valueMap.keySet()) {
			sb.append("?,");
		}
		sb.append(");");
		int i = 1;
		String sql = sb.toString();
		int idx = sql.lastIndexOf(",");
		String str1 = sql.substring(0, idx);
		// 通过截取逗号前的字符串
		String str2 = sql.substring(idx + 1, sql.length());// 截取逗号后的字符串
		sql = str1 + str2;
		try {
			pstmt = conn.prepareStatement(sql);
			for (String key : valueMap.keySet()) {
				Object value = valueMap.get(key);
				if (value instanceof String) {
					pstmt.setString(i, (String) value);
				} else if (value instanceof Integer) {
					pstmt.setInt(i, (Integer) value);
				} else if (value instanceof Double) {
					pstmt.setDouble(i, (Double) value);
				} else if (value instanceof Float) {
					pstmt.setFloat(i, (Float) value);
				} else if (value instanceof Long) {
					pstmt.setLong(i, (Long) value);
				} else if (value instanceof Boolean) {
					pstmt.setBoolean(i, (Boolean) value);
				} else if (value instanceof Date) {
					pstmt.setDate(i, (Date) value);
				}
				i++;
			}
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	// 模糊检索
	public ResultSet fuzzySearch(String tableName, String colunmName, String codition) {
		String sql = "select * from " + tableName + " where " + colunmName + " like '%" + codition + "%';";
		conn = getConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println("executeQuery:" + e.getMessage());
		}

		return rs;
	}

	private static LinkedHashMap<String, Object> getFieldValueMap(Object bean) {
		Class<?> cls = bean.getClass();
		LinkedHashMap<String, Object> valueMap = new LinkedHashMap<String, Object>();
		Method[] methods = cls.getDeclaredMethods();
		Field[] fields = cls.getDeclaredFields();
		for (Field field : fields) {
			try {
				String fieldType = field.getType().getSimpleName();
				String fieldGetName = parGetName(field.getName());
				if (!checkGetMet(methods, fieldGetName)) {
					continue;
				}
				Method fieldGetMet = cls.getMethod(fieldGetName, new Class[] {});
				Object fieldVal = fieldGetMet.invoke(bean, new Object[] {});
				Object result = null;
				if ("Date".equals(fieldType)) {
					result = fmtDate((Date) fieldVal);
				} else {
					if (null != fieldVal) {
						result = fieldVal;
					}
				}
				valueMap.put(field.getName(), result);
			} catch (Exception e) {
				continue;
			}
		}
		return valueMap;
	}

	/**
	 * 拼接某属性的 get方法
	 */
	private static String parGetName(String fieldName) {
		if (null == fieldName || "".equals(fieldName)) {
			return null;
		}
		int startIndex = 0;
		if (fieldName.charAt(0) == '_')
			startIndex = 1;
		return "get" + fieldName.substring(startIndex, startIndex + 1).toUpperCase()
				+ fieldName.substring(startIndex + 1);
	}

	/**
	 * 判断是否存在某属性的 get方法
	 */
	private static boolean checkGetMet(Method[] methods, String fieldGetMet) {
		for (Method met : methods) {
			if (fieldGetMet.equals(met.getName())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 日期转化为String
	 */
	private static String fmtDate(Date date) {
		if (null == date) {
			return null;
		}
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINESE);
			return sdf.format(date);
		} catch (Exception e) {
			return null;
		}
	}

	public void closeDB() {
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception ex) {
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (Exception ex) {
			}
		}
	}
}
