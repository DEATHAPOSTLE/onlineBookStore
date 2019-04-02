package com.servlet.book.shoppingCart;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.ShoppingCarService;

/**
 * Servlet implementation class Test
 */
@WebServlet("/delShopingCar")
public class delShopingCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public final static String USER_INFORMATION = "user_information";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public delShopingCarServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("shopId");
		ShoppingCarService shoppingCarService = new ShoppingCarService();
		try {
			int result = shoppingCarService.delShopByShopCar(id);
			if (result == 0) {
				System.out.println("删除失败");
				request.setAttribute("warn", "删除失败");
				response.sendRedirect("/handicappedmall/shopingCar");
			} else {
				System.out.println(result);
				response.sendRedirect("/handicappedmall/shopingCar");

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
