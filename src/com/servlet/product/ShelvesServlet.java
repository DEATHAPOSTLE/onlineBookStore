package com.servlet.product;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.CommodityBase;
import com.service.CommodityService;

@WebServlet("/shelves")
public class ShelvesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShelvesServlet() {
		super();
	}

	// 查询所有商品
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CommodityService shopService = new CommodityService();
		String shopId = request.getParameter("shopId");
		String shelves = request.getParameter("shelves");

		try {
			if ("1".equals(shelves)) {
				CommodityBase commodityBase = shopService.getCommodityById(shopId);
				commodityBase.setCommodityShelves("2");
				shopService.updateCommodityShelves(commodityBase);
				response.sendRedirect("/handicappedmall/commodityAdministration");

			} else {
				CommodityBase commodityBase = shopService.getCommodityById(shopId);
				commodityBase.setCommodityShelves("1");
				shopService.updateCommodityShelves(commodityBase);
				response.sendRedirect("/handicappedmall/commodityAdministration");

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CommodityService shopService = new CommodityService();
		String shopId = request.getParameter("shopId");
		try {
			CommodityBase commodityBase = shopService.getCommodityById(shopId);
			commodityBase.setCommodityShelves("2");
			shopService.updateCommodityShelves(commodityBase);
			response.sendRedirect("/handicappedmall/commodityAdministration");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
