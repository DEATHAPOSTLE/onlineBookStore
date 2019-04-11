package com.servlet.book.order;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Orders;
import com.service.OrderService;

/*
 * // 发货servlet
 * 
 */
@WebServlet("/deliverCommodity")
public class DeliverCommodityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeliverCommodityServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	// 发货
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("orderId");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		OrderService orderService = new OrderService();
		Orders orders = new Orders();
		orders.setOrderId(Integer.parseInt(id));
		orders.setOrderStatus("2");
		orders.setDeliveryDTime(sdf.format(new Date()));

		orderService.UpdateOrder(orders);
		response.sendRedirect("/onlineBookStore/GetAllOrdersServlet");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
