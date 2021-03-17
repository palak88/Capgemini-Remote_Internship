package com.cg.eis.service;

import java.util.List;

import com.cg.eis.bean.Employee;

//Interface for Employee Service Layer
public interface IEmployeeService {
	
	boolean addEmployee(Employee employee);
	
	boolean delete(int employeeId);
	
	List<Employee> getEmployee (int schemeChoice);

}
