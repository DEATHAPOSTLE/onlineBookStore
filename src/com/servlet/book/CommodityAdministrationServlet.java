package com.servlet.book;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.CommodityBase;
import com.entity.User;
import com.service.CommodityService;

@WebServlet("/commodityAdministration")
public class CommodityAdministrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public final static String USER_INFORMATION = "user_information";

	public CommodityAdministrationServlet() {
		super();
	}

	// 查询所有商品
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = (User) request.getSession().getAttribute(USER_INFORMATION);
		if (!"4".equals(user.getUserType()))
			response.sendRedirect("/onlineBookStore/index");
		else {
			CommodityService commodityService = new CommodityService();

			List<CommodityBase> allList = null;
			try {
				allList = commodityService.getAllCommodityOnAdmin();
				request.setAttribute("allList", allList);

				request.getRequestDispatcher("/pages/manager/logistics.jsp").forward(request, response);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CommodityService shopService = new CommodityService();

		List<CommodityBase> allList = null;
		try {
			allList = shopService.getAllCommodityOnAdmin();
			request.setAttribute("allList", allList);

			request.getRequestDispatcher("/pages/manager/logistics.jsp").forward(request, response);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
