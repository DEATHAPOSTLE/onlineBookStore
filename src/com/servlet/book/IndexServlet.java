package com.servlet.book;

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
import com.entity.User;
import com.service.CommodityService;

/**
 * Servlet implementation class Test
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public final static String USER_INFORMATION = "user_information";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IndexServlet() {
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
		// 推荐商品
		CommodityService CommodityService = new CommodityService();
		User user = (User) request.getSession().getAttribute(USER_INFORMATION);
		String recommendType = request.getParameter("recommendType");

		// 获取所有的商品，显示。
		try {
			// 所有商品列表
			List<CommodityBase> allCommoditylist = CommodityService.getCommodityWithOutUnShelves();
			// 推荐商品列表
			List<CommodityBase> recommendCommoditylist = new ArrayList<CommodityBase>();
			if (allCommoditylist.size() == 0) {
				System.out.println("未查询到商品结果");
				request.setAttribute("warn", "未查询到商品");
				request.getRequestDispatcher("/pages/index.jsp").forward(request, response);
			} else {
				if (user == null) {
					// 按销量检索
					if ("salesVolume".equals(recommendType)) {
						recommendCommoditylist = CommodityService.getShopBySalesCount();
						for (CommodityBase commodityBase : recommendCommoditylist) {
							System.out.println("商品名：" + commodityBase.getCommodityName());
						}
						// 按评价检索
					} else if ("evaluate".equals(recommendType)) {
						recommendCommoditylist = CommodityService.getCommodityByEvaluate();
					} else {
						recommendCommoditylist = CommodityService.getAllCommodity();

					}
				} else {
					if ("salesVolume".equals(recommendType)) {
						recommendCommoditylist = CommodityService.getShopBySalesCount();
						for (CommodityBase commodityBase : recommendCommoditylist) {
							System.out.println("商品名：" + commodityBase.getCommodityName());
						}
					} else if ("evaluate".equals(recommendType)) {
						recommendCommoditylist = CommodityService.getCommodityByEvaluate();
					} else {
						recommendCommoditylist = CommodityService.getCommodityByType(user);
						if (recommendCommoditylist.size() == 0) {
							request.setAttribute("warn", "登录后可按需求推荐");
						}
					}
				}
				System.out.println("执行!!!!!");
				for (CommodityBase bBase : recommendCommoditylist) {
					System.out.println(bBase.toString());
				}
				request.setAttribute("recommendShoplist", recommendCommoditylist);

				request.getRequestDispatcher("/pages/index.jsp").forward(request, response);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
