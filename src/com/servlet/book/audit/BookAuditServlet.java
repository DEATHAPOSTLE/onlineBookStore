package com.servlet.book.audit;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.CommodityBaseExamine;
import com.entity.User;
import com.service.ExamineService;

/**
 * Servlet implementation class Test 书本审核
 */
@WebServlet("/bookAudit")
public class BookAuditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public final static String USER_INFORMATION = "user_information";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookAuditServlet() {
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

		if (!"3".equals(user.getUserType()))
			response.sendRedirect("/onlineBookStore/index");
		else {
			ExamineService examineService = new ExamineService();
			try {
				if ("1".equals(request.getParameter("type"))) {
					// 查询待审核、
					List<CommodityBaseExamine> list = examineService.getNoExamineCommodity("3");
					request.setAttribute("list", list);
					request.getRequestDispatcher("/pages/manager/safetyAudit.jsp").forward(request, response);

				} else {
					List<CommodityBaseExamine> list = examineService.getAllExamineCommodity();
					request.setAttribute("list", list);
					request.getRequestDispatcher("/pages/manager/safetyAudit.jsp").forward(request, response);
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
