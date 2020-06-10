package com.techlabs.input;

public class InputFactory {
	
	public static IInputReader createInputSource(InputReaders reader){
		if(reader.equals(InputReaders.FileInputReader)){
			return new ReadFromFile();
		}
		else if(reader.equals(InputReaders.DataBaseInputReader)){
			return new DBReader();
		}
		else{
			return null;
		}
	}

}
