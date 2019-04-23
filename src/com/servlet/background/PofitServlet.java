package com.servlet.background;

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

/**
 * Servlet implementation class PofitServlet
 */
@WebServlet("/PofitServlet")
public class PofitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     */
    public PofitServlet() {
        super();
    }

	/**
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<CommodityBase> bases = new ArrayList<CommodityBase>();
		List<CommodityBase> result = new ArrayList<CommodityBase>();
		CommodityService commodityService = new CommodityService();
		try {
			bases = commodityService.getAllCommodity();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for(CommodityBase commodityBase : bases){
			commodityBase.setCommodityProfit(commodityBase.getCommodityPrice() - commodityBase.getCommodityInPrice());
			result.add(commodityBase);
		}
		request.setAttribute("commoditys", result);
		request.getRequestDispatcher("pages/manager/profit.jsp").forward(request, response);
	}

	/**
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
