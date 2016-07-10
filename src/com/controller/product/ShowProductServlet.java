package com.controller.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.dao.ProductDao;

/**
 * Servlet implementation class ShowProductServlet
 */
@WebServlet("/product")
public class ShowProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProductDao dao=new ProductDao();
		//命名为itemList的原因是因为要实现 ./WEB-INF/part/list-group 的复用，所以所有数据传过去，最好都命名为itemList  --xjy
		//需要先移除可能存在的值
		request.removeAttribute("itemList");
		request.removeAttribute("list_group_title");
		
		request.setAttribute("list_group_title", "产品列表");
//		request.setAttribute("itemList",dao.findAllProduct());
		request.setAttribute("itemType", "产品");
		request.setAttribute("url", "product");
		request.getRequestDispatcher("product.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
