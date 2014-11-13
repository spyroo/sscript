package org.sscript.core.instructions;

import java.text.NumberFormat;

import org.sscript.core.Instruction;
import org.sscript.exceptions.RuntimeException;

public class InstructionCreateVariable implements Instruction{

	private String commandInfo;
	
	public InstructionCreateVariable(String commandLine) {
		this.commandInfo = commandLine;
	}
	
	public InstructionCreateVariable() {
	}

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
		InstructionCreateVariable icv = new InstructionCreateVariable(commandInfo);
		return icv;
	}
	
	public String getVariableName(){
		String[] splitLine = commandInfo.split(" ");
		return splitLine[1];
	}
	
	public Object getVariableValue(){
		String[] splitLine = commandInfo.split(" ");
		String value = commandInfo.substring(splitLine[0].length() + splitLine[1].length() + 2, commandInfo.length());
	    Number number = null;
	    try {
	        number = Double.parseDouble(value);
	    } catch(NumberFormatException e) {
	        try {
	            number = Float.parseFloat(value);
	        } catch(NumberFormatException e1) {
	            try {
	                number = Long.parseLong(value);
	            } catch(NumberFormatException e2) {
	                try {
	                    number = Integer.parseInt(value);
	                } catch(NumberFormatException e3) {
	                    return value;
	                }
	            }       
	        }       
	    }
	    return (Object)number;
	}
	
}
