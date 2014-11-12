package org.sscript.core.instructions;

import org.sscript.core.Instruction;

public class InstructionPrint implements Instruction{
	
	private String commandInfo;
	
	@Override
	public boolean execute() {
		String literal = commandInfo.split("\"")[1];
		literal = literal.replaceAll("\\\\n", "\n");
		literal = literal.replaceAll("\\\\t", "\t");
		System.out.print(literal);
		return false;
	}

	@Override
	public String getInstructionId() {
		return "pstr";
	}

	@Override
	public void setCommandInfo(String commandLine) {
		this.commandInfo = commandLine;
	}

	@Override
	public Instruction getCopy() {
		InstructionPrint ip = new InstructionPrint();
		ip.setCommandInfo(commandInfo);
		return ip;
	}

}
