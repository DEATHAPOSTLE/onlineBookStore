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

import com.entity.CommodityBase;
import com.entity.ShoppingCart;
import com.entity.User;
import com.service.ShoppingCarService;
import com.uitl.dto.CommodityShoppingCartDto;

/**
 * Servlet implementation class Test
 */
@WebServlet("/shopingCar")
public class ShopingCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public final static String USER_INFORMATION = "user_information";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShopingCarServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute(USER_INFORMATION);
		ShoppingCarService shopCarService = new ShoppingCarService();
		if (user == null) {
			request.getRequestDispatcher("/pages/mall/login.jsp").forward(request, response);
		} else {
			try {
				List<CommodityShoppingCartDto> shopList = new ArrayList<CommodityShoppingCartDto>();
				List<ShoppingCart> shoppingCart = shopCarService.getShopByUser(user.getUserId() + "");
				if (shoppingCart == null) {
					System.out.println("未查询到结果");
					request.setAttribute("warn", "未查询到结果");
					request.getRequestDispatcher("/pages/mall/shopcar.jsp").forward(request, response);
				} else {
					for (ShoppingCart aCart : shoppingCart) {
						CommodityBase aBase = new CommodityBase();
						CommodityShoppingCartDto dto = new CommodityShoppingCartDto();
						aBase = shopCarService.getShopByShopCar(aCart.getCommodityId() + "");
						dto.setCommodityId(aBase.getCommodityId());
						dto.setCommodityIntroduce(aBase.getCommodityIntroduce());
						dto.setCommodityName(aBase.getCommodityName());
						dto.setCommodityNumber(aCart.getCommodityNumber());
						dto.setCommodityPicture(aBase.getCommodityPicture());
						dto.setCommodityPrice(aBase.getCommodityPrice());
						dto.setCommodityRate(aBase.getCommodityRate());
						dto.setCommoditySurplus(aBase.getCommoditySurplus());
						dto.setCommodityType(aBase.getCommodityType());
						dto.setRegisteredDTime(aCart.getRegisteredDTime());
						dto.setShoppingCartId(aCart.getShoppingCartId());
						dto.setUserId(user.getUserId() + "");
						System.out.println(dto.toString());
						shopList.add(dto);
					}
					for (CommodityShoppingCartDto dtos : shopList) {
						System.out.println(dtos.getCommodityName());
					}
					request.setAttribute("shopCart", shopList);
					request.getRequestDispatcher("/pages/mall/shopcar.jsp").forward(request, response);

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
