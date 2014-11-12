package org.sscript.core;

public class Instruction {
	
	private String commandLine;
	private String instructionId;
	
	public Instruction(){
		
	}
	
	public Instruction(Instruction i){
		this.commandLine = i.getCommandInfo();
		this.instructionId = i.getInstructionId();
	}
	
	public boolean execute() {
		return false;
	}
	
	public String getInstructionId() {
		return instructionId;
	}
	
	public void setCommandInfo(String commandLine) {
		this.commandLine = commandLine;
	}
	
	protected String getCommandInfo(){
		return commandLine;
	}
	
}
