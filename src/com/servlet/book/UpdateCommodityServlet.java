package com.servlet.book;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.CommodityBase;
import com.service.CommodityService;

@WebServlet("/updateCommodity")
public class UpdateCommodityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateCommodityServlet() {
		super();
	}

	// 查询所有商品
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CommodityService shopService = new CommodityService();
		String shopId = request.getParameter("shopId");
		String shopNumber = request.getParameter("number");
		int number = Integer.parseInt(shopNumber);

		try {
			CommodityBase commodityBase = new CommodityBase();
			CommodityBase commodityBase2 = shopService.getCommodityById(shopId);
			commodityBase.setCommodityId(Integer.parseInt(shopId));
			commodityBase.setCommoditySurplus(number + commodityBase2.getCommoditySurplus());
			int result = shopService.updateCommodity(commodityBase);
			response.sendRedirect("/onlineBookStore/commodityAdministration");

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
			response.sendRedirect("/onlineBookStore/commodityAdministration");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
