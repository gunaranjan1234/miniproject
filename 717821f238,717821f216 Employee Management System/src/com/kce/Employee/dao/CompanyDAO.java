package com.kce.Employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kce.Employee.bean.Company;
import com.kce.Employee.util.DBconnection;

public class CompanyDAO {

	static PreparedStatement ps;
	static Connection c=DBconnection.getConnection();
	static ResultSet rs;
	
	public static boolean addCompany(Company co) {
		try {
			ps=c.prepareStatement("select company_id from Company");
			rs=ps.executeQuery();
			int count=0;
			while(rs.next()) {
				if(rs.getInt(1)==co.getCompany_id()) count++;
			}
			if(count==0) {
				ps=c.prepareStatement("insert into Company values(?,?,?)");
				ps.setString(1,co.getCompany_name());
				ps.setInt(2,co.getCompany_id());
				ps.setString(3,co.getCompany_address());
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
public static boolean deleteCompany(Company co) {
	try {
		ps=c.prepareStatement("select company_id from Company");
		rs=ps.executeQuery();
		int count=0;
		while(rs.next()) {
			if(rs.getInt(1)==co.getCompany_id()) count++;
		}
		if(count==0) return false;
		else {
			ps=c.prepareStatement("delete from Company where company_id=?");
			ps.setInt(1, co.getCompany_id());
			ps.execute();
			return true;
		}
	}catch(SQLException e) {
		System.out.println(e);
	}
	return false;
}
public static boolean updateCompanyAddress(Company co) {
	try {
		ps=c.prepareStatement("select company_id from Company");
		rs=ps.executeQuery();
		int count=0;
		while(rs.next()) {
			if(rs.getInt(1)==co.getCompany_id()) count++;
		}
		if(count==0) return false;
		else {
			ps=c.prepareStatement("update Company set company_address=? where company_id=?");
			ps.setString(1, co.getCompany_address());
			ps.setInt(2, co.getCompany_id());
			ps.execute();
			return true;
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return false;
}
public static List<Company> viewAllCompany() {
	List<Company> list=new ArrayList<>();
	try {
		ps=c.prepareStatement("select * from Company");
		rs=ps.executeQuery();
		while(rs.next()) {
			list.add(new Company(rs.getString(1),rs.getInt(2),rs.getString(3)));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return list;
}
public static Company viewOneCompany(Company co) {
	Company comp=null;
	try {
		ps=c.prepareStatement("select * from Company where company_id=?");
		ps.setInt(1,co.getCompany_id());
		rs=ps.executeQuery();
		while(rs.next()) {
			comp=new Company(rs.getString(1),rs.getInt(2),rs.getString(3));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return comp;
}
}


