package com.servlet.book;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.CommodityBase;
import com.service.CommodityService;
import com.uitl.content.Const;

@WebServlet("/advancedQuery")
public class AdvancedQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdvancedQueryServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/pages/mall/advanced_query.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String author = new String(request.getParameter("author").getBytes("iso-8859-1"), "utf-8");
		String press = new String(request.getParameter("press").getBytes("iso-8859-1"), "utf-8");
		String type = new String(request.getParameter("type").getBytes("iso-8859-1"), "utf-8");
		LinkedHashMap<String, Object> condition = new LinkedHashMap<String, Object>();
		double lowPrice = 0;
		double highPrice = 0;
		if (!"".equals(request.getParameter("lowPrice")))
			lowPrice = Double.parseDouble(request.getParameter("lowPrice"));
		if (!"".equals(request.getParameter("highPrice")))
			highPrice = Double.parseDouble(request.getParameter("highPrice"));

		CommodityService shopService = new CommodityService();
		List<CommodityBase> list = new ArrayList<CommodityBase>();
		List<CommodityBase> CommodityBaseList = new ArrayList<CommodityBase>();
		// 按书名搜索
		if (!"".equals(author))
			condition.put(Const.COLUNM_COMMODITY_AUTHOR, author);
		if (!"".equals(press))
			condition.put(Const.COLUNM_COMMODITY_PRESS, press);
		if (!"".equals(type))
			condition.put(Const.COLUNM_COMMODITY_TYPE, type);

		try {
			if ("".equals(author) && "".equals(press) && "".equals(type)) {
				list = shopService.getAllCommodity();
				if (!"".equals(request.getParameter("lowPrice")) && "".equals(request.getParameter("highPrice"))) {
					for (CommodityBase a : list) {
						System.out.println(a.getCommodityName());
						if (a.getCommodityPrice() > lowPrice) {
							CommodityBaseList.add(a);
						}
					}
				} else if ("".equals(request.getParameter("lowPrice"))
						&& !"".equals(request.getParameter("highPrice"))) {
					for (CommodityBase a : list) {
						System.out.println(a.getCommodityName());
						if (a.getCommodityPrice() < highPrice) {
							CommodityBaseList.add(a);
						}
					}
				} else if ("".equals(request.getParameter("lowPrice"))
						&& "".equals(request.getParameter("highPrice"))) {
					for (CommodityBase a : list) {
						System.out.println(a.getCommodityName());
						CommodityBaseList.add(a);
					}
				} else {
					for (CommodityBase a : list) {
						System.out.println(a.getCommodityName());
						if (a.getCommodityPrice() < highPrice && a.getCommodityPrice() > lowPrice) {
							CommodityBaseList.add(a);
						}
					}
				}
			} else {
				// 全部填写
				list = shopService.getCommoditysLike(condition);
				if (!"".equals(request.getParameter("lowPrice")) && "".equals(request.getParameter("highPrice"))) {
					for (CommodityBase a : list) {
						System.out.println(a.getCommodityName());
						if (a.getCommodityPrice() > lowPrice) {
							CommodityBaseList.add(a);
						}
					}
				} else if ("".equals(request.getParameter("lowPrice"))
						&& !"".equals(request.getParameter("highPrice"))) {
					for (CommodityBase a : list) {
						System.out.println(a.getCommodityName());
						if (a.getCommodityPrice() < highPrice) {
							CommodityBaseList.add(a);
						}
					}
				} else if ("".equals(request.getParameter("lowPrice"))
						&& "".equals(request.getParameter("highPrice"))) {
					for (CommodityBase a : list) {
						System.out.println(a.getCommodityName());
						CommodityBaseList.add(a);
					}
				} else {
					for (CommodityBase a : list) {
						System.out.println(a.getCommodityName());
						if (a.getCommodityPrice() < highPrice && a.getCommodityPrice() > lowPrice) {
							CommodityBaseList.add(a);
						}
					}
				}
			}

			if (list.size() == 0) {
				System.out.println("未查询到结果");
				request.setAttribute("warn", "未查询到结果");
				request.getRequestDispatcher("/pages/mall/list.jsp").forward(request, response);
				return;
			} else {
				request.setAttribute("commodityList", CommodityBaseList);
				request.getRequestDispatcher("/pages/mall/list.jsp").forward(request, response);
				return;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
