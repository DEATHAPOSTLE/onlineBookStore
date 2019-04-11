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
@WebServlet("/meetRejected")
public class MeetRejectedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public final static String USER_INFORMATION = "user_information";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MeetRejectedServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	// 管理员确认退货
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = (User) request.getSession().getAttribute(USER_INFORMATION);
		if (!"2".equals(user.getUserType()))
			response.sendRedirect("/onlineBookStore/index");
		else {
			String rejectedId = request.getParameter("rejectedId");
			String requirements = request.getParameter("requirements");
			// 修改退货表状态
			RejectedService rejectedService = new RejectedService();
			try {
				if ("7".equals(requirements)) {
					Rejected rejected = rejectedService.getRejectedListById(rejectedId);
					OrderService orderService = new OrderService();
					Orders orders = orderService.getOrderById(rejected.getOrderId() + "");
					orders.setOrderStatus("8");
					orderService.UpdateOrder(orders);
					rejected.setRejectedStatus("7");
					rejectedService.updateRejected(rejected);
					System.out.println("满足退货要求");
					response.sendRedirect("/onlineBookStore/rejectedList");

				} else if ("6".equals(requirements)) {
					Rejected rejected = rejectedService.getRejectedListById(rejectedId);
					OrderService orderService = new OrderService();
					Orders orders = orderService.getOrderById(rejected.getOrderId() + "");
					orders.setOrderStatus("9");
					orderService.UpdateOrder(orders);
					rejected.setRejectedStatus("6");
					rejectedService.updateRejected(rejected);
					System.out.println("不满足退货要求");
					response.sendRedirect("/onlineBookStore/rejectedList");

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
