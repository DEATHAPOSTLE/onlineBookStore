package com.servlet.background;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Orders;
import com.service.OrderService;

/**
 * Servlet implementation class SearchOrderByIdServlet
 */
@WebServlet("/searchOrderByIdServlet")
public class SearchOrderByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchOrderByIdServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String orderId = request.getParameter("orderId");
		Orders order = new Orders();
		List<Orders> orders = new ArrayList<>();

		OrderService orderService = new OrderService();
		try {
			order = orderService.getOrderById(orderId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		orders.add(order);
		request.setAttribute("orders", orders);
		request.getRequestDispatcher("pages/manager/orderManagement.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
