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
@WebServlet("/toRegister")
public class ToRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ToRegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String tel = request.getParameter("tel");

		UserService userService = new UserService();
		try {
			User users = userService.getUserByName(userName);

			if (users.getUserName() != null) {
				System.out.println("用户已经被注册");
				request.setAttribute("error", "用户已经被注册");
				request.getRequestDispatcher("/pages/mall/register.jsp").forward(request, response);
				return;
			} else {
				userService.setUser(password, userName, tel);
				System.out.println("注册成功");
				request.getRequestDispatcher("/pages/mall/login.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
