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
			departmentDTO.setLocateion_id(rs.getInt("LOCATION_ID"));

			ar.add(departmentDTO);
		}

//		자원 해제
		rs.close();
		st.close();
		con.close();

		return ar;

	}

}
