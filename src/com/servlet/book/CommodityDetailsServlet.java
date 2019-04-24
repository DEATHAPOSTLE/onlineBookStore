package com.servlet.book;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Comment;
import com.entity.CommodityBase;
import com.entity.Favorites;
import com.entity.User;
import com.service.CommentService;
import com.service.CommodityService;

/**
 * Servlet implementation class Test
 */
@WebServlet("/commodityDetail")
public class CommodityDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public final static String USER_INFORMATION = "user_information";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CommodityDetailsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("shopId");
		CommodityService shopService = new CommodityService();
		int commodityId = Integer.valueOf(id);
		User user = (User) request.getSession().getAttribute(USER_INFORMATION);

		try {
			Favorites favorites;
			String haveFavorites = null;
			CommodityBase commodityBase = shopService.getCommodityById(id);
			CommentService commentService = new CommentService();
			List<Comment> comments = commentService.getComments(commodityId);
			if (user != null) {
				favorites = shopService.getUserOneFavorites(user.getUserId(), commodityId);
				if (favorites.getCommodityId() != null) {
					haveFavorites = "1";
				} else {
					haveFavorites = "2";
				}
			}

			if (commodityBase == null) {
				System.out.println("未查询到结果");
				request.setAttribute("warn", "未查询到结果");
				request.getRequestDispatcher("/pages/mall/detail.jsp").forward(request, response);
			} else {
				System.out.println(commodityBase.toString());
				request.setAttribute("commodityBase", commodityBase);
				request.setAttribute("comments", comments);
				request.setAttribute("haveFavorites", haveFavorites);
				request.getRequestDispatcher("/pages/mall/detail.jsp").forward(request, response);
			}

		} catch (SQLException e) {
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
