package com.kce.Employee.bean;

public class Department {
	private int department_id;
	private String department_name;
	private int employee_id;

	public Department()
	{
		
	}
	public Department(int department_id, String department_name, int employee_id) {
		super();
		this.department_id = department_id;
		this.department_name = department_name;
		this.employee_id = employee_id;
	}

	public int getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	@Override
	public String toString() {
		return "Department [department_id=" + department_id + ", department_name=" + department_name + ", employee_id="
				+ employee_id + "]";
	}

}
