package org.sscript.core;

public class Instruction {
	
	private String commandLine;
	
	public Instruction(){
		
	}
	
	public Instruction(Instruction i){
		this.commandLine = i.getCommandInfo();
		System.out.println(i.getCommandInfo());
	}
	
	public boolean execute() {
		return false;
	}
	
	public String getInstructionId() {
		return null;
	}
	
	public void setCommandInfo(String commandLine) {
		this.commandLine = commandLine;
	}
	
	protected String getCommandInfo(){
		return commandLine;
	}
	
}
