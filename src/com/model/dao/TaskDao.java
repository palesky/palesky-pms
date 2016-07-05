package com.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.bean.TaskBean;

/**
 * 未测试
 * @author xj
 *
 */
public class TaskDao extends BaseDao{
	public ArrayList<TaskDao> findAllTaskDao() {
		ArrayList<TaskDao> list = new ArrayList<TaskDao>();
		String sql = "SELECT * FROM task ";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
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
				task.setConfirmedBy(rst.getString("confirmedBy"));
				task.setDemand_id(rst.getString("demand_id"));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean addUser(TaskBean task) {
		String sql = "INSERT INTO task(id,name,status,createdBy,endDate,explain,lastEditedBy,confirmedBy,demand_id)VALUES(?,?,?,?,?,?,?,?,?)";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, task.getId());
			pstmt.setString(2, task.getName());
			pstmt.setString(3, task.getStatus());
			pstmt.setString(4, task.getCreatedBy());
			pstmt.setString(5, task.getEndDate());
			pstmt.setString(6, task.getExplain());
			pstmt.setString(7, task.getLastEditedBy());
			pstmt.setString(8, task.getConfirmedBy());
			pstmt.setString(9, task.getDemand_id());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 已测试 删除用户 此处应已经做过权限验证
	 * 
	 * @param account
	 * @return
	 */
	public boolean deleteUser(String id) {
		String sql = "DELETE FROM product where id=?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
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
	public boolean updateUser(TaskBean task) {
		String sql = "update product set id=?,name=?,status=?,createdBy=?,endDate=?,explain=?,lastEditedBy=?,confirmedBy=?,demand_id=? where id=?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, task.getId());
			pstmt.setString(2, task.getName());
			pstmt.setString(3, task.getStatus());
			pstmt.setString(4, task.getCreatedBy());
			pstmt.setString(5, task.getEndDate());
			pstmt.setString(6, task.getExplain());
			pstmt.setString(7, task.getLastEditedBy());
			pstmt.setString(8, task.getConfirmedBy());
			pstmt.setString(9, task.getDemand_id());
			pstmt.setString(10, task.getId());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
	}
}
