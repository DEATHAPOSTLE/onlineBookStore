package com.servlet.book.order;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Orders;
import com.entity.User;
import com.service.OrderService;

/**
 * Servlet implementation class Test
 */
@WebServlet("/findOneOrder")
public class FindOneOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public final static String USER_INFORMATION = "user_information";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FindOneOrderServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	// 管理员查看所选的订单
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		OrderService orderService = new OrderService();
		User user = (User) request.getSession().getAttribute(USER_INFORMATION);
		String orderId = request.getParameter("orderId");
		if (!"4".equals(user.getUserType()))
			request.getRequestDispatcher("/pages/index.jsp").forward(request, response);
		else {
			try {
				Orders orders = orderService.getOrderById(orderId);
				if (orders.getOrderId() == 0) {
					System.out.println("未查询到结果");
					request.setAttribute("warn", "未查询到结果");
					request.getRequestDispatcher("/pages/mall/order.jsp").forward(request, response);
				} else {
					request.setAttribute("orders", orders);
					request.getRequestDispatcher("/pages/mall/order.jsp").forward(request, response);
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
