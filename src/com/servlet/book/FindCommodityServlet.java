package com.servlet.book;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.CommodityBase;
import com.service.CommodityService;
import com.uitl.content.Const;

@WebServlet("/findCommodity")
public class FindCommodityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FindCommodityServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = new String(request.getParameter("conditionName").getBytes("ISO-8859-1"), "UTF-8");
		// String name = new
		// String(request.getParameter("commodityName").getBytes("iso-8859-1"),
		// "utf-8");
		CommodityService shopService = new CommodityService();
		List<CommodityBase> list = new ArrayList<CommodityBase>();
		try {

			if (name == null || "".equals(name)) {
				list = shopService.getAllCommodity();
				request.setAttribute("commodityList", list);
				request.getRequestDispatcher("/pages/mall/list.jsp").forward(request, response);
			} else {
				// 按书名搜索
				list = shopService.getCommodityLikeName(Const.COLUNM_COMMODITY_NAME, name);

				if (list.size() == 0) {
					System.out.println("未查询到结果");
					request.setAttribute("warn", "未查询到结果");
					request.getRequestDispatcher("/pages/mall/list.jsp").forward(request, response);
				} else {
					for (CommodityBase a : list) {
						System.out.println(a.toString());
					}

					request.setAttribute("commodityList", list);
					request.getRequestDispatcher("/pages/mall/list.jsp").forward(request, response);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = new String(request.getParameter("conditionName").getBytes("iso-8859-1"), "utf-8");
		CommodityService shopService = new CommodityService();
		List<CommodityBase> list = new ArrayList<CommodityBase>();
		try {

			if (name == null || "".equals(name)) {
				list = shopService.getAllCommodity();
				request.setAttribute("commodityList", list);
				request.getRequestDispatcher("/pages/mall/list.jsp").forward(request, response);
				return;
			} else {
				// 按书名搜索
				list = shopService.getCommodityLikeName(Const.COLUNM_COMMODITY_NAME, name);

				if (list.size() == 0) {
					System.out.println("未查询到结果");
					request.setAttribute("warn", "未查询到结果");
					request.getRequestDispatcher("/pages/mall/list.jsp").forward(request, response);
					return;
				} else {
					request.setAttribute("commodityList", list);
					request.getRequestDispatcher("/pages/mall/list.jsp").forward(request, response);
					return;
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
