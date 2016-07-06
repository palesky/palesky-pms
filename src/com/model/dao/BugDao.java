package com.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.bean.BugBean;

/**
 * 未测试
 * @author xj
 *
 */
public class BugDao extends BaseDao{
	public ArrayList<ProductDao> findAllProductDao() {
		ArrayList<ProductDao> list = new ArrayList<ProductDao>();
		String sql = "SELECT * FROM bug ";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			ResultSet rst = pstmt.executeQuery();
			while (rst.next()) {
				BugBean bug = new BugBean();
				bug.setName(rst.getString("name"));
				bug.setStatus(rst.getString("status"));
				bug.setBug_type(rst.getString("bug_type"));
				bug.setOs(rst.getString("os"));
				bug.setBrowser(rst.getString("browser"));
				bug.setFoundBy(rst.getString("foundBy"));
				bug.setFoundDate(rst.getString("foundDate"));
				bug.setPriority(rst.getString("priority"));
				bug.setSteps(rst.getString("steps"));
				bug.setUsecaseId(rst.getString("usecaseId"));
				bug.setTask_testerId(rst.getString("task_testerId"));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean addUser(BugBean bug) {
		String sql = "INSERT INTO product(name,status,bug_type,os,browser,foundBy,foundDate,priority,steps,usecaseId,task_testerId)VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, bug.getName());
			pstmt.setString(2, bug.getStatus());
			pstmt.setString(3, bug.getBug_type());
			pstmt.setString(4, bug.getOs());
			pstmt.setString(5, bug.getBrowser());
			pstmt.setString(6, bug.getFoundBy());
			pstmt.setString(7, bug.getFoundDate());
			pstmt.setString(8, bug.getPriority());
			pstmt.setString(9, bug.getSteps());
			pstmt.setString(10, bug.getUsecaseId());
			pstmt.setString(11, bug.getTask_testerId());
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
		String sql = "DELETE FROM bug where id=?";
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
	public boolean updateUser(BugBean bug) {
		String sql = "update bug set name=?,status=?,bug_type=?,os=?,browser=?,foundBy=?,foundDate=?,priority=?,steps=?,usecaseId=?,task_testerId=? where id=?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, bug.getName());
			pstmt.setString(2, bug.getStatus());
			pstmt.setString(3, bug.getBug_type());
			pstmt.setString(4, bug.getOs());
			pstmt.setString(5, bug.getBrowser());
			pstmt.setString(6, bug.getFoundBy());
			pstmt.setString(7, bug.getFoundDate());
			pstmt.setString(8, bug.getPriority());
			pstmt.setString(9, bug.getSteps());
			pstmt.setString(10, bug.getUsecaseId());
			pstmt.setString(11, bug.getTask_testerId());
			pstmt.setString(12, bug.getName());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
	}
}
