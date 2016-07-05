package com.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.bean.ProjectBean;
/**
 * 未测试，以此句为准
 * @author xj
 *
 */
public class ProjectDao extends BaseDao{
	public ArrayList<ProjectBean> findAllProjectBean() {
		ArrayList<ProjectBean> list = new ArrayList<ProjectBean>();
		String sql = "SELECT * FROM project ";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			ResultSet rst = pstmt.executeQuery();
			while (rst.next()) {
				ProjectBean project = new ProjectBean();
				project.setId(rst.getString("id"));
				project.setName(rst.getString("name"));
				project.setStatus(rst.getString("status"));
				project.setCreatedBy(rst.getString("createdBy"));
				project.setCreateDate(rst.getString("createDate"));
				project.setEndDate(rst.getString("endDate"));
				project.setExplain(rst.getString("explain"));
				project.setTeam(rst.getString("team"));
				project.setConfirmedBy(rst.getString("confirmedBy"));
				project.setProd_id(rst.getString("prod_id"));
				System.out.println(project.toString());
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public ProjectBean getUser(String name) {
		String sql = "SELECT * FROM project where name=?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, name);
			ResultSet rst = pstmt.executeQuery();
			ProjectBean project = new ProjectBean();
			while (rst.next()) {
				project.setId(rst.getString("id"));
				project.setName(rst.getString("name"));
				project.setStatus(rst.getString("status"));
				project.setCreatedBy(rst.getString("createdBy"));
				project.setCreateDate(rst.getString("createDate"));
				project.setEndDate(rst.getString("endDate"));
				project.setExplain(rst.getString("explain"));
				project.setTeam(rst.getString("team"));
				project.setConfirmedBy(rst.getString("confirmedBy"));
				project.setProd_id(rst.getString("prod_id"));
			}
			return project;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("return null");
			return null;
		}
	}

	/**
	 * 已测试
	 * 
	 * @param user
	 * @return
	 */
	public boolean addUser(ProjectBean project) {
		String sql = "INSERT INTO project(id,name,status,createdBy,createDate,endDate,explain,team,confirmedBy,prod_id)VALUES(?,?,?,?,?,?,?,?,?,?)";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, project.getId());
			pstmt.setString(2, project.getName());
			pstmt.setString(3, project.getStatus());
			pstmt.setString(4, project.getCreatedBy());
			pstmt.setString(5, project.getCreateDate());
			pstmt.setString(6, project.getEndDate());
			pstmt.setString(7, project.getExplain());
			pstmt.setString(8, project.getTeam());
			pstmt.setString(9, project.getConfirmedBy());
			pstmt.setString(10, project.getProd_id());
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
		String sql = "DELETE FROM project where id=?";
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
	public boolean updateUser(ProjectBean project) {
		String sql = "update project set id=?,name=?,status=?,createdBy=?,createDate=?,endDate=?,explain=?,team=?,confirmedBy=?,prod_id=? where id=?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, project.getId());
			pstmt.setString(2, project.getName());
			pstmt.setString(3, project.getStatus());
			pstmt.setString(4, project.getCreatedBy());
			pstmt.setString(5, project.getCreateDate());
			pstmt.setString(6, project.getEndDate());
			pstmt.setString(7, project.getExplain());
			pstmt.setString(8, project.getTeam());
			pstmt.setString(9, project.getConfirmedBy());
			pstmt.setString(10, project.getProd_id());
			pstmt.setString(11, project.getId());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
	}

}
