package com.controller.bug;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.bean.TmpBean;
import com.model.bean.UserBean;
import com.model.dao.BugDao;
import com.model.dao.DemandDao;
import com.model.dao.ProductDao;
import com.model.dao.ProjectDao;
import com.model.dao.TaskDao;
import com.model.dao.TmpDao;

/**
 * Servlet implementation class ShowBugServlet
 */
@WebServlet("/bug")
public class ShowBugServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowBugServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.removeAttribute("itemList");
		request.removeAttribute("list_group_title");
		UserBean user = (UserBean) request.getSession().getAttribute("user");
		
		BugDao bugDao=new BugDao();
		

		// 读取记录用户选择的项目
		TmpDao tmpDao = new TmpDao();
		TmpBean tmp = tmpDao.getTmp(user.getId());
		String saveid = tmp.getBug_id();
		if (saveid == null) {
			saveid = "all";
			tmpDao.setBug(user.getId(), saveid);
		}

//		// 用于关联项目与产品，所以给出项目列表，会在新建或更新时用到
//		ProjectDao projectDao = new ProjectDao();
//		request.setAttribute("projectList", projectDao.findAllProject());

		String q = "";
		if (request.getParameter("q") == null)
			q = "";
		else
			q = request.getParameter("q");

		//找到特定的bug
		if (q.equals("") && !saveid.equals("all") && !saveid.equals("me")) {
			q = tmp.getBug_id();
			request.setAttribute("item", bugDao.getBug(q));
			request.getRequestDispatcher("bugInfo.jsp").forward(request, response);
		} else
		if (q.equals("all") || q.equals("")) {//所有
			if (!saveid.equals("all"))
				tmpDao.setBug(user.getId(), "all");
			request.setAttribute("itemList", bugDao.findAllBug());
			request.setAttribute("itemList2", bugDao.searchMyChargeBug(user.getId()));
			request.getRequestDispatcher("bug.jsp").forward(request, response);
		} else if (q.equals("me")) {
			request.setAttribute("itemList", bugDao.findAllBug());
			request.setAttribute("itemList2", bugDao.searchMyChargeBug(user.getId()));
			request.getRequestDispatcher("bug.jsp").forward(request, response);
		} else {// 找到特定的bug
			tmpDao.setBug(user.getId(), q);
			request.setAttribute("list_group_title3", "任务列表");
			request.setAttribute("item", bugDao.getBug(q));
			request.setAttribute("itemType", "需求");
			request.getRequestDispatcher("bugInfo.jsp").forward(request, response);
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
