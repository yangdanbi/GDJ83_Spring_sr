package com.sse.app.departments;

public class DepartmentDTO {

//	사용하려는 테이블의 컬럼명과 타입을 일치
	private Integer department_id;
	private String department_name;
	private Long manager_id;
	private Integer locateion_id;

	public Integer getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(Integer department_id) {
		this.department_id = department_id;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	public Long getManager_id() {
		return manager_id;
	}

	public void setManager_id(Long manager_id) {
		this.manager_id = manager_id;
	}

	public Integer getLocateion_id() {
		return locateion_id;
	}

	public void setLocateion_id(Integer locateion_id) {
		this.locateion_id = locateion_id;
	}

}
