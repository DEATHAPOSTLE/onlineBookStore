package com.servlet.book.order;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
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
				List<CommodityBase> commodityBasess = commodityService.getCommodityByIds(Arrays.asList(shopIds));
				if (commodityBasess.size() == 0) {
					System.out.println("未查询到结果");
					request.setAttribute("warn", "未查询到结果");
					response.sendRedirect("/onlineBookStore/index");
				} else {
					int i = 0;
					for (CommodityBase commodityBases : commodityBasess) {

						int shopNumberInt = Integer.parseInt(shopNumbers[i]);
						int shopCartIdInt = 0;
						if (shopCartIds != null) {
							shopCartIdInt = Integer.parseInt(shopCartIds[i]);
						}

						double price = shopNumberInt * commodityBases.getCommodityPrice();
						if ("2".equals(user.getUserType())) {
							price = price * 0.8;
						}

						if (shopNumberInt <= commodityBases.getCommoditySurplus()) {
							if (user.getMoney() >= price) {
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

									user.setMoney(user.getMoney() - price);
									userService.updateUserById(user);
									commodityBases
											.setCommoditySurplus(commodityBases.getCommoditySurplus() - shopNumberInt);
									commodityService.updateCommodity(commodityBases);
								}
								System.out.println("下单成功");
								request.setAttribute("info", "下单成功");
								i++;
							} else {
								i++;
								System.out.println("余额不足");
								response.sendRedirect("/onlineBookStore/moneyInsufficient");
								return;
							}
						} else {
							i++;
							System.out.println("数量不足");
							response.sendRedirect("/onlineBookStore/commodityDetail?shopId="
									+ commodityBases.getCommodityId() + "&warn=lazyWeight");
							return;
						}
					}
					response.sendRedirect("/onlineBookStore/getUserOrder");
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
		String[] shopIds = request.getParameterValues("shopId");
		String[] shopNumbers = request.getParameterValues("shopNumber");
		String[] shopCartIds = request.getParameterValues("shoppingCartIds");
		String userAddr = new String(request.getParameter("userAddr").getBytes("iso-8859-1"), "utf-8");

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
				List<CommodityBase> commodityBasess = commodityService.getCommodityByIds(Arrays.asList(shopIds));
				if (commodityBasess.size() == 0) {
					System.out.println("未查询到结果");
					request.setAttribute("warn", "未查询到结果");
					response.sendRedirect("/onlineBookStore/index");
				} else {
					int i = 0;
					for (CommodityBase commodityBases : commodityBasess) {

						int shopNumberInt = Integer.parseInt(shopNumbers[i]);
						int shopCartIdInt = 0;
						if (shopCartIds != null) {
							shopCartIdInt = Integer.parseInt(shopCartIds[i]);
						}

						double price = shopNumberInt * commodityBases.getCommodityPrice();
						if ("2".equals(user.getUserType())) {
							price = price * 0.8;
						}

						if (shopNumberInt <= commodityBases.getCommoditySurplus()) {
							if (user.getMoney() >= price) {
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

									user.setMoney(user.getMoney() - price);
									userService.updateUserById(user);
									commodityBases
											.setCommoditySurplus(commodityBases.getCommoditySurplus() - shopNumberInt);
									commodityService.updateCommodity(commodityBases);
								}
								System.out.println("下单成功");
								request.setAttribute("info", "下单成功");
								i++;
							} else {
								i++;
								System.out.println("余额不足");
								response.sendRedirect("/onlineBookStore/moneyInsufficient");
								return;
							}
						} else {
							i++;
							System.out.println("数量不足");
							response.sendRedirect("/onlineBookStore/commodityDetail?shopId="
									+ commodityBases.getCommodityId() + "&warn=lazyWeight");
							return;
						}
					}
					response.sendRedirect("/onlineBookStore/getUserOrder");
					return;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
