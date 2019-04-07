package com.servlet.book;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.entity.CommodityBaseExamine;
import com.service.CommodityService;
import com.service.ExamineService;

/**
 * Servlet implementation class Test 通过审核
 */
@WebServlet("/saveCommodity")
public class SaveCommodityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//储存地址
	public final static String SAVEPATH = "G:\\git项目\\handicappedmall\\WebContent\\pages\\img";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SaveCommodityServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
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

		// 商品名称
		String commodityName = request.getParameter("commodityName");
		// 商品图片
		String commodityPicture ="";
		// 商品类型
		String commodityType = request.getParameter("commodityType");
		// 商品价格
		double commodityPrice = (double) request.getAttribute("commodityPrice");
		// 商品介绍
		String commodityIntroduce = request.getParameter("commodityIntroduce");

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 存储路径
		String savePath = SAVEPATH;
		// 获取上传的文件集合
		System.out.println(savePath);
		Collection<Part> parts = request.getParts();
		// 上传单个文件
		if (parts.size() != 0) {
			// Servlet3.0将multipart/form-data的POST请求封装成Part，通过Part对上传的文件进行操作。
			// Part part = parts[0];//从上传的文件集合中获取Part对象
			Part part = request.getPart("file");// 通过表单file控件(<input type="file" name="file">)的名字直接获取Part对象
			// Servlet3没有提供直接获取文件名的方法,需要从请求头中解析出来
			// 获取请求头，请求头的格式：form-data; name="file"; filename="snmp4j--api.zip"
			String header = part.getHeader("content-disposition");
			// 获取文件名
			String fileName = getFileName(header);
			// 把文件写到指定路径
			part.write(savePath + File.separator + fileName);
			commodityPicture=fileName;
		} else {
			System.out.println("请上传图片");
		}
		PrintWriter out = response.getWriter();
		out.println("上传成功");
		out.flush();
		out.close();

		ExamineService examineService = new ExamineService();
		CommodityBaseExamine commodityBaseExamine = new CommodityBaseExamine();
		commodityBaseExamine.setCommodityExamine(1);
		commodityBaseExamine.setCommodityIntroduce(commodityIntroduce);
		commodityBaseExamine.setCommodityName(commodityName);
		commodityBaseExamine.setCommodityPicture(commodityPicture);
		commodityBaseExamine.setCommodityPrice(commodityPrice);
		commodityBaseExamine.setCommodityType(commodityType);
		

		try {
			examineService.updateExamine(commodityBaseExamine);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.getRequestDispatcher("/pages/mall/login.jsp").forward(request, response);

	}

	/**
	 * 根据请求头解析出文件名 请求头的格式：火狐和google浏览器下：form-data; name="file";
	 * filename="snmp4j--api.zip" IE浏览器下：form-data; name="file";
	 * filename="E:\snmp4j--api.zip"
	 * 
	 * @param header 请求头
	 * @return 文件名
	 */
	public String getFileName(String header) {
		/**
		 * String[] tempArr1 = header.split(";");代码执行完之后，在不同的浏览器下，tempArr1数组里面的内容稍有区别
		 * 火狐或者google浏览器下：tempArr1={form-data,name="file",filename="snmp4j--api.zip"}
		 * IE浏览器下：tempArr1={form-data,name="file",filename="E:\snmp4j--api.zip"}
		 */
		String[] tempArr1 = header.split(";");
		/**
		 * 火狐或者google浏览器下：tempArr2={filename,"snmp4j--api.zip"}
		 * IE浏览器下：tempArr2={filename,"E:\snmp4j--api.zip"}
		 */
		String[] tempArr2 = tempArr1[2].split("=");
		// 获取文件名，兼容各种浏览器的写法
		String fileName = tempArr2[1].substring(tempArr2[1].lastIndexOf("\\") + 1).replaceAll("\"", "");
		return fileName;
	}

}
