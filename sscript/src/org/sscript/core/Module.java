package org.sscript.core;

import java.util.ArrayList;

public class Module {

	private String moduleName;
	private ArrayList<Instruction> instructionList;
	
	public Module(String moduleName){
		this.moduleName = moduleName;
		instructionList = new ArrayList<Instruction>();
		System.out.println("Creating module " + moduleName);
	}
	
	public void addInstruction(Instruction inst){
		System.out.println("Adding Instruction " + inst.getInstructionId());
		instructionList.add(inst);
	}
	
	public ArrayList<Instruction> getInstructions(){
		return instructionList;
	}

	public String getModuleName() {
		return moduleName;
	}
	
}
