package org.sscript.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.sscript.core.instructions.InstructionCreateVariable;

public class Module {

	private String moduleName;
	private ArrayList<Instruction> instructionList;
	private Map<String, Object> memoryMap;
	
	public Module(String moduleName){
		this.moduleName = moduleName;
		instructionList = new ArrayList<Instruction>();
		SScriptCore.printDebugString("...> Creating module " + moduleName);
		memoryMap = new HashMap<String, Object>();
	}
	
	public void addInstruction(Instruction inst){
		instructionList.add(inst);
	}
	
	public ArrayList<Instruction> getInstructions(){
		return instructionList;
	}
	
	public void allocateMemory(){
		SScriptCore.printDebugString("...> Allocation memory in module " + moduleName);
		for(Instruction i : instructionList){
			if(i instanceof InstructionCreateVariable){
				//do stuff here
			}
		}
	}

	public String getModuleName() {
		return moduleName;
	}
	
}
