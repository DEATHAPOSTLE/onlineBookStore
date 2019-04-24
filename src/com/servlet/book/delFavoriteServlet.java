package com.servlet.book;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.User;
import com.service.CommodityService;

/**
 * 添加收藏夹
 */
@WebServlet("/delFavoriteServlet")
public class delFavoriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public final static String USER_INFORMATION = "user_information";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public delFavoriteServlet() {
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

		Integer commodityId = Integer.parseInt(request.getParameter("commodityId"));
		CommodityService commodityService = new CommodityService();

		if (user != null) {
			int result = commodityService.deleteFavorites(user.getUserId(), commodityId);
			if (result == 1) {
				request.setAttribute("favoriteMessage", "删除成功");
			} else {
				request.setAttribute("favoriteMessage", "删除失败");
			}
			request.getRequestDispatcher("/commodityDetail?shopId=" + commodityId).forward(request, response);

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
