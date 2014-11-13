package org.sscript.exceptions;

import java.io.File;

public class UnrecognizedFiletypeException extends Exception{

	private static final long serialVersionUID = 6719237561379846632L;
	
	public UnrecognizedFiletypeException(File incorrectFile){
		super("File " + incorrectFile.getName() + " is not a valid sscript file.");
	}

}
