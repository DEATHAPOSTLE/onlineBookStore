package com.servlet.book.order;

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
import com.entity.ShoppingCart;
import com.entity.User;
import com.service.CommodityService;
import com.service.ShoppingCarService;

/**
 * Servlet implementation class Test
 */
@WebServlet("/toPaid")
public class toPaidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public final static String USER_INFORMATION = "user_information";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public toPaidServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String shopCartId = request.getParameter("shopCartId");
		String userAddr = request.getParameter("userAddr");
		String shopId = request.getParameter("shopId");
		String shopNumber = request.getParameter("shopNumber");

		User user = (User) request.getSession().getAttribute(USER_INFORMATION);
		if (user == null) {
			request.getRequestDispatcher("/pages/mall/login.jsp").forward(request, response);

		} else {
			ShoppingCarService shoppingCarService = new ShoppingCarService();
			CommodityService commodityService = new CommodityService();
			double priceCount = 0;

			if (shopNumber == null || "".equals(shopNumber)) {

				try {
					String[] shopCartIds = shopCartId.split(",");
					List<ShoppingCart> shoppingCarts = new ArrayList<>();
					shoppingCarts = shoppingCarService.getShoppingCartByIds(shopCartIds);
					for (ShoppingCart a : shoppingCarts) {
						double price = commodityService.getCommodityById(a.getCommodityId() + "").getCommodityPrice();
						int number = Integer.parseInt(a.getCommodityNumber());
						double priceNumber = price * number;
						priceCount = priceCount + priceNumber;
					}
					if ("2".equals(user.getUserType())) {
						priceCount = priceCount * 0.8;
					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.setAttribute("userAddr", userAddr);
				request.setAttribute("priceCount", priceCount);
				request.setAttribute("shopCartId", shopCartId);
				request.setAttribute("type", "2");
				request.getRequestDispatcher("/pages/mall/pay.jsp").forward(request, response);
				return;

			} else {
				try {
					CommodityBase commodityBase = commodityService.getCommodityById(shopId);
					priceCount = commodityBase.getCommodityPrice() * Integer.parseInt(shopNumber);
					if ("2".equals(user.getUserType())) {
						priceCount = priceCount * 0.8;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.setAttribute("userAddr", userAddr);
				request.setAttribute("shopNumber", shopNumber);
				request.setAttribute("shopId", shopId);
				request.setAttribute("priceCount", priceCount);

				request.setAttribute("type", "1");
				request.getRequestDispatcher("/pages/mall/pay.jsp").forward(request, response);
				return;

			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
