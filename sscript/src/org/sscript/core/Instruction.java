package org.sscript.core;

import org.sscript.exceptions.RuntimeException;

public interface Instruction {
	
	public boolean execute() throws RuntimeException ;
	public String getInstructionId();
	public void setCommandInfo(String commandLine);
	public Instruction getCopy();
	
}
