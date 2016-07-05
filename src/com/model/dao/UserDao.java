package com.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.bean.UserBean;

/**
 * findByKeyword 未测试
 * @author xj
 *
 */
public class UserDao extends BaseDao {
	
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

	public UserBean getUser(String account) {
		String sql = "SELECT * FROM user where account=?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, account);
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

	/**
	 * 已测试
	 * 
	 * @param user
	 * @return
	 */
	public boolean addUser(UserBean user) {
		String sql = "INSERT INTO user(id,account,password,realname,gender,role,email,phone,lastIp,lastLogin,visit,privilege,belongTo)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getAccount());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getRealname());
			pstmt.setString(5, user.getGender());
			pstmt.setString(6, user.getRole());
			pstmt.setString(7, user.getEmail());
			pstmt.setString(8, user.getPhone());
			pstmt.setString(9, user.getIp());
			pstmt.setString(10, user.getLastLogin());
			pstmt.setString(11, user.getVisits());
			pstmt.setString(12, user.getPrivilege());
			pstmt.setString(13, user.getBelongTo());
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
		String sql = "DELETE FROM user where id=?";
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
	public boolean updateUser(UserBean user) {
		String sql = "update user set id=?,account=?,password=?,realname=?,gender=?,role=?,email=?,phone=?,lastIp=?,lastLogin=?,visit=?,privilege=?,belongTo=? where id=?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getAccount());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getRealname());
			pstmt.setString(5, user.getGender());
			pstmt.setString(6, user.getRole());
			pstmt.setString(7, user.getEmail());
			pstmt.setString(8, user.getPhone());
			pstmt.setString(9, user.getIp());
			pstmt.setString(10, user.getLastLogin());
			pstmt.setString(11, user.getVisits());
			pstmt.setString(12, user.getPrivilege());
			pstmt.setString(13, user.getBelongTo());
			pstmt.setString(14, user.getId());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
	}

	/**
	 * 测试未通过，待修改 d.findByKeyword("account", "a")；通过 和 d.findByKeyword("account",
	 * "p")；不通过 预期结果不同
	 * 
	 * 通过关键词进行模糊搜索
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public ArrayList<UserBean> findByKeyword(String key, String value) {
		ArrayList<UserBean> list = new ArrayList<UserBean>();
		String sql = "SELECT *" + " FROM user WHERE ? like ?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, key);
			pstmt.setString(2, "%" + value + "%");
			try (ResultSet rst = pstmt.executeQuery()) {
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
			}
		} catch (SQLException se) {
			se.printStackTrace();
			return null;
		}
		return list;
	}
}
