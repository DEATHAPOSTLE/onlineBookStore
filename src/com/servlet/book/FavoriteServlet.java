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
import com.entity.Favorites;
import com.entity.User;
import com.service.CommodityService;

/**
 * 收藏夹
 */
@WebServlet("/FavoriteServlet")
public class FavoriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static String USER_INFORMATION = "user_information";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FavoriteServlet() {
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
		if (!"4".equals(user.getUserType())) {
			request.getRequestDispatcher("/pages/mall/login.jsp").forward(request, response);
			return;
		} else {
			List<CommodityBase> commoditys = new ArrayList<CommodityBase>();
			List<Favorites> favorites = new ArrayList<Favorites>();
			List<String> commodityIds = new ArrayList<String>();

			CommodityService commodityService = new CommodityService();
			try {
				favorites = commodityService.getUserFavorites(user.getUserId());
			} catch (SQLException e) {
				e.printStackTrace();
			}

			for (Favorites favorite : favorites) {
				commodityIds.add(favorite.getCommodityId());
			}

			if (!commodityIds.isEmpty()) {
				try {
					commoditys = commodityService.getCommodityByIds(commodityIds);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			request.setAttribute("favorites", favorites);
			request.setAttribute("commoditys", commoditys);
			request.getRequestDispatcher("/pages/mall/favorite.jsp").forward(request, response);
		}
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
