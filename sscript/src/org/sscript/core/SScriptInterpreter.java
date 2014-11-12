package org.sscript.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SScriptInterpreter {
	
	private ArrayList<Instruction> possibleInstructions;
	
	public SScriptInterpreter(){
		possibleInstructions = new ArrayList<Instruction>();
	}
	
	public void addPossibleInstruction(Instruction i){
		possibleInstructions.add(i);
	}
	
	public Module parseFileToModule(File file) throws IOException{
		String[] fileParts = file.getName().split("\\.");
		if(!fileParts[fileParts.length-1].equals("sscript")){
			System.out.println("File " + file.getName() + " is not a sscript file!");
			return null;
		}
		
		System.out.println("Reading file " + file.getName());
		
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		if(!line.startsWith("name")){
			br.close();
			return null;
		}
		
		Module moduleInProg = new Module(line.split(" ")[1]);
		
		while((line = br.readLine()) != null){
			parseLine(moduleInProg, line);
		}
		
		br.close();
		return moduleInProg;
	}
	
	private void parseLine(Module moduleInProg, String line){
		String[] splitLine = line.split(" ");
		for(Instruction i : possibleInstructions){
			if(splitLine[0].equals(i.getInstructionId())){ 
				i.setCommandInfo(line);
				Instruction i2 = i.getCopy();
				moduleInProg.addInstruction(i2);
			}
		}
	}
	
}
