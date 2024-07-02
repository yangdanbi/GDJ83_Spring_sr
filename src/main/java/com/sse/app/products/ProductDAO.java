package com.sse.app.products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sse.app.util.DBConnection;

@Repository
public class ProductDAO {

	@Autowired
	private DBConnection dbconnection;

	public List<ProductDTO> getList() throws Exception {

		Connection con = dbconnection.getConnection();
		String sql = "SELECT * FROM ITEMS ORDER BY ITEM_ID ASC";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		ArrayList<ProductDTO> ar = new ArrayList<ProductDTO>();

		while (rs.next()) {

			ProductDTO productDTO = new ProductDTO();

			productDTO.setItem_id(rs.getInt("ITEM_ID"));
			productDTO.setItem_name(rs.getString("ITEM_NAME"));
			productDTO.setItem_detail(rs.getString("ITEM_DETAIL"));
			productDTO.setItem_rate(rs.getDouble("ITEM_RATE"));

			ar.add(productDTO);

		}

		rs.close();
		ps.close();
		con.close();

		return ar;

	}

	public ProductDTO getDeatil(ProductDTO productDTO) throws Exception {

		Connection con = dbconnection.getConnection();
		String sql = "SELECT * FROM ITEMS WHERE ITEM_ID = ?";
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setInt(1, productDTO.getItem_id());

		ResultSet rs = ps.executeQuery();
		productDTO = null;

		if (rs.next()) {

			productDTO = new ProductDTO();

			productDTO.setItem_id(rs.getInt("ITEM_ID"));
			productDTO.setItem_name(rs.getString("ITEM_NAME"));
			productDTO.setItem_detail(rs.getString("ITEM_DETAIL"));
			productDTO.setItem_rate(rs.getDouble("ITEM_RATE"));

		}

		rs.close();
		ps.close();
		con.close();

		return productDTO;

	}

	public int addInfo(ProductDTO productDTO) throws Exception {

		Connection con = dbconnection.getConnection();
		String sql = "INSERT INTO ITEMS VALUES (ITEMS_SEQ.NEXTVAL, ?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, productDTO.getItem_name());
		ps.setString(2, productDTO.getItem_detail());
		ps.setDouble(3, productDTO.getItem_rate());

		int num = ps.executeUpdate();

		return num;
	}

}