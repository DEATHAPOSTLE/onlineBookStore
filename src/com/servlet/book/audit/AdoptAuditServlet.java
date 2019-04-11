package com.servlet.book.audit;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.CommodityBase;
import com.entity.CommodityBaseExamine;
import com.service.CommodityService;
import com.service.ExamineService;

/**
 * Servlet implementation class Test 通过审核
 */
@WebServlet("/adoptAudit")
public class AdoptAuditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdoptAuditServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bookId = request.getParameter("id");
		ExamineService examineService = new ExamineService();
		CommodityService commodityService = new CommodityService();
		try {
			CommodityBaseExamine commodityBaseExamine = examineService.getExamineCommodityById(bookId);
			CommodityBase commodityBase = new CommodityBase();
			commodityBase.setCommodityIntroduce(commodityBaseExamine.getCommodityIntroduce());
			commodityBase.setCommodityName(commodityBaseExamine.getCommodityName());
			commodityBase.setCommodityPicture(commodityBaseExamine.getCommodityPicture());
			commodityBase.setCommodityPrice(commodityBaseExamine.getCommodityPrice());
			commodityBase.setCommodityRate("");
			commodityBase.setCommodityShelves("1");
			commodityBase.setCommoditySurplus(1);
			commodityBase.setCommodityType(commodityBaseExamine.getCommodityType());
			commodityBase.setCommodityPress(commodityBaseExamine.getCommodityPress());
			commodityBase.setCommodityAuthor(commodityBaseExamine.getCommodityAuthor());
			commodityBaseExamine.setCommodityExamine(1);

			// 添加商品和修改审核内容
			examineService.updateExamine(commodityBaseExamine);
			commodityService.addCommodity(commodityBase);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.sendRedirect("/onlineBookStore/bookAudit");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
