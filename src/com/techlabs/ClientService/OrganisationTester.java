package com.techlabs.ClientService;

import com.techlabs.input.InputReaders;

public class OrganisationTester {

	public static void main(String[] args) {
	ConsolePrintService printer = new ConsolePrintService();
	printer.printToConsole(InputReaders.FileInputReader);

	}

}
