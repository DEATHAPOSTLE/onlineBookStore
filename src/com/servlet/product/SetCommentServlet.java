package com.servlet.product;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Comment;
import com.entity.Orders;
import com.entity.User;
import com.service.CommentService;
import com.service.CommodityService;
import com.service.OrderService;
import com.util.tools.Utils;

/**
 * Servlet implementation class SetCommentServlet
 */
@WebServlet("/setCommentServlet")
public class SetCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public final static String USER_INFORMATION = "user_information";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SetCommentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String commodityId = request.getParameter("commodityId");
		User user = (User) request.getSession().getAttribute(USER_INFORMATION);

		String commentContent = request.getParameter("commentContent");
		String orderId = request.getParameter("orderId");
		// 当前商品评价
		double commentRate = Double.valueOf(request.getParameter("commentRate"));
		String commentDTime = Utils.getSystemDTime();
		OrderService orderService = new OrderService();
		CommentService commentService = new CommentService();
		CommodityService commodityService = new CommodityService();
		// 商品总评价
		double rate = 0;
		double rateAccount = 0;

		List<Orders> orders = new ArrayList<>();
		try {
			orders = orderService.getOrderByCommodityId(commodityId);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		for (Orders order : orders) {
			if (order.getOrderRate() != null) {
				rate = Double.valueOf(order.getOrderRate());
			}
			rateAccount += rate;
		}

		rate = (rateAccount + commentRate) / (orders.size() + 1);

		Comment comment = new Comment();
		comment.setCommodityId(Integer.valueOf(commodityId));
		comment.setCommentContent(commentContent);
		comment.setCommentDTime(commentDTime);
		comment.setUserID(user.getUserId());

		int commentResult = commentService.setComments(comment);
		int rateResult = commodityService.updateRate(String.valueOf(rate), commodityId);
		int orderRateResult = orderService.updateOrderRateByOrderId(orderId, String.valueOf(commentRate));

		int result = commentResult + rateResult + orderRateResult;

		if (result != 3) {
			request.setAttribute("warn", "评价失败");
		}
		request.getRequestDispatcher("getUserOrder").forward(request, response);
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
