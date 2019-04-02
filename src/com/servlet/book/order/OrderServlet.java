package com.servlet.book.order;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Orders;
import com.entity.User;
import com.service.OrderService;
import com.uitl.dto.OrdersDto;

/**
 * Servlet implementation class Test
 */
@WebServlet("/getUserOrder")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public final static String USER_INFORMATION = "user_information";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	// 用户查看自己的订单
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		OrderService payShopService = new OrderService();
		User user = (User) request.getSession().getAttribute(USER_INFORMATION);
		List<Orders> ordersList = new ArrayList<Orders>();
		List<OrdersDto> OrdersDtoList = new ArrayList<OrdersDto>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (user == null) {
			response.sendRedirect("/handicappedmall/index");
		} else {

			try {
				ordersList = payShopService.getOrderByUserId(user);
				Date nowDate = new Date();
				for (Orders orderss : ordersList) {
					OrdersDto ordersDto = new OrdersDto();

					ordersDto.setCommodityID(orderss.getCommodityID());
					ordersDto.setDeliveryDTime(orderss.getDeliveryDTime());
					ordersDto.setOrderDTime(orderss.getOrderDTime());
					ordersDto.setOrderId(orderss.getOrderId());
					ordersDto.setOrderPrice(orderss.getOrderPrice());
					ordersDto.setOrderStatus(orderss.getOrderStatus());
					ordersDto.setReceiveDTime(orderss.getReceiveDTime());
					ordersDto.setUserId(orderss.getUserId());
					ordersDto.setOrderAddr(orderss.getOrderAddr());
					ordersDto.setPhoneNumber(orderss.getPhoneNumber());

					if ("".equals(orderss.getOrderRate()) || orderss.getOrderRate() == null) {
						if ("3".equals(orderss.getOrderStatus())) {
							ordersDto.setRateStatus("1");
						}
					} else {
						ordersDto.setRateStatus("0");
					}

					Date orderDate = sdf.parse(orderss.getOrderDTime());
					long time = 1000 * 60 * 60 * 24;
					long day = (nowDate.getTime() - orderDate.getTime()) / time;
					if (day > 7) {
						// 大于七天，不允许退货
						ordersDto.setRejectedStatus("2");
						if ("4".equals(ordersDto.getOrderStatus())) {
							// 退货审核中
							ordersDto.setRejectedStatus("3");

						} else if ("5".equals(ordersDto.getOrderStatus())) {
							// 供货商同意退货
							ordersDto.setRejectedStatus("4");

						} else if ("7".equals(ordersDto.getOrderStatus())) {
							// 供货商拒绝退货
							ordersDto.setRejectedStatus("5");

						} else if ("8".equals(ordersDto.getOrderStatus())) {
							// 满足退货要求，退货成功
							ordersDto.setRejectedStatus("7");

						} else if ("9".equals(ordersDto.getOrderStatus())) {
							// 不满足退货要求，被店家寄回。
							ordersDto.setRejectedStatus("8");
						} else if ("10".equals(ordersDto.getOrderStatus())) {
							// 不满足退货要求，被店家寄回。
							ordersDto.setRejectedStatus("6");
						}

					} else if (day <= 7) {
						// 小于七天，可以退货
						ordersDto.setRejectedStatus("1");
						if ("4".equals(ordersDto.getOrderStatus())) {
							// 退货审核中
							ordersDto.setRejectedStatus("3");

						} else if ("5".equals(ordersDto.getOrderStatus())) {
							// 供货商同意退货
							ordersDto.setRejectedStatus("4");

						} else if ("7".equals(ordersDto.getOrderStatus())) {
							// 供货商拒绝退货
							ordersDto.setRejectedStatus("5");

						} else if ("8".equals(ordersDto.getOrderStatus())) {
							// 满足退货要求，退货成功
							ordersDto.setRejectedStatus("7");

						} else if ("9".equals(ordersDto.getOrderStatus())) {
							// 不满足退货要求，被店家寄回。
							ordersDto.setRejectedStatus("8");

						} else if ("10".equals(ordersDto.getOrderStatus())) {
							// 不满足退货要求，被店家寄回。
							ordersDto.setRejectedStatus("6");

						}

					}

					OrdersDtoList.add(ordersDto);

				}
				if (ordersList.size() == 0) {
					System.out.println("未查询到结果");
					request.setAttribute("warn", "未查询到结果");
					request.getRequestDispatcher("/pages/manager/user-order.jsp").forward(request, response);
				} else {
					request.setAttribute("ordersList", OrdersDtoList);
					request.getRequestDispatcher("/pages/manager/user-order.jsp").forward(request, response);

				}

			} catch (SQLException | ParseException e) {
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
