package com.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.bean.UsecaseBean;

public class UsecaseDao extends BaseDao{
	public ArrayList<UsecaseDao> findAllUsecaseDao() {
		ArrayList<UsecaseDao> list = new ArrayList<UsecaseDao>();
		String sql = "SELECT * FROM usecase ";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			ResultSet rst = pstmt.executeQuery();
			while (rst.next()) {
				UsecaseBean usecase = new UsecaseBean();
				usecase.setId(rst.getString("id"));
				usecase.setUsecaseLibId(rst.getString("usecaseLibId"));
				usecase.setUsecaseLibType(rst.getString("usecaseLibType"));
				usecase.setCreatedBy(rst.getString("createdBy"));
				usecase.setCreatedDate(rst.getString("createdDate"));
				usecase.setSteps(rst.getString("steps"));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean addUser(UsecaseBean usecase) {
		String sql = "INSERT INTO usecase(id,usecaseLibId,usecaseLibType,createdBy,createdDate,steps)VALUES(?,?,?,?,?,?)";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, usecase.getId());
			pstmt.setString(2, usecase.getUsecaseLibId());
			pstmt.setString(3, usecase.getUsecaseLibType());
			pstmt.setString(4, usecase.getCreatedBy());
			pstmt.setString(5, usecase.getCreatedDate());
			pstmt.setString(6, usecase.getSteps());
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
		String sql = "DELETE FROM usecase where id=?";
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
	public boolean updateUser(UsecaseBean usecase) {
		String sql = "update usecase set id=?,usecaseLibId=?,usecaseLibType=?,createdBy=?,createdDate=?,steps=? where id=?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, usecase.getId());
			pstmt.setString(2, usecase.getUsecaseLibId());
			pstmt.setString(3, usecase.getUsecaseLibType());
			pstmt.setString(4, usecase.getCreatedBy());
			pstmt.setString(5, usecase.getCreatedDate());
			pstmt.setString(6, usecase.getSteps());
			pstmt.setString(7, usecase.getId());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
	}
}
