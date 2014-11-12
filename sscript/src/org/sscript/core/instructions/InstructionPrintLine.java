package org.sscript.core.instructions;

import org.sscript.core.Instruction;

public class InstructionPrintLine implements Instruction{

	private String commandLine;
	
	@Override
	public boolean execute() {
		String literal = commandLine.split("\"")[1];
		literal = literal.replaceAll("\\\\n", "\n");
		literal = literal.replaceAll("\\\\t", "\t");
		System.out.println(literal);
		return true;
	}

	@Override
	public String getInstructionId() {
		return "plstr";
	}

	@Override
	public void setCommandInfo(String commandLine) {
		this.commandLine = commandLine;
	}

	@Override
	public Instruction getCopy() {
		InstructionPrintLine ipl = new InstructionPrintLine();
		ipl.setCommandInfo(commandLine);
		return ipl;
	}

}
