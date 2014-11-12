package org.sscript.exceptions;

public class UnrecognizedSyntaxException extends Exception{

	private static final long serialVersionUID = 3990778712719315505L;
	
	public UnrecognizedSyntaxException(String invalidLine){
		super("Invalid syntax on line> " + invalidLine);
	}

}
