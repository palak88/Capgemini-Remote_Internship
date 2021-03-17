package com.cg.eis.dao;

//Interface for Employee Data Access Object Layer
import java.util.List;

import com.cg.eis.bean.Employee;

public interface IEmployeeDao {
	
	public boolean addEmployee(Employee employee);
	
	public boolean delete(int employeeId);
	
	public List<Employee> getAllEmployee ();
}
