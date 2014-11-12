package org.sscript.core;

public interface Instruction {
	
	public boolean execute();
	public String getInstructionId();
	public void setCommandInfo(String commandLine);
	public Instruction getCopy();
	
}
