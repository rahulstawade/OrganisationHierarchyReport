package com.techlabs.ClientService;

import java.util.List;

import com.techlabs.employee.Employee;
import com.techlabs.input.EmployeeDTO;
import com.techlabs.input.IInputReader;
import com.techlabs.input.InputFactory;
import com.techlabs.input.InputReaders;
import com.techlabs.organisation.Organisation;
import com.techlabs.printer.ConsolePrinter;

public class ConsolePrintService {

	public void printToConsole(InputReaders inputSource) {
		IInputReader reader = InputFactory.createInputSource(inputSource);
		List<EmployeeDTO> inputList = reader.readDataTransferObject();
		Organisation organisationObject = new Organisation(inputList);
		Employee ceo = organisationObject.createHeirarchy();
		ConsolePrinter printer = new ConsolePrinter();
		printer.print(ceo,0);

	}

}
