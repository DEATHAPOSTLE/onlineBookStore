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
@WebServlet("/addFavoriteServlet")
public class addFavoriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public final static String USER_INFORMATION = "user_information";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public addFavoriteServlet() {
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
		int result = commodityService.insertFavorites(user.getUserId(), commodityId);
		request.setAttribute("commodityId", commodityId);
		if (result == 1) {
			request.setAttribute("favoriteMessage", "添加成功");
		} else {
			request.setAttribute("favoriteMessage", "添加失败");
		}
		request.getRequestDispatcher("/commodityDetail?shopId=" + commodityId).forward(request, response);
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
