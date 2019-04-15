package com.servlet.background;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.User;
import com.service.OrderService;
import com.service.UserService;
import com.uitl.content.Const;
import com.uitl.dto.OrdersDto;

@WebServlet("/GetAllOrdersServlet")
public class GetAllOrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public final static String USER_INFORMATION = "user_information";

	public GetAllOrdersServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		OrderService orderService = new OrderService();
		UserService userService = new UserService();
		List<OrdersDto> orders = new ArrayList<OrdersDto>();
		User user = (User) request.getSession().getAttribute(USER_INFORMATION);
		if (!"3".equals(user.getUserType()))
			response.sendRedirect("/onlineBookStore/index");
		else {
			// 查看所有订单
			ResultSet resultSet = orderService.getAllOrders();
			try {
				while (resultSet.next()) {
					OrdersDto order = new OrdersDto();

					order.setCommodityID(resultSet.getInt(Const.COLUNM_COMMODITY_ID));
					order.setDeliveryDTime(resultSet.getString(Const.COLUNM_DELIVERY_DTIME));
					order.setOrderDTime(resultSet.getString(Const.COLUNM_ORDER_DTIME));
					order.setOrderId(resultSet.getInt(Const.COLUNM_ORDER_ID));
					order.setOrderPrice(resultSet.getDouble(Const.COLUNM_ORDER_PRICE));
					order.setOrderStatus(resultSet.getString(Const.COLUNM_ORDER_STATUS));
					order.setReceiveDTime(resultSet.getString(Const.COLUNM_RECEIVE_DTIME));
					order.setOrderAddr(resultSet.getString(Const.COLUNM_ORDER_ADDR));
					order.setPhoneNumber(resultSet.getString(Const.COLUNM_PHONENUMBER));
					order.setUserName(userService.getUserById(resultSet.getString(Const.COLUNM_USER_ID)).getUserName());
					orders.add(order);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			request.setAttribute("orders", orders);
			request.getRequestDispatcher("/pages/manager/orderManagement.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
