package com.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.bean.ProductBean;


/**
 * 以此为准：全部未测试
 * @author xj
 *
 */
public class ProductDao extends BaseDao{
	
	public ArrayList<ProductDao> findAllProductDao() {
		ArrayList<ProductDao> list = new ArrayList<ProductDao>();
		String sql = "SELECT * FROM product ";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			ResultSet rst = pstmt.executeQuery();
			while (rst.next()) {
				ProductBean product = new ProductBean();
				product.setId(rst.getString("id"));
				product.setName(rst.getString("name"));
				product.setStatus(rst.getString("status"));
				product.setPro_type(rst.getString("pro_type"));
				product.setCreatedBy(rst.getString("createdBy"));
				product.setCreateDate(rst.getString("createdDate"));
				product.setEndDate(rst.getString("endDate"));
				product.setExplain(rst.getString("explain"));
				product.setConfirmedBy(rst.getString("confirmedBy"));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean addUser(ProductBean product) {
		String sql = "INSERT INTO product(id,name,status,pro_type,createdBy,createdDate,endDate,explain,confirmedBy)VALUES(?,?,?,?,?,?,?,?,?)";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, product.getId());
			pstmt.setString(2, product.getName());
			pstmt.setString(3, product.getStatus());
			pstmt.setString(4, product.getPro_type());
			pstmt.setString(5, product.getCreatedBy());
			pstmt.setString(6, product.getCreateDate());
			pstmt.setString(7, product.getEndDate());
			pstmt.setString(8, product.getExplain());
			pstmt.setString(9, product.getConfirmedBy());
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
	public boolean updateUser(ProductBean product) {
		String sql = "update product set id=?,name=?,status=?,pro_type=?,createdBy=?,createdDate=?,endDate=?,explain=?,confirmedBy=? where id=?";
		try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, product.getId());
			pstmt.setString(2, product.getName());
			pstmt.setString(3, product.getStatus());
			pstmt.setString(4, product.getPro_type());
			pstmt.setString(5, product.getCreatedBy());
			pstmt.setString(6, product.getCreateDate());
			pstmt.setString(7, product.getEndDate());
			pstmt.setString(8, product.getExplain());
			pstmt.setString(9, product.getConfirmedBy());
			pstmt.setString(10, product.getId());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
	}
}
