package org.sscript.exceptions;

public class CompiletimeException extends Exception{

	private static final long serialVersionUID = 8101984321500843104L;
	
	public CompiletimeException(int lineNum){
		super("An excpetion has occured at compiletime when compiling line " + lineNum);
	}
	
}
