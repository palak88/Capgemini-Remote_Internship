package com.cg.eis.service;

import java.util.ArrayList;
import java.util.List;

import com.cg.eis.bean.Employee;
import com.cg.eis.dao.EmployeeDaoImpl;
import com.cg.eis.dao.IEmployeeDao;

//Implementation class of Employee Service Layer
public class EmployeeServiceImpl implements IEmployeeService{
	
	private static IEmployeeDao employeeDao = new EmployeeDaoImpl();

	//method to add employee based on the salary
	@Override
	public boolean addEmployee(Employee employee) {
		
		if(employee.getSalary()>0.00) {
			
			String scheme = new String();
			String designation = new String();
			
			if((employee.getSalary()>5000.00) && (employee.getSalary()<20000.00)) {
				scheme = "Scheme C";
				designation = "System Associate";
			}
			
			else if((employee.getSalary()>20000.00) && (employee.getSalary()<40000.00)){
				scheme = "Scheme B";
				designation = "Programmer";
			}
			
			else if(employee.getSalary()>40000.00) {
				scheme = "Scheme A";
				designation = "Manager";
			}
			
			else if (employee.getSalary()>0.00){
				scheme = "No Scheme";
				designation = "Clerk";
			}
			
			employee.setInsuranceScheme(scheme);
			employee.setDesignation(designation);
			
			return employeeDao.addEmployee(employee);
		}
		else
			return false;
	}

	//method to delete employee details by getting employee id from user
	@Override
	public boolean delete(int employeeId) {
		return employeeDao.delete(employeeId);
	}

	//method to return list of details of employees based on the chosen insurance scheme
	@Override
	public List<Employee> getEmployee(int schemeChoice) {
		
		if(schemeChoice>0) {
			
			List<Employee> employeeList = employeeDao.getAllEmployee();
			List<Employee> employeeSchemeList = new ArrayList<Employee>();
			
			for(Employee i:employeeList) {
				if((schemeChoice == 1) && (i.getInsuranceScheme() == "Scheme A")) {
					employeeSchemeList.add(i);
				}
				
				else if ((schemeChoice == 2) && (i.getInsuranceScheme() == "Scheme B")) {
					employeeSchemeList.add(i);
				}
				
				else if((schemeChoice == 3) && (i.getInsuranceScheme() == "Scheme C")) {
					employeeSchemeList.add(i);
				}
				
				else if((schemeChoice == 4) && (i.getInsuranceScheme() == "No Scheme")) {
					employeeSchemeList.add(i);
				}
				
				else if(schemeChoice > 4) {
					return null;
				}
			}
			return employeeSchemeList;
		}
		else{
			
			return null;
		}
	}

}
