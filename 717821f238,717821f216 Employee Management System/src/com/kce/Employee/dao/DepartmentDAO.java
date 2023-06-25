package com.kce.Employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kce.Employee.bean.Department;
import com.kce.Employee.util.DBconnection;

public class DepartmentDAO {
        
	static PreparedStatement ps;
	static Connection c=DBconnection.getConnection();
	static ResultSet rs;
	
	public static boolean addDepartment(Department d) {
		try {
			ps=c.prepareStatement("select id from Department");
			rs=ps.executeQuery();
			int count=0;
			while(rs.next()) {
				if(rs.getInt(1)==d.getEmployee_id()) count++;
			}
			if(count==0) {
				ps=c.prepareStatement("insert into Department values(?,?,?)");
				ps.setInt(1, d.getDepartment_id());
				ps.setString(2, d.getDepartment_name());
				ps.setInt(3, d.getEmployee_id());
				ps.execute();
				return true;
			}
			else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
public static boolean deleteDepartment(Department d) {
	try {
		ps=c.prepareStatement("select department_id from Department");
		rs=ps.executeQuery();
		int count=0;
		while(rs.next()) {
			if(rs.getInt(1)==d.getDepartment_id()) count++;
		}
		if(count==0) return false;
		else {
			ps=c.prepareStatement("delete from Department where department_id=?");
			ps.setInt(1, d.getDepartment_id());
			ps.execute();
			return true;
		}
	}catch(SQLException e) {
		System.out.println(e);
	}
	return false;
}
public static boolean updateDepartmentID(Department d) {
	try {
		ps=c.prepareStatement("select id from Department");
		rs=ps.executeQuery();
		int count=0;
		while(rs.next()) {
			if(rs.getInt(1)==d.getEmployee_id()) count++;
		}
		if(count==0) return false;
		else {
			ps=c.prepareStatement("update Department set department_id=? where id=?");
			ps.setInt(1, d.getDepartment_id());
			ps.setInt(2, d.getEmployee_id());
			ps.execute();
			return true;
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return false;
}
public static boolean updateDepartmentName(Department d) {
	try {
		ps=c.prepareStatement("select id from Department");
		rs=ps.executeQuery();
		int count=0;
		while(rs.next()) {
			if(rs.getInt(1)==d.getEmployee_id()) count++;
		}
		if(count==0) return false;
		else {
			ps=c.prepareStatement("update Department set department_name=? where id=?");
			ps.setString(1, d.getDepartment_name());
			ps.setInt(2, d.getEmployee_id());
			ps.execute();
			return true;
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return false;
}
public static List<Department> viewAllDepartment() {
	List<Department> list=new ArrayList<>();
	try {
		ps=c.prepareStatement("select * from Department");
		rs=ps.executeQuery();
		while(rs.next()) {
			list.add(new Department(rs.getInt(1),rs.getString(2),rs.getInt(3)));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return list;
}
public static Department viewOneDepartment(Department d) {
	Department department=null;
	try {
		ps=c.prepareStatement("select * from Department where department_id=?");
		ps.setInt(1,d.getDepartment_id());
		rs=ps.executeQuery();
		while(rs.next()) {
			department=new Department(rs.getInt(1),rs.getString(2),rs.getInt(3));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return department;
}
}



