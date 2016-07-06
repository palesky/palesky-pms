package com.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.bean.UsecaseLibBean;
/**
 * 未测试
 * @author xj
 *
 */
public class UsecaseLibDao extends BaseDao{
	public ArrayList<UsecaseLibBean> findAllUsecaseLibBean() {
		ArrayList<UsecaseLibBean> list = new ArrayList<UsecaseLibBean>();
		String sql = "SELECT * FROM usecaseLib ";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			ResultSet rst = pstmt.executeQuery();
			while (rst.next()) {
				UsecaseLibBean usecaseLib = new UsecaseLibBean();
				usecaseLib.setId(rst.getString("id"));
				usecaseLib.setUsecaseLib_type(rst.getString("usecaseLibId"));
				usecaseLib.setCreatedBy(rst.getString("CreatedBy"));
				usecaseLib.setCreatedDate(rst.getString("createdDate"));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean addUser(UsecaseLibBean usecaseLib) {
		String sql = "INSERT INTO usecaseLib(id,usecaseLib_type,createdBy,createdDate)VALUES(?,?,?,?)";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, usecaseLib.getId());
			pstmt.setString(2, usecaseLib.getUsecaseLib_type());
			pstmt.setString(3, usecaseLib.getCreatedBy());
			pstmt.setString(4, usecaseLib.getCreatedDate());
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
		String sql = "DELETE FROM usecaseLib where id=?";
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
	public boolean updateUser(UsecaseLibBean usecaseLib) {
		String sql = "update usecaseLib set id=?,usecaseLib_type=?,createdBy=?,createdDate=? where id=?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, usecaseLib.getId());
			pstmt.setString(2, usecaseLib.getUsecaseLib_type());
			pstmt.setString(3, usecaseLib.getCreatedBy());
			pstmt.setString(4, usecaseLib.getCreatedDate());
			pstmt.setString(5, usecaseLib.getId());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
	}
}
