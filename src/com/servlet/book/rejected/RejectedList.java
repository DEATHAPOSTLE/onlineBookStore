package com.servlet.book.rejected;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.CommodityBase;
import com.entity.Orders;
import com.entity.Rejected;
import com.entity.User;
import com.service.CommodityService;
import com.service.OrderService;
import com.service.RejectedService;
import com.service.UserService;
import com.uitl.dto.RejectedDto;

/**
 * Servlet implementation class Test
 */
@WebServlet("/rejectedList")
public class RejectedList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public final static String USER_INFORMATION = "user_information";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RejectedList() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String type = request.getParameter("type");
		User user = (User) request.getSession().getAttribute(USER_INFORMATION);
		if (!"3".equals(user.getUserType()))
			response.sendRedirect("/onlineBookStore/index");
		else {
			RejectedService rejectedService = new RejectedService();
			OrderService orderService = new OrderService();
			CommodityService commodityService = new CommodityService();
			UserService userService = new UserService();
			try {
				// 查看所有退货单
				if ("1".equals(type)) {

					List<Rejected> allList = rejectedService.getAllRejectedList();
					List<RejectedDto> dto = new ArrayList<RejectedDto>();

					for (Rejected rejected : allList) {
						Orders orders = orderService.getOrderById(rejected.getOrderId() + "");
						CommodityBase commodityBase = commodityService.getCommodityById(orders.getCommodityID() + "");
						User users = userService.getUserById(rejected.getUserId() + "");
						RejectedDto rejectedDto = new RejectedDto();
						rejectedDto.setCommodityName(commodityBase.getCommodityName());
						rejectedDto.setCommodityPicture(commodityBase.getCommodityPicture());
						rejectedDto.setCommodityPrice(commodityBase.getCommodityPrice());
						rejectedDto.setOrderDTime(orders.getOrderDTime());
						rejectedDto.setOrderPrice(orders.getOrderPrice());
						rejectedDto.setOrderStatus(orders.getOrderStatus());
						rejectedDto.setRejectedDTime(rejected.getRejectedDTime());
						rejectedDto.setRejectedStatus(rejected.getRejectedStatus());
						rejectedDto.setRejectedId(rejected.getRejectedId());
						rejectedDto.setUserAddr1(users.getUserAddr1());
						rejectedDto.setUserPhoneNumber(users.getUserPhoneNumber());
						rejectedDto.setUserType(users.getUserType());
						rejectedDto.setUserName(users.getUserName());

						System.out.println(rejectedDto.getCommodityName());
						System.out.println(rejectedDto.getRejectedStatus());
						System.err.println(rejectedDto.getOrderStatus());
						dto.add(rejectedDto);
					}

					request.setAttribute("dto", dto);
					request.getRequestDispatcher("/pages/manager/customerService.jsp").forward(request, response);

				} else {
					// 查看待审核的退货单
					List<Rejected> allList = rejectedService.getRejectedListByStatus("3");
					List<RejectedDto> dto = new ArrayList<RejectedDto>();
					for (Rejected rejected : allList) {
						Orders orders = orderService.getOrderById(rejected.getOrderId() + "");
						CommodityBase commodityBase = commodityService.getCommodityById(orders.getCommodityID() + "");
						User users = userService.getUserById(rejected.getUserId() + "");
						RejectedDto rejectedDto = new RejectedDto();
						rejectedDto.setCommodityName(commodityBase.getCommodityName());
						rejectedDto.setCommodityPicture(commodityBase.getCommodityPicture());
						rejectedDto.setCommodityPrice(commodityBase.getCommodityPrice());
						rejectedDto.setOrderDTime(orders.getOrderDTime());
						rejectedDto.setOrderPrice(orders.getOrderPrice());
						rejectedDto.setOrderStatus(orders.getOrderStatus());
						rejectedDto.setRejectedDTime(rejected.getRejectedDTime());
						rejectedDto.setRejectedStatus(rejected.getRejectedStatus());
						rejectedDto.setRejectedId(rejected.getRejectedId());
						rejectedDto.setUserAddr1(users.getUserAddr1());
						rejectedDto.setUserPhoneNumber(users.getUserPhoneNumber());
						rejectedDto.setUserType(users.getUserType());
						rejectedDto.setUserName(users.getUserName());

						dto.add(rejectedDto);
					}
					request.setAttribute("dto", dto);

					request.getRequestDispatcher("/pages/manager/customerService.jsp").forward(request, response);

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
