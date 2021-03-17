package com.cg.eis.validation;


import com.cg.eis.exception.EmployeeIdException;

//Administrator validation class
public class EmployeeIdValidation {
	
	
	
	public static void validateEmployeeId(int employeeId) throws EmployeeIdException {
		Integer empId = new Integer(employeeId);
		if(empId.getClass() != Integer.class) {
			throw new EmployeeIdException("Invalid input");
		}
	}

}
