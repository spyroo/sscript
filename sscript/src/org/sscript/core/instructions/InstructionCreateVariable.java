package org.sscript.core.instructions;


import org.sscript.core.Instruction;
import org.sscript.core.Module;
import org.sscript.exceptions.MemoryAllocationException;
import org.sscript.exceptions.RuntimeException;

public class InstructionCreateVariable implements Instruction{

	private String commandInfo;
	
	public InstructionCreateVariable(String commandLine) {
		this.commandInfo = commandLine;
	}
	
	public InstructionCreateVariable() {
	}

	@Override
	public boolean execute(Module m) throws RuntimeException {
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
		InstructionCreateVariable icv = new InstructionCreateVariable(commandInfo);
		return icv;
	}
	
	public String getVariableName(){
		String[] splitLine = commandInfo.split(" ");
		return splitLine[2];
	}
	
	public Object getVariableValue() throws MemoryAllocationException{
		String type = commandInfo.substring(getInstructionId().length() + 1, getInstructionId().length() + 4);
		String value = commandInfo.substring(getInstructionId().length() + 1 + type.length() + 1 + getVariableName().length() + 1);
		if(type.equals(InstructionKeywords.typeString)){
			return value.split("\"")[1];
		}else{
			if(type.equals(InstructionKeywords.typeBoolean)){
				return Boolean.parseBoolean(value);
			}
			if(type.equals(InstructionKeywords.typeDouble)){
				return Double.parseDouble(value);
			}
			if(type.equals(InstructionKeywords.typeFloat)){
				return Float.parseFloat(value);
			}
			if(type.equals(InstructionKeywords.typeInt)){
				return Integer.parseInt(value);
			}
		}
		throw new MemoryAllocationException();
	}
	
	public Object getVariableType(){
		return commandInfo.substring(getInstructionId().length() + 1, getInstructionId().length() + 4);
	}
	
}
