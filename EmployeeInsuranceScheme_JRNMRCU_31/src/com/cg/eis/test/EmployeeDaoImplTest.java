package com.cg.eis.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cg.eis.bean.Employee;
import com.cg.eis.dao.EmployeeDaoImpl;
import com.cg.eis.dao.IEmployeeDao;

//Test Cases for EmployeeDaoImp.java
class EmployeeDaoImplTest {
	IEmployeeDao employeeDao;
	Employee emp;
	Map<Integer,Employee> employees;

	@BeforeEach
	void setUp() throws Exception {
		employeeDao = new EmployeeDaoImpl();
		emp = new Employee();
		employees = new HashMap<Integer,Employee>();
	}

	@AfterEach
	void tearDown() throws Exception {
		employeeDao = null;
		emp = null;
	}
	
	@Test
	void testAddEmployee() {
		emp.setId(1001);
		emp.setName("ABCD");
		emp.setDesignation("Manager");
		emp.setSalary(200000.00);
		emp.setInsuranceScheme("Scheme A");
		
		boolean result = employeeDao.addEmployee(emp);
		assertEquals(true,result);
	}
	
	@Test
	void testDeleteEmployee() {
		emp = new Employee(1001,"ABCD", 250000.00, "Manager", "Scheme A");
		employees.put(1001, emp);
		
		boolean result = employeeDao.delete(1001);
		assertEquals(true,result);
	}
	
}
