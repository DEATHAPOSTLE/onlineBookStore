package com.servlet.book.order;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.User;
import com.service.OrderService;

/**
 * Servlet implementation class Test
 */
@WebServlet("/updateOrders")
public class UpdateOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public final static String USER_INFORMATION = "user_information";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateOrderServlet() {
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
		String phoneNumber = request.getParameter("phoneNumber");
		String orderAddr = request.getParameter("orderAddr");

		if (!"2".equals(user.getUserType()))
			request.getRequestDispatcher("/pages/index.jsp").forward(request, response);
		else {

			int result = orderService.updateOrderAddrAndNumber(orderId, phoneNumber, orderAddr);
			if (result == 0) {
				System.out.println("修改失败");
				request.setAttribute("warn", "修改失败");
				response.sendRedirect("/handicappedmall/GetAllOrdersServlet");
			} else {
				System.out.println("修改成功");
				response.sendRedirect("/handicappedmall/GetAllOrdersServlet");
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
