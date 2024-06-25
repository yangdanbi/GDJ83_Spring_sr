package com.sse.app.employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sse.app.util.DBConnection;

@Repository
public class EmployeeDAO {
	
	@Autowired
	private DBConnection dbConnection;
	
	public List<EmployeeDTO> getList() throws Exception {
		
		Connection con = dbConnection.getConnection();
		String sql = "SELECT EMPLOYEE_ID,FIRST_NAME,LAST_NAME,JOB_ID FROM EMPLOYEES ORDER BY EMPLOYEE_ID ASC";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		ArrayList<EmployeeDTO> ar = new ArrayList<EmployeeDTO>();
		while(rs.next()) {
			EmployeeDTO employeeDTO = new EmployeeDTO();
			
			employeeDTO.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
			employeeDTO.setFirst_name(rs.getNString("FIRST_NAME"));
			employeeDTO.setLast_name(rs.getNString("LAST_NAME"));
			employeeDTO.setJob_id(rs.getNString("JOB_ID"));
			
			ar.add(employeeDTO);
		}
		
		rs.close();
		st.close();
		con.close();
		
		return ar;
		
	}
	

}
