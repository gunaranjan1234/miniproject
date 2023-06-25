package com.kce.Employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kce.Employee.bean.EmployeeBean;
import com.kce.Employee.util.DBconnection;

public class EmployeeDAO {
	static PreparedStatement ps;
	static Connection c=DBconnection.getConnection();
	static ResultSet rs;
	
	public static boolean addEmployee(EmployeeBean emp) {
		try {
			ps=c.prepareStatement("select id from Employee");
			rs=ps.executeQuery();
			int count=0;
			while(rs.next()) {
				if(rs.getInt(1)==emp.getEmployee_id()) 
					count++;
			}
			if(count==0)
			{
				ps=c.prepareStatement("insert into Employee values(?,?,?,?,?)");
				ps.setInt(1, emp.getEmployee_id());
				ps.setString(2, emp.getName());
				ps.setDouble(3,emp.getSalary());
				ps.setInt(4, emp.getAge());
				ps.setInt(5,emp.getDepartment_id());
				ps.execute();
				return true;
			}
			else {
				return false;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
public static boolean deleteEmployee(EmployeeBean emp) {
	try {
		ps=c.prepareStatement("select id from Employee");
		rs=ps.executeQuery();
		int count=0;
		while(rs.next()) {
			if(rs.getInt(1)==emp.getEmployee_id()) count++;
		}
		if(count==0) return false;
		else {
			ps=c.prepareStatement("delete from Employee where id=?");
			ps.setInt(1, emp.getEmployee_id());
			ps.execute();
			return true;
		}
	}catch(SQLException e) {
		System.out.println(e);
	}
	return false;
}
public static boolean updateEmployeesalary(EmployeeBean emp) {
	try {
		ps=c.prepareStatement("select id from Employee");
		rs=ps.executeQuery();
		int count=0;
		while(rs.next()) {
			if(rs.getInt(1)==emp.getEmployee_id()) count++;
		}
		if(count==0) return false;
		else {
			ps=c.prepareStatement("update Employee set salary=? where id=?");
			ps.setInt(1, (int) emp.getSalary());
			ps.setInt(2, emp.getEmployee_id());
			ps.execute();
			return true;
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return false;
}
public static boolean updateEmployeeage(EmployeeBean emp) {
	try {
		ps=c.prepareStatement("select id from Employee");
		rs=ps.executeQuery();
		int count=0;
		while(rs.next()) {
			if(rs.getInt(1)==emp.getEmployee_id()) count++;
		}
		if(count==0) return false;
		else {
			ps=c.prepareStatement("update Employee set age=? where id=?");
			ps.setLong(1, emp.getAge());
			ps.setInt(2, emp.getEmployee_id());
			ps.execute();
			return true;
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return false;
}
public static List<EmployeeBean> viewAllEmployee() {
	List<EmployeeBean> list=new ArrayList<>();
	try {
		ps=c.prepareStatement("select * from Employee");
		rs=ps.executeQuery();
		while(rs.next()) {
			list.add(new EmployeeBean(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getInt(4),rs.getInt(5)));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return list;
}
public static EmployeeBean viewOneEmployee(EmployeeBean emp) {
	EmployeeBean Employee=null;
	try {
		ps=c.prepareStatement("select * from Employee where id=?");
		ps.setInt(1, emp.getEmployee_id());
		rs=ps.executeQuery();
		while(rs.next()) {
			Employee=new EmployeeBean(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getInt(4),rs.getInt(5));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return Employee;
}
}



