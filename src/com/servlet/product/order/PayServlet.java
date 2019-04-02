package com.servlet.product.order;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.CommodityBase;
import com.entity.Orders;
import com.entity.User;
import com.service.CommodityService;
import com.service.OrderService;
import com.service.ShoppingCarService;
import com.service.UserService;

/**
 * Servlet implementation class Test
 */
@WebServlet("/pay")
public class PayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public final static String USER_INFORMATION = "user_information";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PayServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	// 下单
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String[] shopIds = request.getParameterValues("shopId");
		String[] shopNumbers = request.getParameterValues("shopNumber");
		String[] shopCartIds = request.getParameterValues("shoppingCartIds");
		String userAddr = request.getParameter("userAddr");

		if (shopIds == null || shopNumbers == null) {
			shopIds = (String[]) request.getAttribute("shopId");
			shopNumbers = (String[]) request.getAttribute("shopNumber");
			shopCartIds = (String[]) request.getAttribute("shoppingCartIds");
		}

		OrderService orderService = new OrderService();
		CommodityService commodityService = new CommodityService();
		ShoppingCarService shoppingCarService = new ShoppingCarService();

		UserService userService = new UserService();
		User user = (User) request.getSession().getAttribute(USER_INFORMATION);
		if (user == null) {
			request.getRequestDispatcher("/pages/mall/login.jsp").forward(request, response);
		} else {
			try {
				List<CommodityBase> commodityBasess = commodityService.getCommodityByIds(shopIds);
				if (commodityBasess.size() == 0) {
					System.out.println("未查询到结果");
					request.setAttribute("warn", "未查询到结果");
					response.sendRedirect("/handicappedmall/index");
				} else {
					int i = 0;
					for (CommodityBase commodityBases : commodityBasess) {

						int shopNumberInt = Integer.parseInt(shopNumbers[i]);
						int shopCartIdInt = 0;
						if (shopCartIds != null) {
							shopCartIdInt = Integer.parseInt(shopCartIds[i]);
						}
						if (shopNumberInt <= commodityBases.getCommoditySurplus()) {
							Orders orders = new Orders();

							orders.setCommodityID(commodityBases.getCommodityId());
							orders.setDeliveryDTime("");
							orders.setOrderDTime(sdf.format(new Date()));
							double priceCount = commodityBases.getCommodityPrice() * shopNumberInt;
							orders.setOrderPrice(priceCount);
							orders.setOrderStatus("1");
							orders.setUserId(user.getUserId());
							orders.setReceiveDTime("");
							orders.setOrderRate("");
							orders.setOrderAddr(userAddr);
							orders.setPhoneNumber(user.getUserPhoneNumber());
							int result = orderService.setOrder(orders);
							if (shopCartIds != null) {
								shoppingCarService.delShopByShopCar(String.valueOf(shopCartIdInt));
							}
							if (result > 0) {
								commodityBases
										.setCommoditySurplus(commodityBases.getCommoditySurplus() - shopNumberInt);
								commodityService.updateCommodity(commodityBases);
							}
							System.out.println("下单成功");
							request.setAttribute("info", "下单成功");
							i++;
						} else {
							i++;
							System.out.println("数量不足");
							response.sendRedirect("/handicappedmall/commodityDetail?shopId="
									+ commodityBases.getCommodityId() + "&warn=lazyWeight");
							return;
						}
					}
					response.sendRedirect("/handicappedmall/getUserOrder");
					return;
				}

			} catch (SQLException e) {
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

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String shopId = request.getParameter("shopId");
		String shopNumber = request.getParameter("shopNumber");
		int shopNumberInt = Integer.parseInt(shopNumber);
		OrderService orderService = new OrderService();
		CommodityService shopService = new CommodityService();
		UserService userService = new UserService();
		User user = (User) request.getSession().getAttribute(USER_INFORMATION);
		if (user == null) {
			System.out.println("未登录");
			request.getRequestDispatcher("/pages/mall/login.jsp").forward(request, response);

		} else {
			try {
				CommodityBase commodityBase = shopService.getCommodityById(shopId);
				if (commodityBase.getCommodityId() == 0) {
					System.out.println("未查询到结果");
					request.setAttribute("warn", "未查询到结果");
					request.getRequestDispatcher("/pages/mall/login.jsp").forward(request, response);
				} else {
					if (shopNumberInt < commodityBase.getCommoditySurplus()) {
						Orders orders = new Orders();

						orders.setCommodityID(commodityBase.getCommodityId());
						orders.setDeliveryDTime("");
						orders.setOrderDTime(sdf.format(new Date()));
						double priceCount = commodityBase.getCommodityPrice() * shopNumberInt;
						orders.setOrderPrice(priceCount);
						orders.setOrderStatus("1");
						orders.setUserId(user.getUserId());
						orders.setReceiveDTime("");
						int result = orderService.setOrder(orders);
						if (result > 0) {
							commodityBase.setCommoditySurplus(commodityBase.getCommoditySurplus() - shopNumberInt);
							shopService.updateCommodity(commodityBase);
						}
						System.out.println("下单成功");
						request.setAttribute("info", "下单成功");
						request.getRequestDispatcher("/pages/mall/login.jsp").forward(request, response);
					} else {
						System.out.println("数量不足");
						request.setAttribute("warn", "数量不足");
						request.getRequestDispatcher("/pages/mall/login.jsp").forward(request, response);

					}
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
