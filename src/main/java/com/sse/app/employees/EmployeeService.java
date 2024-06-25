package com.sse.app.employees;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	public List<EmployeeDTO> getList() throws Exception {
		return employeeDAO.getList();
	}

}
