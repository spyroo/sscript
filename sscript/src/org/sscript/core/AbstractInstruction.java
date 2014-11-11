package org.sscript.core;

public class AbstractInstruction implements Instruction{

	private String instructionId;
	
	public AbstractInstruction(String instructionId){
		this.instructionId = instructionId;
	}
	
	@Override
	public boolean execute() {
		return false;
	}

	@Override
	public String getInstructionId() {
		return instructionId;
	}
	

}
