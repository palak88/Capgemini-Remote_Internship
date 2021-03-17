package com.cg.eis.pl;

import java.util.List;
import java.util.Scanner;

import com.cg.eis.bean.Employee;
import com.cg.eis.exception.EmployeeIdException;
import com.cg.eis.service.EmployeeServiceImpl;
import com.cg.eis.service.IEmployeeService;
import com.cg.eis.util.InputUtil;
import com.cg.eis.validation.EmployeeIdValidation;

//Main Controller Class
public class MainController {
	
	private static IEmployeeService employeeService = new EmployeeServiceImpl();
	
	public static void main(String[] args) throws EmployeeIdException {

		runApplication();

	}
	
	//method to start running the application
	public static void runApplication() throws EmployeeIdException {
		Scanner scanner = InputUtil.getScanner();
			boolean status = true;
			Employee employee = new Employee();
			
			while (status) {
				
				System.out.println("---Welcome to Employee operations---");
				System.out.println("1. Add Employee Details \n2. Display Employees according to Insurance Scheme\n3. Delete Employee Details \n4. Exit");
				System.out.println("enter your choice:");
				int choice = scanner.nextInt();
				
				switch (choice) {
				
				//accept employee details from user and send to EmployeeServiceImpl.java
				case 1:
					
					employee = readEmployeeInfo();
					if (employeeService.addEmployee(employee)) {
						System.out.println("employee added with " + employee.getId() + " successfully.!");
					} else {
						System.out.println("employee not added.!");
					}
					break;
					
				//accept scheme choice from user and send to EmployeeServiceImpl.java	
				case 2:
					
					System.out.println("Enter insurance scheme choice number 1.Scheme A, 2. Scheme B, 3. Scheme C, 4. No Scheme");
					int schemeChoice = scanner.nextInt();
					List<Employee> list = employeeService.getEmployee(schemeChoice);
					if(list.isEmpty()) {
						System.out.println("No employees in this scheme");
					}
					for(Employee i:list) {
						System.out.println(i);
					}
					break;
					
				//accept employee id from user and send to EmployeeServiceImpl.java	
				case 3:
					
					System.out.println("Enter employee id:");
						int id  = scanner.nextInt();
						EmployeeIdValidation.validateEmployeeId(id);
					if(employeeService.delete(id)) {
						System.out.println("Employee details deleted sucessfully.!");
					}
					else {
						System.out.println("Cannot delete employee");
					}
					break;
					
				//Exit application	
				case 4:
					System.out.println("-----Exiting System Thank You..!-----");
					status = false;
					System.exit(0);
				}
			}
			
		}

	
	//method to read employee details from user
	private static Employee readEmployeeInfo() {

		Scanner scanner = InputUtil.getScanner();
		System.out.println("Enter employ name and salary");
		String name = scanner.nextLine();
		String salaryStr = scanner.nextLine();
		double salary = Double.parseDouble(salaryStr);

		return new Employee(name, salary);
	}
	
}
