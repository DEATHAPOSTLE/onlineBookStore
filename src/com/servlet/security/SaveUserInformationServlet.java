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
@WebServlet("/saveUserInformation")
public class SaveUserInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public final static String USER_INFORMATION = "user_information";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SaveUserInformationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)`
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = (User) request.getSession().getAttribute(USER_INFORMATION);
		String userAddr1 = new String(request.getParameter("userAddr1").getBytes("iso-8859-1"), "utf-8");
		String userAddr2 = new String(request.getParameter("userAddr2").getBytes("iso-8859-1"), "utf-8");
		String userAddr3 = new String(request.getParameter("userAddr3").getBytes("iso-8859-1"), "utf-8");
		String userAddr4 = new String(request.getParameter("userAddr4").getBytes("iso-8859-1"), "utf-8");
		String userAddr5 = new String(request.getParameter("userAddr5").getBytes("iso-8859-1"), "utf-8");

		String userPassword = request.getParameter("userPassword");
		String userPhoneNumber = request.getParameter("userPhoneNumber");

		user.setUserPassword(userPassword);
		user.setUserAddr1(userAddr1);
		user.setUserAddr2(userAddr2);
		user.setUserAddr3(userAddr3);
		user.setUserAddr4(userAddr4);
		user.setUserAddr5(userAddr5);
		user.setUserPhoneNumber(userPhoneNumber);
		UserService userService = new UserService();
		try {
			userService.updateUserById(user);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("/onlineBookStore/userInformation");

	}

}
