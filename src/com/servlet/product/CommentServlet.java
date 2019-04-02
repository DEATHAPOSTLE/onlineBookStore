package com.servlet.product;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.CommodityBase;
import com.service.CommodityService;

/**
 * Servlet implementation class CommentServlet
 */
@WebServlet("/commentServlet")
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CommentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String commodityId = request.getParameter("commodityId");
		String orderId = request.getParameter("orderId");
		CommodityService commodityService = new CommodityService();
		CommodityBase commodityBase = new CommodityBase();
		try {
			commodityBase = commodityService.getCommodityById(commodityId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("commodityBase", commodityBase);
		request.setAttribute("orderId", orderId);
		request.getRequestDispatcher("/pages/mall/setComment.jsp").forward(request, response);
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
