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

import com.entity.ShoppingCart;
import com.service.ShoppingCarService;

/**
 * Servlet implementation class ShopingCartAccountServlet
 */
@WebServlet("/shopingCartAccountServlet")
public class ShopingCartAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShopingCartAccountServlet() {
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

		if (shopCartId == null) {
			request.getRequestDispatcher("/index").forward(request, response);
		}
		String[] shopCartIds = shopCartId.split(",");
		List<ShoppingCart> shoppingCarts = new ArrayList<>();
		ShoppingCarService ShoppingCarService = new ShoppingCarService();
		try {
			shoppingCarts = ShoppingCarService.getShoppingCartByIds(shopCartIds);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String[] commodityIds = new String[shoppingCarts.size()];
		request.getParameterValues("shopId");
		String[] commodityCounts = new String[shoppingCarts.size()];
		String[] shoppingCartIds = new String[shoppingCarts.size()];
		request.getParameterValues("shopNumber");

		int i = 0;
		for (ShoppingCart shoppingCart : shoppingCarts) {
			commodityIds[i] = String.valueOf(shoppingCart.getCommodityId());
			commodityCounts[i] = String.valueOf(shoppingCart.getCommodityNumber());
			shoppingCartIds[i] = String.valueOf(shoppingCart.getShoppingCartId());
			i++;
		}

		request.setAttribute("shopId", commodityIds);
		request.setAttribute("userAddr", userAddr);
		request.setAttribute("shopNumber", commodityCounts);
		request.setAttribute("shoppingCartIds", shoppingCartIds);

		request.getRequestDispatcher("/pay").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
