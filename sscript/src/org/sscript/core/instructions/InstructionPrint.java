package org.sscript.core.instructions;

import java.util.Set;

import org.sscript.core.Instruction;
import org.sscript.core.Module;
import org.sscript.exceptions.RuntimeException;

public class InstructionPrint implements Instruction{
	
	private String commandInfo;
	
	@Override
	public boolean execute(Module m) throws RuntimeException {
		try{
			String varTest = commandInfo.substring(7, commandInfo.length());
			Set keyset = m.getMemoryMap().keySet();
			for(Object o : keyset){
				if(o.toString().equals(varTest)){
					System.out.print(m.getMemoryMap().get(o));
				}
			}
			String literal = commandInfo.split("\"")[1];
			literal = literal.replaceAll("\\\\n", "\n");
			literal = literal.replaceAll("\\\\t", "\t");
			System.out.print(literal);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(commandInfo, "Error in " + getInstructionId() + " statement.");
		}
	}

	@Override
	public String getInstructionId() {
		return InstructionKeywords.instructionPrint;
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
