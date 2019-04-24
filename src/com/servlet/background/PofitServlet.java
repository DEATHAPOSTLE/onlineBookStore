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
import com.uitl.dto.CommoditySalesDto;

/**
 * 
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
		List<CommoditySalesDto> bases = new ArrayList<CommoditySalesDto>();
		List<CommoditySalesDto> result = new ArrayList<CommoditySalesDto>();
		CommodityService commodityService = new CommodityService();
		try {
			bases = commodityService.selectCountOrdersByCommodityId();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for(CommoditySalesDto CommoditySalesDto : bases){
			CommoditySalesDto.setCommodityProfit((CommoditySalesDto.getCommodityPrice() - CommoditySalesDto.getCommodityInPrice()) * CommoditySalesDto.getSalesCount());
			result.add(CommoditySalesDto);
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
