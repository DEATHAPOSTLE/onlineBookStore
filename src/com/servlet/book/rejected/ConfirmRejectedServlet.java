package com.servlet.book.rejected;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Orders;
import com.entity.Rejected;
import com.entity.User;
import com.service.OrderService;
import com.service.RejectedService;

/**
 * Servlet implementation class Test
 */
@WebServlet("/confirmRejected")
public class ConfirmRejectedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public final static String USER_INFORMATION = "user_information";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConfirmRejectedServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute(USER_INFORMATION);

		if (!"3".equals(user.getUserType()))
			request.getRequestDispatcher("/pages/index.jsp").forward(request, response);
		else {
			String rejectedId = request.getParameter("rejectedId");
			String orderId = request.getParameter("orderId");
			// 修改订单状态
			OrderService orderService = new OrderService();
			Orders orders = new Orders();
			orders.setOrderId(Integer.parseInt(orderId));
			orders.setOrderStatus("5");
			orderService.UpdateOrder(orders);
			// 修改退货表状态
			RejectedService rejectedService = new RejectedService();
			Rejected rejected = new Rejected();
			rejected.setRejectedId(Integer.parseInt(rejectedId));
			rejected.setRejectedStatus("1");
			try {
				rejectedService.updateRejected(rejected);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("退货确认");
			response.sendRedirect("/onlineBookStore/rejectedList");

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
