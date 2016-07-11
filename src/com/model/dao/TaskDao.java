package com.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.Date;
import java.text.SimpleDateFormat;

import com.model.bean.ProductBean;
import com.model.bean.TaskBean;

/**
 * 未测试
 * @author xj
 * task 中共有13项数据
 * 其中  创建者 创建时间 所属产品编号 不能改 -lk
 */
public class TaskDao extends BaseDao{
	
	public ArrayList<TaskBean> findAllTask() {
		
		ArrayList<TaskBean> list = new ArrayList<TaskBean>();
		String sql = "SELECT * FROM task ";
		try (Connection conn = dataSource.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			ResultSet rst = pstmt.executeQuery();
			while (rst.next()) {
				TaskBean task = new TaskBean();
				task.setId(rst.getString("id"));
				task.setName(rst.getString("name"));
				task.setStatus(rst.getString("status"));
				task.setCreatedBy(rst.getString("createdBy"));
				task.setEndDate(rst.getString("endDate"));
				task.setExplain(rst.getString("explain"));
				task.setLastEditedBy(rst.getString("lastEditedBy"));
				task.setLastEditedDate(rst.getString("lastEditedDate"));
				task.setConfirmedBy(rst.getString("confirmedBy"));
				task.setDemand_id(rst.getString("demand_id"));
				task.setChargeBy(rst.getString("chargeBy"));
				task.setBugNum(rst.getInt("bugNum"));
				list.add(task);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//----------------------------------------------------------------
	//获取任务信息
	public TaskBean getTask(String id){
		String sql = "SELECT * FROM task where id=?";
		try (Connection conn = dataSource.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, id);
			ResultSet rst = pstmt.executeQuery();
			TaskBean task = new TaskBean();
			while (rst.next()) {
				task.setId(rst.getString("id"));
				task.setName(rst.getString("name"));
				task.setStatus(rst.getString("status"));
				task.setCreatedBy(rst.getString("createdBy"));
				task.setEndDate(rst.getString("endDate"));
				task.setExplain(rst.getString("explain"));
				task.setLastEditedBy(rst.getString("lastEditedBy"));
				task.setLastEditedDate(rst.getString("lastEditedDate"));
				task.setConfirmedBy(rst.getString("confirmedBy"));
				task.setDemand_id(rst.getString("demand_id"));
				task.setChargeBy(rst.getString("chargeBy"));
				task.setBugNum(rst.getInt("bugNum"));
			}
			return task;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("return null");
			return null;
		}
	}
	
	//-------------------------------------------------------------------------------------
	//增加 任务
	public boolean addTask(TaskBean task) {
		Date d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
		String dateNowStr =sdf.format(d);
		String sql = "INSERT INTO task(id,name,status,createdBy,createdDate,endDate,explain,lastEditedBy,lastEditedDate,confirmedBy,demand_id,chargeBy,bugNum)VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		try (Connection conn = dataSource.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, task.getId());
			pstmt.setString(2, task.getName());
			pstmt.setString(3, task.getStatus());
			pstmt.setString(4, task.getCreatedBy());
			pstmt.setString(5, dateNowStr);
			pstmt.setString(6, task.getEndDate());
			pstmt.setString(7, task.getExplain());
			pstmt.setString(8, task.getLastEditedBy());
			pstmt.setString(9, task.getLastEditedDate());
			pstmt.setString(10, task.getConfirmedBy());
			pstmt.setString(11, task.getDemand_id());
			pstmt.setString(12, task.getChargeBy());
			pstmt.setInt(13, task.getBugNum());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
	}
	
	//-----------------------------------------------------------------
	public ArrayList<TaskBean> findMyCreatedTask(String id){
		ArrayList<TaskBean> list = new ArrayList<TaskBean>();
		String sql="select * from task where createdBy=?";
		try(Connection conn = dataSource.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, id);
			ResultSet rst =pstmt.executeQuery();
			while(rst.next()){
				TaskBean task = new TaskBean();
				task.setId(rst.getString("id"));
				task.setName(rst.getString("name"));
				task.setStatus(rst.getString("status"));
				task.setCreatedBy(rst.getString("createdBy"));
				task.setCreatedDate(rst.getString("createdDate"));
				task.setEndDate(rst.getString("endDate"));
				task.setExplain(rst.getString("explain"));
				task.setLastEditedBy(rst.getString("lastEditedBy"));
				task.setLastEditedDate(rst.getString("lastEditedDate"));
				task.setConfirmedBy(rst.getString("confirmedBy"));
				task.setDemand_id(rst.getString("demand_id"));
				task.setChargeBy(rst.getString("chargeBy"));
				task.setBugNum(rst.getInt("bugNum"));
				list.add(task);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}		
	}
	//------------------------------------------------------------------
	public ArrayList<TaskBean> findMyConfirmedTask(String id){
		ArrayList<TaskBean> list = new ArrayList<TaskBean>();
		String sql="select * from task where confirmedBy=?";
		try(Connection conn = dataSource.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, id);
			ResultSet rst =pstmt.executeQuery();
			while(rst.next()){
				TaskBean task = new TaskBean();
				task.setId(rst.getString("id"));
				task.setName(rst.getString("name"));
				task.setStatus(rst.getString("status"));
				task.setCreatedBy(rst.getString("createdBy"));
				task.setCreatedDate(rst.getString("createdDate"));
				task.setEndDate(rst.getString("endDate"));
				task.setExplain(rst.getString("explain"));
				task.setLastEditedBy(rst.getString("lastEditedBy"));
				task.setLastEditedDate(rst.getString("lastEditedDate"));
				task.setConfirmedBy(rst.getString("confirmedBy"));
				task.setDemand_id(rst.getString("demand_id"));
				task.setChargeBy(rst.getString("chargeBy"));
				task.setBugNum(rst.getInt("bugNum"));
				list.add(task);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}		
	}
	//------------------------------------------------------------------
	public ArrayList<TaskBean> findMyChargedTask(String id){
		ArrayList<TaskBean> list = new ArrayList<TaskBean>();
		String sql="select * from task where chargedBy=?";
		try(Connection conn = dataSource.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, id);
			ResultSet rst =pstmt.executeQuery();
			while(rst.next()){
				TaskBean task = new TaskBean();
				task.setId(rst.getString("id"));
				task.setName(rst.getString("name"));
				task.setStatus(rst.getString("status"));
				task.setCreatedBy(rst.getString("createdBy"));
				task.setCreatedDate(rst.getString("createdDate"));
				task.setEndDate(rst.getString("endDate"));
				task.setExplain(rst.getString("explain"));
				task.setLastEditedBy(rst.getString("lastEditedBy"));
				task.setLastEditedDate(rst.getString("lastEditedDate"));
				task.setConfirmedBy(rst.getString("confirmedBy"));
				task.setDemand_id(rst.getString("demand_id"));
				task.setChargeBy(rst.getString("chargeBy"));
				task.setBugNum(rst.getInt("bugNum"));
				list.add(task);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}		
	}
	//------------------------------------------------------------------
	public boolean deleteTask(String id) {
		String sql = "DELETE FROM task where id=?";
		try (Connection conn = dataSource.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 已测试
	 * 
	 * @param user
	 * @return
	 */
	public boolean updateTask(TaskBean task) {
		Date d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
		String dateNowStr =sdf.format(d);
		String sql = "update task set id=?,name=?,status=?,endDate=?,explain=?,lastEditedBy=?,lastEditedDate=?,confirmedBy=?,chargeBy=?,bugNum=? where id=?";
		try (Connection conn = dataSource.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, task.getId());
			pstmt.setString(2, task.getName());
			pstmt.setString(3, task.getStatus());
			pstmt.setString(4, task.getEndDate());
			pstmt.setString(5, task.getExplain());
			pstmt.setString(6, task.getLastEditedBy());
			pstmt.setString(7, dateNowStr);//最后编辑时间
			pstmt.setString(8, task.getConfirmedBy());
			pstmt.setString(9, task.getId());
			pstmt.setString(10,task.getChargeBy());
			pstmt.setInt(11, task.getBugNum());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
	}
}
