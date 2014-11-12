package org.sscript.core.instructions;

import org.sscript.core.Instruction;

public class InstructionPrint extends Instruction{
	
	
	@Override
	public boolean execute() {
		String literal = super.getCommandInfo().split("\"")[1];
		System.out.print(literal.replaceAll("\\n", "\n").replaceAll("\\t", "\t"));
		return false;
	}

	@Override
	public String getInstructionId() {
		return "print";
	}

}
