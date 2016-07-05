package com.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.bean.user.UserBean;



public class UserDao extends BaseDao{
	public ArrayList<UserBean> findAllUserBean() {
		ArrayList<UserBean> list = new ArrayList<UserBean>();
		String sql = "SELECT * FROM user ";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			ResultSet rst = pstmt.executeQuery();
			while (rst.next()) {
				UserBean UserBean = new UserBean();
				UserBean.setId(rst.getString("id"));
				UserBean.setAccount(rst.getString("account"));
				UserBean.setPassword(rst.getString("password"));
				UserBean.setRealname(rst.getString("realname"));
				UserBean.setGender(rst.getString("gender"));
				UserBean.setRole(rst.getString("role"));
				UserBean.setEmail(rst.getString("email"));
				UserBean.setPhone(rst.getString("phone"));
				UserBean.setIp(rst.getString("lastIp"));
				UserBean.setLastLogin(rst.getString("lastLogin"));
				UserBean.setVisits(rst.getString("visit"));
				UserBean.setPrivilege(rst.getString("privilege"));
				UserBean.setBelongTo(rst.getString("belongTo"));
				System.out.println(UserBean.toString());
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public UserBean getUser(String account){
		String sql = "SELECT * FROM user where account=?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1,account);
			ResultSet rst = pstmt.executeQuery();
			UserBean userBean = new UserBean();
			while (rst.next()) {		
				userBean.setId(rst.getString("id"));
				userBean.setAccount(rst.getString("account"));
				userBean.setPassword(rst.getString("password"));
				userBean.setRealname(rst.getString("realname"));
				userBean.setGender(rst.getString("gender"));
				userBean.setRole(rst.getString("role"));
				userBean.setEmail(rst.getString("email"));
				userBean.setPhone(rst.getString("phone"));
				userBean.setIp(rst.getString("lastIp"));
				userBean.setLastLogin(rst.getString("lastLogin"));
				userBean.setVisits(rst.getString("visit"));
				userBean.setPrivilege(rst.getString("privilege"));
				userBean.setBelongTo(rst.getString("belongTo"));
			}
			return userBean;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("return null");
			return null;
		}
	}
}
