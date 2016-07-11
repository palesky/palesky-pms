package com.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.bean.ProductBean;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * 以此为准：全部未测试
 * @author xj
 *
 */
public class ProductDao extends BaseDao{
	
	public ArrayList<ProductBean> findAllProduct() {
		System.out.println("running findAllProduct");
		ArrayList<ProductBean> list = new ArrayList<ProductBean>();
		String sql = "SELECT * FROM product ";
		try (Connection conn = dataSource.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
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
				System.out.println(product.toString());
				list.add(product);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ProductBean getProduct(String id) {
		String sql = "SELECT * FROM product where id=?";
		try (Connection conn = dataSource.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, id);
			ResultSet rst = pstmt.executeQuery();
			ProductBean product = new ProductBean();
			while (rst.next()) {
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
			return product;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("return null");
			return null;
		}
	}
	
	
	public boolean addProduct(ProductBean product) {
		Date d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
		String dateNowStr =sdf.format(d);
		String sql = "INSERT INTO product(id,name,status,pro_type,createdBy,createdDate,endDate,explain,confirmedBy)VALUES(?,?,?,?,?,?,?,?,?)";
		try (Connection conn = dataSource.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, product.getId());
			pstmt.setString(2, product.getName());
			pstmt.setString(3, product.getStatus());
			pstmt.setString(4, product.getPro_type());
			pstmt.setString(5, product.getCreatedBy());
			pstmt.setString(6, dateNowStr);
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
	
	
	public boolean deleteProduct(String id) {
		String sql = "DELETE FROM product where id=?";
		try (Connection conn = dataSource.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
	}
	
	
	public boolean updateProduct(ProductBean product) {
		String sql = "update product set id=?,name=?,status=?,pro_type=?,endDate=?,explain=?,confirmedBy=? where id=?";
		try (Connection conn = dataSource.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, product.getId());
			pstmt.setString(2, product.getName());
			pstmt.setString(3, product.getStatus());
			pstmt.setString(4, product.getPro_type());
			pstmt.setString(5, product.getEndDate());
			pstmt.setString(6, product.getExplain());
			pstmt.setString(7, product.getConfirmedBy());
			pstmt.setString(8, product.getId());
			pstmt.executeUpdate();
			return true;
		} catch (SQLException se) {
			se.printStackTrace();
			return false;
		}
	}
}
