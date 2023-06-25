package com.kce.Employee.bean;

public class EmployeeBean {
	private int employee_id;
	private String name;
	private double salary;
	private int age;
	private int department_id;
	
	public EmployeeBean() {
		
	}

	public EmployeeBean(int employee_id, String name, double salary, int age, int department_id) {
		super();
		this.employee_id = employee_id;
		this.name = name;
		this.salary = salary;
		this.age = age;
		this.department_id = department_id;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}

	@Override
	public String toString() {
		return "EmployeeBean [employee_id=" + employee_id + ", name=" + name + ", salary=" + salary + ", age=" + age
				+ ", department_id=" + department_id + "]";
	}

}
