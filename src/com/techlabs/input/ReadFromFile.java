package com.techlabs.input;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFromFile implements IInputReader {

	@Override
	public List<EmployeeDTO> readDataTransferObject() {

		List<EmployeeDTO> dtolist = new ArrayList<EmployeeDTO>();

		FileReader file = null;
		try {
			file = new FileReader("EmployeeData.txt");
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		BufferedReader br = new BufferedReader(file);
		String line;
		try {
			while ((line = br.readLine()) != null) {

				String[] tokens = line.split("/");
				
				/*System.out.println(tokens[0]);
				System.out.println(tokens[1]);
				System.out.println(tokens[2]);*/

				EmployeeDTO dtoobject = new EmployeeDTO(tokens[0], tokens[1],
						tokens[2]);
				dtolist.add(dtoobject);
				// System.out.println(DTOlist.size());
			}

		} catch (IOException e) {

			e.printStackTrace();
		}

		try {
			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return dtolist;
	}

}
