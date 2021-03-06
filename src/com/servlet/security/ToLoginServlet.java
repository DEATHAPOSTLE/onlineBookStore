package com.servlet.security;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.User;
import com.service.UserService;

/**
 * Servlet implementation class Test
 */
@WebServlet("/toLogin")
public class ToLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public final static String USER_INFORMATION = "user_information";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ToLoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		UserService userService = new UserService();

		try {
			User user = userService.getUserByName(userName);
			if (user.getUserName() == null) {
				System.out.println("用户不存在");
				request.setAttribute("error", "用户不存在");
				request.getRequestDispatcher("pages/mall/login.jsp").forward(request, response);
				return;
			} else if (!password.equals(user.getUserPassword())) {
				System.out.println("密码错误");
				request.setAttribute("error", "密码错误");
				request.getRequestDispatcher("pages/mall/login.jsp").forward(request, response);
				return;
			} else {
				request.getSession().setAttribute(USER_INFORMATION, user);
				System.out.println("登陆成功");
				if ("3".equals(user.getUserType())) {
					System.out.println("管理员");
					response.sendRedirect("/onlineBookStore/bookAudit");
					return;
				} else if ("4".equals(user.getUserType())) {
					System.out.println("商家");
					response.sendRedirect("/onlineBookStore/commodityAdministration");
					return;
				} else {
					System.out.println("用户");
					response.sendRedirect("/onlineBookStore/index");
					return;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
