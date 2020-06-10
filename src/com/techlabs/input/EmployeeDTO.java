package com.techlabs.input;


public class EmployeeDTO {
	private String empID;
	private String empName;
	private String empManagerID;
	
	public EmployeeDTO(String currentEmpID,String currentEmpName,String currentManagerID){
		
		empID = currentEmpID;
		empName = currentEmpName;
		empManagerID = currentManagerID;		
	}

	public String getEmpID() {
		return empID;
	}

	public String getEmpName() {
		return empName;
	}

	public String getEmpManagerID() {
		return empManagerID;
	}

	@Override
	public String toString() {
		return "Data Transfer Object List :- [ID=" + empID + ", Name=" + empName
				+ ", ManagerID=" + empManagerID + "]";
	}
	
	
	

}
