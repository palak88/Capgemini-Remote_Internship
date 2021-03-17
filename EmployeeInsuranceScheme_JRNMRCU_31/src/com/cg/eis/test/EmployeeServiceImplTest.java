package com.cg.eis.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cg.eis.bean.Employee;
import com.cg.eis.service.EmployeeServiceImpl;
import com.cg.eis.service.IEmployeeService;

//Test cases for EmployeeServiceImpl.java
class EmployeeServiceImplTest {
	
	IEmployeeService employeeService;
	Employee emp;
	
	@BeforeEach
	void setUp() throws Exception {
		employeeService = new EmployeeServiceImpl();
		emp = new Employee();
	}

	@AfterEach
	void tearDown() throws Exception {
		employeeService = null;
		emp = null;
	}


	@Test
	void testAddEmployeeTestSalary() {
		emp.setId(1001);
		emp.setName("ABCD");
		emp.setDesignation("Manager");
		emp.setSalary(200000.00);
		
		boolean result = employeeService.addEmployee(emp);
		assertEquals(true, result);
	}
	
	
	@Test
	void testAddEmployeeTestForNegativeSalary() {
		emp.setId(1003);
		emp.setName("ABCDE");
		emp.setDesignation("Clerk");
		emp.setSalary(-2000.00);
		
		boolean result = employeeService.addEmployee(emp);
		assertEquals(false, result);
	}
	
	@Test
	void testAddEmployeeTestForZeroSalary() {
		emp.setId(1003);
		emp.setName("ABCDE");
		emp.setDesignation("Clerk");
		emp.setSalary(0.00);
		
		boolean result = employeeService.addEmployee(emp);
		assertEquals(false, result);
	}
	
	@Test
	void testGetEmployeeForChoiceZero() {
		int sc = 0;
		List<Employee> empList = employeeService.getEmployee(sc);
		assertEquals(null,empList);
	}
	
	@Test
	void testGetEmployeeForNegativeChoice() {
		int sc = -2;
		List<Employee> empList = employeeService.getEmployee(sc);
		assertEquals(null,empList);
	}
	
	@Test
	void testGetEmployeeForGreaterChoice() {
		int sc = 6;
		List<Employee> empList = employeeService.getEmployee(sc);
		assertEquals(null,empList);
	}
}
