package com.kce.Employee.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.kce.Employee.bean.EmployeeBean;
import com.kce.Employee.bean.Department;
import com.kce.Employee.bean.Company;
import com.kce.Employee.dao.EmployeeDAO;
import com.kce.Employee.dao.DepartmentDAO;
import com.kce.Employee.dao.CompanyDAO;

public class TestEmployee {
     
public static void main(String[] args) {
		
		Scanner bm=new Scanner(System.in);
		System.out.println("\t\t\tWelcome to Employee Management System\t\t\t\n");
		while(true) {
			System.out.println("press 1 for Employee Details");
			System.out.println("press 2 for Department Details");
			System.out.println("press 3 for Company Details");
			System.out.println("Press 4 for Quit");
			int n=bm.nextInt();
			switch(n) {
			case 1:
				while(true) {
					System.out.println("\npress 1 for Add Customer");
					System.out.println("Press 2 for Delete Customer");
					System.out.println("Press 3 for Update Customer");
					System.out.println("Press 4 for View all customer details");
					System.out.println("Press 5 for view one Customer");
					System.out.println("Press 6 for Quit\n");
					int x=bm.nextInt();
					switch(x) {
					case 1:
				System.out.println("Please enter Employee Details:");
				System.out.println("Enter Employee Id");
				int Eid=bm.nextInt();
				bm.nextLine();
				System.out.println("Enter Employee name");
				String Ename=bm.nextLine();
				System.out.println("Enter Employee salary");
				double Esal=bm.nextDouble();
				System.out.println("Enter Employee age");
				int Eage=bm.nextInt();
				bm.nextLine();
			    System.out.println("Enter Employee department id: ");
			    int EDid=bm.nextInt();
				EmployeeBean emp=new EmployeeBean();
				emp.setEmployee_id(Eid);
				emp.setName(Ename);
				emp.setSalary(Esal);
				emp.setAge(Eage);
				emp.setDepartment_id(Eid);
				if(EmployeeDAO.addEmployee(emp))
					System.out.println("\nCustomer details were added sucessfully\n\n");
				else System.out.println("\nCustomer already exist\n\n");
				break;
			case 2:
				System.out.println("Enter employee id to delete");
				int id1=bm.nextInt();
				bm.nextLine();
				EmployeeBean emp1=new EmployeeBean();
				emp1.setEmployee_id(id1);
				if(EmployeeDAO.deleteEmployee(emp1))
					System.out.println("\nemployee  deleted sucessfully\n\n");
				else System.out.println("\nThere is no employee with this Id\n\n");
				break;
			case 3:
				System.out.println("press 1 to update Employeesalary");
				System.out.println("Press 2 to update update Employee Age\n\n");
				int i=bm.nextInt();
				if(i==1) {
					System.out.println("Enter Employee id");
					int id2=bm.nextInt();
					bm.nextLine();
					System.out.println("Enter Employee Salary");
					int loc=bm.nextInt();
					EmployeeBean e1=new EmployeeBean();
					e1.setEmployee_id(id2);
					e1.setSalary(loc);
					if(EmployeeDAO.updateEmployeesalary(e1))
						System.out.println("\nEmployee Salary updated sucessfully\n\n");
					else System.out.println("\nThere is no Employee with this Id\n\n");
				}
				else if(i==2) {
					System.out.println("Enter Employee id");
					int id2=bm.nextInt();
					bm.nextLine();
					System.out.println("Enter Employee Age");
					int num=bm.nextInt();
					EmployeeBean e1=new EmployeeBean();
					e1.setEmployee_id(id2);
					e1.setAge(num);
					if(EmployeeDAO.updateEmployeeage(e1))
						System.out.println("\nEmployee Age updated sucessfully\n\n");
					else System.out.println("\nThere is no customer with this Id\n\n");
				}
				break;
			case 4:
				List<EmployeeBean> list=new ArrayList<>();
				list=EmployeeDAO.viewAllEmployee();
				for(EmployeeBean empt:list) {
					System.out.println(empt);
				}
				break;
			case 5:
				System.out.println("Enter Employee Id");
				int id3=bm.nextInt();
				EmployeeBean e1=new EmployeeBean();
				e1.setEmployee_id(id3);
				EmployeeBean e2=new EmployeeBean();
				e2=EmployeeDAO.viewOneEmployee(e1);
				System.out.println(e2);
				break;
		}
		if(x==6) break;
	}
	break;
case 2:
	while(true) {
		System.out.println("\npress 1 for Add Department");
		System.out.println("Press 2 for Delete Department");
		System.out.println("Press 3 for Update DepartmentID");
		System.out.println("Press 4 for View all Department");
		System.out.println("Press 5 for view one Department");
		System.out.println("Press 6 for Quit\n\n");
		int x=bm.nextInt();
		switch(x) {
		case 1:
			System.out.println("Please enter Employee Details:");
			System.out.println("Enter Department Id");
			int depid=bm.nextInt();
			bm.nextLine();
			System.out.println("Enter Department Name");
			String depname=bm.nextLine();
			System.out.println("Enter Employee ID");
			int empid=bm.nextInt();
			Department d=new Department();
			d.setDepartment_id(depid);
			d.setDepartment_name(depname);
			d.setEmployee_id(empid);
			if(DepartmentDAO.addDepartment(d))
				System.out.println("\nDepartment details were added sucessfully\n\n");
			else System.out.println("\nDepartment are already exist\n\n");
			break;
		case 2:
			System.out.println("Enter Department id to delete");
			int id1=bm.nextInt();
			bm.nextLine();
			Department d1=new Department();
			d1.setDepartment_id(id1);
			if(DepartmentDAO.deleteDepartment(d1))
				System.out.println("\nDepartment deleted sucessfully\n\n");
			else System.out.println("\nThere is no Department with this Id\n\n");
			break;
		case 3:
			System.out.println("press 1 to update Department ID");
			System.out.println("Press 2 to update Department Name\n\n");
			int i=bm.nextInt();
			if(i==1) {
				System.out.println("Enter Employee id");
				int id2=bm.nextInt();
				bm.nextLine();
				System.out.println("Enter Department ID ");
				int cost1=bm.nextInt();
				Department d2=new Department();
				d2.setEmployee_id(id2);
				d2.setDepartment_id(cost1);
				if(DepartmentDAO.updateDepartmentID(d2))
					System.out.println("\nDepartment ID updated sucessfully\n\n");
				else System.out.println("\nThere is no Employee with this Id\n\n");
			}
			else if(i==2) {
				System.out.println("Enter Employee id");
				int id2=bm.nextInt();
				bm.nextLine();
				System.out.println("Enter Department Name");
				String deptname=bm.nextLine();
				Department d2=new Department();
				d2.setEmployee_id(id2);
				d2.setDepartment_name(deptname);
				if(DepartmentDAO.updateDepartmentName(d2))
					System.out.println("\nDepartment Name updated sucessfully\n\n");
				else System.out.println("\nThere is no Employee with this Id\n\n");
			}
			break;
		case 4:
			List<Department> list=new ArrayList<>();
			list=DepartmentDAO.viewAllDepartment();
			for(Department dept:list) {
				System.out.println(dept);
			}
			break;
		case 5:
			System.out.println("Enter Department Id");
			int id3=bm.nextInt();
			Department d2=new Department();
			d2.setDepartment_id(id3);
			Department d3=new Department();
			d3=DepartmentDAO.viewOneDepartment(d2);
			System.out.println(d3);
			break;
	}
	if(x==6) break;
}
break;
case 3:
	while(true) {
		System.out.println("\npress 1 for Add Company");
		System.out.println("Press 2 for Delete Company");
		System.out.println("Press 3 for Update Comany Address");
		System.out.println("Press 4 for View all Company");
		System.out.println("Press 5 for view one Company");
		System.out.println("Press 6 for Quit\n\n");
		int x=bm.nextInt();
		switch(x) {
		case 1:
			System.out.println("Please enter Company Details:");
			System.out.println("Enter Company Id");
			int id=bm.nextInt();
			bm.nextLine();
			System.out.println("Enter Company name");
			String name=bm.nextLine();
			System.out.println("Enter Company Address");
			String add=bm.nextLine();
			Company c=new Company();
			c.setCompany_id(id);
			c.setCompany_name(name);
			c.setCompany_address(add);
			if(CompanyDAO.addCompany(c))
				System.out.println("\nCompany details were added sucessfully\n\n");
			else System.out.println("\nCompany are already exist\n\n");
			break;
		case 2:
			System.out.println("Enter Company id to delete");
			int id1=bm.nextInt();
			bm.nextLine();
			Company c1=new Company();
			c1.setCompany_id(id1);
			if(CompanyDAO.deleteCompany(c1))
				System.out.println("\nCompany deleted sucessfully\n\n");
			else System.out.println("\nThere is no Company with this Id\n\n");
			break;
		case 3:
			System.out.println("press 1 to update Company Address");
			int i=bm.nextInt();
			if(i==1) {
				System.out.println("Enter Company id");
				int id2=bm.nextInt();
				bm.nextLine();
				System.out.println("Enter Company Address");
				String quan1=bm.nextLine();
				Company s2=new Company();
				s2.setCompany_id(id2);
				s2.setCompany_address(quan1);
				if(CompanyDAO.updateCompanyAddress(s2))
					System.out.println("\nCompany Address updated sucessfully\n\n");
				else System.out.println("\nThere is no Company ID with this Id\n\n");
			}
			break;
		case 4:
			List<Company> list=new ArrayList<>();
			list=CompanyDAO.viewAllCompany();
			for(Company comp:list) {
				System.out.println(comp);
			}
			break;
		case 5:
			System.out.println("Enter Company Id");
			int id3=bm.nextInt();
			Company s2=new Company();
			s2.setCompany_id(id3);
			Company s3=new Company();
			s3=CompanyDAO.viewOneCompany(s2);
			System.out.println(s3);
			break;
	}
	if(x==6) break;
}
break;
	}
		System.out.println("\t\t\tThank you for using our service\t\t\t");
}
}
}

