package org.sscript.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.sscript.core.instructions.InstructionCreateVariable;
import org.sscript.exceptions.MemoryAllocationException;

public class Module {

	private String moduleName;
	private ArrayList<Instruction> instructionList;
	private Map<String, Object> memoryMap;
	
	public Module(String moduleName){
		this.moduleName = moduleName;
		instructionList = new ArrayList<Instruction>();
		SScriptCore.printDebugString("Creating module " + moduleName);
		memoryMap = new HashMap<String, Object>();
	}
	
	public void addInstruction(Instruction inst){
		instructionList.add(inst);
	}
	
	public ArrayList<Instruction> getInstructions(){
		return instructionList;
	}
	
	public Map<String, Object> getMemoryMap() {
		return memoryMap;
	}
	
	public void allocateMemory() throws MemoryAllocationException{
		SScriptCore.printDebugString("Allocation memory in module " + moduleName);
		for(Instruction i : instructionList){
			if(i instanceof InstructionCreateVariable){
				InstructionCreateVariable icv = (InstructionCreateVariable)i;
				memoryMap.put(icv.getVariableName(), icv.getVariableValue());
				SScriptCore.printDebugString("Allocated " + icv.getVariableName() + " with value " + icv.getVariableValue().toString() + " as type " + icv.getVariableType());
			}
		}
		SScriptCore.printDebugString("Finished allocating memory in module " + moduleName);
	}

	public String getModuleName() {
		return moduleName;
	}
	
}
