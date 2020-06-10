package com.techlabs.employee;

import java.util.ArrayList;
import java.util.List;

public class Employee {
	// Ivars
	private String employeeID;
	private String employeeName;
	private String employeeManagerID;
	private List<Employee> employeeReportee = new ArrayList<Employee>();

	// constrctor
	public Employee(String empID, String empName, List<Employee> reporteeList) {
		employeeID = empID;
		employeeName = empName;
		employeeReportee = reporteeList;
	}

	// Methods
	public void addReportee(Employee employeeToAdd) {
		employeeReportee.add(employeeToAdd);
	}

	public void removeReportee(Employee employeeToRemove) {
		if (!employeeReportee.isEmpty()) {
			if (employeeReportee.contains(employeeToRemove)) {
				employeeReportee.remove(employeeToRemove);
				System.out.println(employeeToRemove + " Removed.");
			}
		}
	}

	public void setEmployeeManagerID(String empManagerID) {
		employeeManagerID = empManagerID;
	}

	public String getEmployeeManagerID() {
		return employeeManagerID;
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String name){
		employeeName = name;
	}

	public List<Employee> getReporteeList() {
		return employeeReportee;
	}

	@Override
	public String toString() {
		return "[ID=" + employeeID + ", Name=" + employeeName
				+", Mgr Id="+employeeManagerID+"]";
	}

}
