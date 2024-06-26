package com.sse.app.departments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sse.app.util.DBConnection;

@Repository
public class DepartmentDAO {

	@Autowired
	private DBConnection dbconnection;

	public List<DepartmentDTO> getList() throws Exception {

		Connection con = dbconnection.getConnection();

//		SQL(Query)문 작성
		String sql = "SELECT * FROM DEPARTMENTS ORDER BY DEPARTMENT_ID ASC";

//		작성한 쿼리문을 미리 전송
		PreparedStatement st = con.prepareStatement(sql);

//		?값 세팅(나중에 배우는거)

//		최종 전송 및 결과 처리
		ResultSet rs = st.executeQuery();
		ArrayList<DepartmentDTO> ar = new ArrayList<DepartmentDTO>();
		while (rs.next()) {
			DepartmentDTO departmentDTO = new DepartmentDTO();
			int id = rs.getInt("DEPARTMENT_ID");
			String name = rs.getString("DEPARTMENT_NAME");

			departmentDTO.setDepartment_id(id);
			departmentDTO.setDepartment_name(name);
			departmentDTO.setManager_id(rs.getLong("MANAGER_ID"));
			departmentDTO.setLocation_id(rs.getInt("LOCATION_ID"));

			ar.add(departmentDTO);
		}

//		자원 해제
		rs.close();
		st.close();
		con.close();

		return ar;

	}

	public DepartmentDTO getDetail(int num) throws Exception {

		Connection con = dbconnection.getConnection();
		String sql = "SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID=?";
		PreparedStatement st = con.prepareStatement(sql);

		st.setInt(1, num);

		ResultSet rs = st.executeQuery();

		DepartmentDTO departmentDTO = null;

		if (rs.next()) {

			departmentDTO = new DepartmentDTO();
			departmentDTO.setDepartment_id(rs.getInt(1));
			departmentDTO.setDepartment_name(rs.getNString(2));
			departmentDTO.setManager_id(rs.getLong(3));
			departmentDTO.setLocation_id(rs.getInt(4));

		}

		rs.close();
		st.close();
		con.close();

		return departmentDTO;

	}

	public int add(DepartmentDTO departmentDTO) throws Exception {

		Connection con = dbconnection.getConnection();
		String sql = "INSERT INTO DEPARTMENTS " + "(DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID) "
				+ "VALUES (DEPARTMENTS_SEQ.NEXTVAL,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);

		st.setString(1, departmentDTO.getDepartment_name());
		st.setLong(2, departmentDTO.getManager_id());
		System.out.println(st);
		st.setInt(3, departmentDTO.getLocation_id());

		int result = st.executeUpdate();

		st.close();
		con.close();

		return result;
	}

	public int delete(DepartmentDTO departmentDTO) throws Exception {

		Connection con = dbconnection.getConnection();
		String sql = "DELETE DEPARTMENTS WHERE DEPARTMENT_ID=?";
		PreparedStatement st = con.prepareStatement(sql);

		st.setInt(1, departmentDTO.getDepartment_id());

		int result = st.executeUpdate();

		st.close();
		con.close();

		return result;

	}

	public int update(DepartmentDTO departmentDTO) throws Exception {

		int result = 0;

		Connection con = dbconnection.getConnection();
		String sql = "UPDATE DEPARTMENTS SET DEPARTMENT_NAME=?,MANAGER_ID=?,LOCATION_ID=? WHERE DEPARTMENT_ID=?";
		PreparedStatement st = con.prepareStatement(sql);

		st.setString(1, departmentDTO.getDepartment_name());
		st.setLong(2, departmentDTO.getManager_id());
		st.setInt(3, departmentDTO.getLocation_id());
		st.setInt(4, departmentDTO.getDepartment_id());

		result = st.executeUpdate();

		st.close();
		con.close();

		return result;
	}

}
