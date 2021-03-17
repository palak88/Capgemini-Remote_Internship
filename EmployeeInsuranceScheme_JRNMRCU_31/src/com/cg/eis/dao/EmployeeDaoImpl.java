package com.cg.eis.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.cg.eis.bean.Employee;
import com.cg.eis.exception.EmployeeIdException;
import com.cg.eis.validation.EmployeeIdValidation;


//Implementation class for Employee Data Access Object Layer 
public class EmployeeDaoImpl implements IEmployeeDao {
	
	private static Map<Integer,Employee> employees;
	private static int origin = 1004;
	
	static {
		employees = new HashMap<Integer,Employee> ();
	}

	//method to add employee details to hashmap
	@Override
	public boolean addEmployee(Employee employee) {
		
		int initialSize = employees.size();
		Employee emp1 = new Employee(1000,"ABC",200000.00,"Manager","Scheme A");
		Employee emp2 = new Employee(1001,"DEF", 25000.00,"Programmer","Scheme B");
		Employee emp3 = new Employee(1002,"GHI",6000.00,"System Associate","Scheme C");
		Employee emp4 = new Employee(1003,"JKL",2000.00,"Clerk","No Scheme");
		employees.put(1000, emp1);
		employees.put(1001, emp2);
		employees.put(1002, emp3);
		employees.put(1003, emp4);
		employees.put(origin++, employee);
		
		if (employees.size() > initialSize)
			return true;
		else
			return false;
	}

	//method to delete an employee's details from hashmap
	@Override
	public boolean delete(int employeeId) {
		try {
			EmployeeIdValidation.validateEmployeeId(employeeId);
		}
		catch(EmployeeIdException emp) {
			System.out.println(emp);
		}
		
		for(Entry<Integer, Employee> i:employees.entrySet()) {
			if(i.getKey() == employeeId) {
				employees.remove(employeeId);
				return true;
			}
		}
		return false;
	}

	//method to return a list of all employees
	@Override
	public List<Employee> getAllEmployee() {
		if(employees != null) {
			Collection<Employee> employeeValues = employees.values();
			List<Employee> employeeList = new ArrayList<Employee>(employeeValues);
			return employeeList;
		}
		return null;
	}

}
