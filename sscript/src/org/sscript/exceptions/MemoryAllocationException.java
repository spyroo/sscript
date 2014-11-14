package org.sscript.exceptions;

public class MemoryAllocationException extends Exception{
	
	private static final long serialVersionUID = 5663687118034475244L;

	public MemoryAllocationException(){
		super("Error when allocating memory.");
	}
	
}
