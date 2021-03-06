package com.controller.task;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.bean.TaskBean;
import com.model.dao.TaskDao;

/**
 * Servlet implementation class UpdateTaskServlet
 */
@WebServlet("/updatetask")
public class UpdateTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateTaskServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String status = request.getParameter("status");
//		String pro_type = request.getParameter("pro_type");
		String createdBy = request.getParameter("createdBy");
		String endDate = request.getParameter("endDate");
		String explain = request.getParameter("explain");
		String confirmedBy = request.getParameter("confirmedBy");
		String chargeBy = request.getParameter("chargeBy");
		String demand_id=request.getParameter("demand_id");
		if (id == null || name == null || status == null || createdBy == null
				|| endDate == null || explain == null || confirmedBy == null || chargeBy == null) {
			System.out.println("错误");
		}
		TaskBean task =new TaskBean();
		task.setId(id);
		task.setName(name);
		task.setStatus(status);
//		task.setPro_type(pro_type);
		task.setCreatedBy(createdBy);
		task.setEndDate(endDate);
		task.setExplain(explain);
		task.setConfirmedBy(confirmedBy);
		task.setChargeBy(chargeBy);
		task.setDemand_id(demand_id);
		TaskDao dao=new TaskDao();
		if(dao.updateTask(task)){
			System.out.println("修改成功");
			response.sendRedirect("task");
		}else{
			System.out.println("修改失败");
			response.sendRedirect("task");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
