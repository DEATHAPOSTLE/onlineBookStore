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
import com.service.CommodityService;
import com.uitl.content.Const;

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

		// 获取所有的商品，显示。
		try {
			// 所有商品列表
			List<CommodityBase> allCommoditylist = CommodityService.getCommodityWithOutUnShelves();
			// 按类别
			List<CommodityBase> recommendCommoditylist = new ArrayList<CommodityBase>();
			if (allCommoditylist.size() == 0) {
				System.out.println("未查询到商品结果");
				request.setAttribute("warn", "未查询到商品");
				request.getRequestDispatcher("/pages/mall/index.jsp").forward(request, response);
			} else {
				recommendCommoditylist = CommodityService.getCommodityByEvaluate();

				List<CommodityBase> listMilitary = CommodityService.getCommodityByType("军事",
						Const.COLUNM_COMMODITY_TYPE);
				List<CommodityBase> listEntertainment = CommodityService.getCommodityByType("娱乐",
						Const.COLUNM_COMMODITY_TYPE);
				List<CommodityBase> listScience = CommodityService.getCommodityByType("科技",
						Const.COLUNM_COMMODITY_TYPE);
				List<CommodityBase> listLife = CommodityService.getCommodityByType("生活", Const.COLUNM_COMMODITY_TYPE);
				List<CommodityBase> listLiterature = CommodityService.getCommodityByType("文学",
						Const.COLUNM_COMMODITY_TYPE);
				System.out.println("执行!!!!!");
				for (CommodityBase bBase : recommendCommoditylist) {
					System.out.println(bBase.toString());
				}

				request.setAttribute("recommendShoplist", recommendCommoditylist);
				request.setAttribute("allCommoditylist", allCommoditylist);
				request.setAttribute("listMilitary", listMilitary);
				request.setAttribute("listEntertainment", listEntertainment);
				request.setAttribute("listScience", listScience);
				request.setAttribute("listLife", listLife);
				request.setAttribute("listLiterature", listLiterature);

				request.getRequestDispatcher("/pages/mall/index.jsp").forward(request, response);
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
