package org.sscript.core.instructions;

import org.sscript.core.Instruction;
import org.sscript.core.Module;
import org.sscript.exceptions.RuntimeException;

public class InstructionPrintLine implements Instruction{

	private String commandLine;
	
	@Override
	public boolean execute(Module m) throws RuntimeException {
		try{
			if(!commandLine.contains("\"")){
				System.out.print(m.getMemoryMap().get(commandLine.split(" ")[1]));
				return true;
			}
			String literal = commandLine.split("\"")[1];
			literal = literal.replaceAll("\\\\n", "\n");
			literal = literal.replaceAll("\\\\t", "\t");
			System.out.println(literal);
			return true;
		}catch(Exception e){
			throw new RuntimeException(commandLine, "Error in " + getInstructionId() + " statement.");
		}
	}

	@Override
	public String getInstructionId() {
		return InstructionKeywords.instructionPrintLine;
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
