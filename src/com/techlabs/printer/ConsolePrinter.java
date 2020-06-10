package com.techlabs.printer;

import com.techlabs.employee.Employee;

public class ConsolePrinter {

	public void print(Employee ceo, int tabLevel) {
		for (int i = 0; i < tabLevel; i++) {
			System.out.print("\t");
		}
		System.out.println("--> " + ceo.getEmployeeName());
		System.out.print(" ");

		for (Employee reporteeEmployee : ceo.getReporteeList()) {

			 System.out.println("");
			print(reporteeEmployee, tabLevel + 1);
		}
	}
}
