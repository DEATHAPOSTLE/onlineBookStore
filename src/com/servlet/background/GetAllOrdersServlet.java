package com.servlet.background;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Orders;
import com.entity.User;
import com.service.OrderService;
import com.service.UserService;
import com.uitl.content.Const;

@WebServlet("/GetAllOrdersServlet")
public class GetAllOrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public final static String USER_INFORMATION = "user_information";

	public GetAllOrdersServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Integer> userIds = new ArrayList<Integer>();
		request.setCharacterEncoding("UTF-8");
		OrderService orderService = new OrderService();
		UserService userService = new UserService();
		List<Orders> orders = new ArrayList<Orders>();
		List<User> users = new ArrayList<User>();
		User user = (User) request.getSession().getAttribute(USER_INFORMATION);
		if (!"2".equals(user.getUserType()))
			response.sendRedirect("/handicappedmall/index");
		else {
			// 查看所有订单
			ResultSet resultSet = orderService.getAllOrders();
			try {
				while (resultSet.next()) {
					int userId = resultSet.getInt(Const.COLUNM_USER_ID);
					Orders order = new Orders();
					order.setCommodityID(resultSet.getInt(Const.COLUNM_COMMODITY_ID));
					order.setDeliveryDTime(resultSet.getString(Const.COLUNM_DELIVERY_DTIME));
					order.setOrderDTime(resultSet.getString(Const.COLUNM_ORDER_DTIME));
					order.setOrderId(resultSet.getInt(Const.COLUNM_ORDER_ID));
					order.setOrderPrice(resultSet.getDouble(Const.COLUNM_ORDER_PRICE));
					order.setOrderStatus(resultSet.getString(Const.COLUNM_ORDER_STATUS));
					order.setReceiveDTime(resultSet.getString(Const.COLUNM_RECEIVE_DTIME));
					order.setOrderAddr(resultSet.getString(Const.COLUNM_ORDER_ADDR));
					order.setPhoneNumber(resultSet.getString(Const.COLUNM_PHONENUMBER));
					order.setUserId(userId);
					userIds.add(userId);
					orders.add(order);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				users = userService.getUserByIds(userIds);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			request.setAttribute("orders", orders);
			request.setAttribute("users", users);
			request.getRequestDispatcher("pages/manager/orderManagement.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
