package com.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.bean.DemandBean;

/**
 * 未测试
 * @author xj
 *
 */
public class DemandDao extends BaseDao{
	public ArrayList<DemandBean> findAllDemandBean() {
		ArrayList<DemandBean> list = new ArrayList<DemandBean>();
		String sql = "SELECT * FROM demand ";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			ResultSet rst = pstmt.executeQuery();
			while (rst.next()) {
				DemandBean demand = new DemandBean();
				demand.setId(rst.getString("id"));
				demand.setName(rst.getString("name"));
				demand.setStatus(rst.getString("status"));
				demand.setCreatedBy(rst.getString("createdBy"));
				demand.setCreatedDate(rst.getString("createdDate"));
				demand.setEndDate(rst.getString("endDate"));
				demand.setExplain(rst.getString("explain"));
				demand.setLastEditedDate(rst.getString("lastEditedDate"));
				demand.setConfirmedBy(rst.getString("confirmedBy"));
				demand.setProject_id(rst.getString("project_id"));
				System.out.println(demand.toString());
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public DemandBean getUser(String name) {
		String sql = "SELECT * FROM demand where name=?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, name);
			ResultSet rst = pstmt.executeQuery();
			DemandBean demand = new DemandBean();
			while (rst.next()) {
				demand.setId(rst.getString("id"));
				demand.setName(rst.getString("name"));
				demand.setStatus(rst.getString("status"));
				demand.setCreatedBy(rst.getString("createdBy"));
				demand.setCreatedDate(rst.getString("createdDate"));
				demand.setEndDate(rst.getString("endDate"));
				demand.setExplain(rst.getString("explain"));
				demand.setLastEditedDate(rst.getString("lastEditedDate"));
				demand.setConfirmedBy(rst.getString("confirmedBy"));
				demand.setProject_id(rst.getString("project_id"));
			}
			return demand;
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
	public boolean addUser(DemandBean demand) {
		String sql = "INSERT INTO demand(id,name,status,createdBy,createdDate,endDate,explain,lastEditedDate,confirmedBy,project_id)VALUES(?,?,?,?,?,?,?,?,?,?)";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, demand.getId());
			pstmt.setString(2, demand.getName());
			pstmt.setString(3, demand.getStatus());
			pstmt.setString(4, demand.getCreatedBy());
			pstmt.setString(5, demand.getCreatedDate());
			pstmt.setString(6, demand.getEndDate());
			pstmt.setString(7, demand.getExplain());
			pstmt.setString(8, demand.getLastEditedDate());
			pstmt.setString(9, demand.getConfirmedBy());
			pstmt.setString(10, demand.getProject_id());
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
		String sql = "DELETE FROM demand where id=?";
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
	public boolean updateUser(DemandBean demand) {
		String sql = "update demand set id=?,name=?,status=?,createdBy=?,createdDate=?,endDate=?,explain=?,lastEditedDate=?,confirmedBy=?,project_id=? where id=?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, demand.getId());
			pstmt.setString(2, demand.getName());
			pstmt.setString(3, demand.getStatus());
			pstmt.setString(4, demand.getCreatedBy());
			pstmt.setString(5, demand.getCreatedDate());
			pstmt.setString(6, demand.getEndDate());
			pstmt.setString(7, demand.getExplain());
			pstmt.setString(8, demand.getLastEditedDate());
			pstmt.setString(9, demand.getConfirmedBy());
			pstmt.setString(10, demand.getProject_id());
			pstmt.setString(11, demand.getId());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
	}
}
