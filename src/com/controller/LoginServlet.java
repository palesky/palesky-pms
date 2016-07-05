package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.bean.user.UserBean;
import com.model.dao.UserDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");

		String account = request.getParameter("username");
		String password = request.getParameter("password");

		UserDao d = new UserDao();
		UserBean user = d.getUser(account);
		System.out.println(user.toString());
		if (user == null||user.getPassword()==null) {
			System.out.println("不存在该用户");
			response.sendRedirect("login.html");
			return;
		}
		if (user.getPassword().equals(password)) {
			// 密码正确
			System.out.println("密码正确");
			HttpSession session = request.getSession(true);
			session.setAttribute("user", user);
			response.sendRedirect("index.jsp");
			return;
		} else {
			System.out.println("密码错误");
			response.sendRedirect("login.html");
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
