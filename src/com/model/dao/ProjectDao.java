package com.model.dao;

import java.sql.Connection;
import java.util.Date;
import java.text.SimpleDateFormat;

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
	
	public ArrayList<ProjectBean> findAllProject() {
		ArrayList<ProjectBean> list = new ArrayList<ProjectBean>();
		String sql = "SELECT * FROM project ";
		try (Connection conn = dataSource.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			ResultSet rst = pstmt.executeQuery();
			while (rst.next()) {
				ProjectBean project = new ProjectBean();
				project.setId(rst.getString("id"));
				project.setName(rst.getString("name"));
				project.setStatus(rst.getString("status"));
				project.setCreatedBy(rst.getString("createdBy"));
				project.setCreatedDate(rst.getString("createdDate"));
				project.setEndDate(rst.getString("endDate"));
				project.setExplain(rst.getString("explain"));
				project.setTeam(rst.getString("team"));
				project.setConfirmedBy(rst.getString("confirmedBy"));
				project.setProd_id(rst.getString("prod_id"));
				project.setChargeBy(rst.getString("chargeBy"));
				
				System.out.println(project.toString());
				list.add(project);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
    //通过id获取 项目信息
	public ProjectBean getProject(String id) {
		String sql = "SELECT * FROM project where id=?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, id);
			ResultSet rst = pstmt.executeQuery();
			ProjectBean project = new ProjectBean();
			while (rst.next()) {
				project.setId(rst.getString("id"));
				project.setName(rst.getString("name"));
				project.setStatus(rst.getString("status"));
				project.setCreatedBy(rst.getString("createdBy"));
				project.setCreatedDate(rst.getString("createdDate"));
				project.setEndDate(rst.getString("endDate"));
				project.setExplain(rst.getString("explain"));
				project.setTeam(rst.getString("team"));
				project.setConfirmedBy(rst.getString("confirmedBy"));
				project.setProd_id(rst.getString("prod_id"));
				project.setChargeBy(rst.getString("chargeBy"));
			}
			return project;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("return null");
			return null;
		}
	}

	
	public boolean addProject(ProjectBean project) {
		Date d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
		String dateNowStr =sdf.format(d);
		String sql = "INSERT INTO project(id,name,status,createdBy,createdDate,endDate,explain,team,confirmedBy,prod_id,chargeBy)VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		try (Connection conn = dataSource.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, project.getId());
			pstmt.setString(2, project.getName());
			pstmt.setString(3, project.getStatus());
			pstmt.setString(4, project.getCreatedBy());
			pstmt.setString(5, dateNowStr);
			pstmt.setString(6, project.getEndDate());
			pstmt.setString(7, project.getExplain());
			pstmt.setString(8, project.getTeam());
			pstmt.setString(9, project.getConfirmedBy());
			pstmt.setString(10, project.getChargeBy());
			pstmt.setString(11, project.getProd_id());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
	}

	
	public boolean deleteProject(String id) {
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

	//更新产品信息
	/*
	 * 7/10      删除修改id,创建者,创建时间等功能    lk
	 * 
	 * */
	public boolean updateProject(ProjectBean project) {
		
		String sql = "update project set id=?,name=?,status=?,endDate=?,explain=?,team=?,confirmedBy=?,chargeBy=? where id=?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(2, project.getName());
			pstmt.setString(3, project.getStatus());
			pstmt.setString(4, project.getEndDate());
			pstmt.setString(5, project.getExplain());
			pstmt.setString(6, project.getTeam());
			pstmt.setString(7, project.getConfirmedBy());
			pstmt.setString(8, project.getChargeBy());
			pstmt.setString(9, project.getId());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
	}

}
