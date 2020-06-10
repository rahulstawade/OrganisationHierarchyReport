package com.techlabs.organisation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.techlabs.employee.Employee;
import com.techlabs.input.EmployeeDTO;

public class Organisation {

	// Ivars
	private Map<String, Employee> employeeMap = new HashMap<String, Employee>();
	private List<EmployeeDTO> inputList = new ArrayList<EmployeeDTO>();

	// Constructor
	public Organisation(List<EmployeeDTO> inputList) {
		this.inputList = inputList;

	}

	// Methods
	public Employee createHeirarchy() {
		//List<Employee> reporteeListFinal = new ArrayList<Employee>();
		// Employee employee = new Employee("", "", reporteeList);
		Employee ceo;
		

		for (EmployeeDTO currentEmp : inputList) {
			// System.out.println("id :"+currentEmp.getEmpID()+" name :"+currentEmp.getEmpName()+" ReporteeList :"+reporteeList);
			List<Employee> reporteeList = new ArrayList<Employee>();
			Employee employee = new Employee(currentEmp.getEmpID(),
					currentEmp.getEmpName(), reporteeList);
			employee.setEmployeeManagerID(currentEmp.getEmpManagerID());
			// System.out.println(employee);

			if (!employeeMap.containsKey(employee.getEmployeeID())) {
				employeeMap.put(employee.getEmployeeID(), employee);
			} else if (employeeMap.containsKey(employee.getEmployeeID())) {
				// here we enter the correct values for our dummy employee
				// created
				List<Employee> reporteeList1 = (employeeMap.get(employee
						.getEmployeeID())).getReporteeList();
				for (Employee reportee : reporteeList1) {
					employee.addReportee(reportee);
				}
				
				(employeeMap.get(employee.getEmployeeID()))
						.setEmployeeManagerID(employee.getEmployeeManagerID());
				(employeeMap.get(employee.getEmployeeID()))
						.setEmployeeName(employee.getEmployeeName());
			}

			// checking if Manager is present :
			// if present employee will be aaded to manager's reportee List.

			if (employeeMap.containsKey(employee.getEmployeeManagerID())) {
				(employeeMap.get(employee.getEmployeeManagerID()))
						.addReportee(employee);

				//reporteeList = employee.getReporteeList();
			}
			// if Manager Not present the create dummy employee whoz EmpID is
			// same as Employee's Manager ID.

			else /* (!employeeMap.containsKey(employee.getEmployeeManagerID())) */{
				List<Employee> dummyList = new ArrayList<Employee>();
				 //dummyEmployee = new Employee(" ", " ", dummyList);
				 Employee dummyEmployee = new Employee(employee.getEmployeeManagerID(),
						" ", dummyList);
				dummyEmployee.addReportee(employee);
				employeeMap.put(dummyEmployee.getEmployeeID(), dummyEmployee);

			}

		}

		// System.out.println(employeeMap);
		/*for (Map.Entry<String, Employee> re : employeeMap.entrySet()) {
			System.out.println("Key:- " + re.getKey() + " Employee :- id - "
					+ re.getValue().getEmployeeID() + ", name -"
					+ re.getValue().getEmployeeName() + ", mgrId - "
					+ re.getValue().getEmployeeManagerID());

		}*/
	/*	System.out.println("Reportees of 101:-"+(employeeMap.get("101")).getReporteeList());
		System.out.println("Reportees of 102:-"+(employeeMap.get("102")).getReporteeList());
		System.out.println("Reportees of 202:-"+(employeeMap.get("00")).getReporteeList());
		System.out.println("Reportees of 01:-"+(employeeMap.get("01")).getReporteeList());
		System.out.println("+++++++++++++++==============++++++++++++++++");*/
		ceo = (employeeMap.get("01"));
		return ceo;

	}

}
