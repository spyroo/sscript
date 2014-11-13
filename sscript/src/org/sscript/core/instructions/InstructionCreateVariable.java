package org.sscript.core.instructions;

import org.sscript.core.Instruction;
import org.sscript.exceptions.RuntimeException;

public class InstructionCreateVariable implements Instruction{

	private String commandInfo;
	
	@Override
	public boolean execute() throws RuntimeException {
		return false;
	}

	@Override
	public String getInstructionId() {
		return InstructionKeywords.instructionCreateVar;
	}

	@Override
	public void setCommandInfo(String commandLine) {
		this.commandInfo = commandLine;
	}

	@Override
	public Instruction getCopy() {
		InstructionCreateVariable icv = new InstructionCreateVariable();
		return icv;
	}
	
}
