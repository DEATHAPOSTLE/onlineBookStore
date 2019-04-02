package com.servlet.product;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.CommodityBase;
import com.service.CommodityService;

@WebServlet("/findCommodity")
public class FindCommodityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FindCommodityServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = new String(request.getParameter("commodityName").getBytes("iso-8859-1"), "utf-8");
		CommodityService shopService = new CommodityService();
		try {

			if (name == null || "".equals(name)) {
				List<CommodityBase> list = shopService.getAllCommodity();
				request.setAttribute("commodityList", list);
				request.getRequestDispatcher("/pages/mall/commodity-list.jsp").forward(request, response);
			} else {
				List<CommodityBase> list = shopService.getCommodityLikeName(name);
				if (list.size() == 0) {
					System.out.println("未查询到结果");
					request.setAttribute("warn", "未查询到结果");
					request.getRequestDispatcher("/pages/mall/commodity-list.jsp").forward(request, response);
				} else {
					for (CommodityBase d : list) {
						System.out.println(d.getCommodityName());
					}
					request.setAttribute("commodityList", list);
					request.getRequestDispatcher("/pages/mall/commodity-list.jsp").forward(request, response);

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("commodityName");
		CommodityService shopService = new CommodityService();
		try {
			if (name == null || "".equals(name)) {
				List<CommodityBase> list = shopService.getAllCommodity();
				request.setAttribute("commodityList", list);
				request.getRequestDispatcher("/pages/mall/commodity-list.jsp").forward(request, response);
			} else {
				List<CommodityBase> list = shopService.getCommodityLikeName(name);
				if (list.size() == 0) {
					System.out.println("未查询到结果");
					request.setAttribute("warn", "未查询到结果");
					request.getRequestDispatcher("/pages/mall/commodity-list.jsp").forward(request, response);
				} else {
					for (CommodityBase d : list) {
						System.out.println(d.getCommodityName());
					}
					request.setAttribute("commodityList", list);
					request.getRequestDispatcher("/pages/mall/commodity-list.jsp").forward(request, response);

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
