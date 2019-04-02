package com.servlet.product.rejected;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Orders;
import com.entity.Rejected;
import com.service.OrderService;
import com.service.RejectedService;

/**
 * Servlet implementation class Test
 */
@WebServlet("/rejected")
public class RejectedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RejectedServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("orderId");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		RejectedService rejectedService = new RejectedService();
		OrderService orderService = new OrderService();
		Orders orders = new Orders();
		orders.setOrderId(Integer.parseInt(id));
		orders.setOrderStatus("4");
		orderService.UpdateOrder(orders);
		try {
			orders = orderService.getOrderById(id);
			Rejected rejected = new Rejected();
			rejected.setOrderId(orders.getOrderId());
			rejected.setRejectedDTime(sdf.format(new Date()));
			rejected.setRejectedStatus("3");
			rejected.setUserId(orders.getUserId());
			rejectedService.setRejected(rejected);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.sendRedirect("/handicappedmall/getUserOrder");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
