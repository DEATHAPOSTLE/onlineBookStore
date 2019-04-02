package com.servlet.book.shoppingCart;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
@WebServlet("/addShopingCar")
public class addShopingCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public final static String USER_INFORMATION = "user_information";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public addShopingCarServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	// 使用ajax
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String commodityId = request.getParameter("commodityId");
		String commodityNumber = request.getParameter("commodityNumber");

		CommodityService shopService = new CommodityService();
		ShoppingCarService shoppingCarService = new ShoppingCarService();
		User user = (User) request.getSession().getAttribute(USER_INFORMATION);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (user == null) {
			request.getRequestDispatcher("/pages/mall/login.jsp").forward(request, response);
		} else {

			try {
				CommodityBase commodityBase = shopService.getCommodityById(commodityId);
				ShoppingCart shoppingCart = shoppingCarService.getShopById(commodityId, user.getUserId() + "");

				if (shoppingCart.getShoppingCartId() == 0) {
					System.out.println("添加");
					shoppingCart.setCommodityId(commodityBase.getCommodityId());
					shoppingCart.setCommodityNumber(commodityNumber);
					shoppingCart.setRegisteredDTime(sdf.format(new Date()) + "");
					shoppingCart.setUserId(user.getUserId() + "");
					shoppingCarService.addShopByShopCar(shoppingCart);
					response.sendRedirect("/handicappedmall/shopingCar");

				} else {
					int numberInShopCar = Integer.parseInt(shoppingCart.getCommodityNumber());
					int numberInt = Integer.parseInt(commodityNumber);
					int numberCount = numberInShopCar + numberInt;
					shoppingCart.setCommodityNumber(numberCount + "");
					shoppingCarService.updateShopByShopCar(shoppingCart);
					System.out.println("修改");
					response.sendRedirect("/handicappedmall/shopingCar");
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
