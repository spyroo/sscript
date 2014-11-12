package org.sscript.exceptions;

public class RuntimeException extends Exception{

	private static final long serialVersionUID = 7886467925895428172L;
	
	public RuntimeException(String line, String error){
		super("Runtime excpetion on line \'" + line + "\'\n\twith error \'" + error + "\'");
	}
	
}
