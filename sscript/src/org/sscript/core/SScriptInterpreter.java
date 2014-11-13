package org.sscript.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.sscript.exceptions.CompiletimeException;
import org.sscript.exceptions.UnrecognizedFiletypeException;
import org.sscript.exceptions.UnrecognizedSyntaxException;

public class SScriptInterpreter {
	
	private ArrayList<Instruction> possibleInstructions;
	private int lineNum;
	
	public SScriptInterpreter(){
		possibleInstructions = new ArrayList<Instruction>();
		lineNum = 1;
	}
	
	public void addPossibleInstruction(Instruction i){
		possibleInstructions.add(i);
	}
	
	public ArrayList<Instruction> getPossibleInstructions(){
		return possibleInstructions;
	}
	
	public Module parseFileToModule(File file) throws IOException, UnrecognizedSyntaxException, CompiletimeException, UnrecognizedFiletypeException{
		String[] fileParts = file.getName().split("\\.");
		if(!fileParts[fileParts.length-1].equals("sscript")){
			throw new UnrecognizedFiletypeException(file);
		}
		
		if(SScriptCore.enableDeveloperMessages){
			System.out.println("...> Reading file " + file.getName());
		}
		
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		if(!line.startsWith("name")){
			br.close();
			return null;
		}
		
		Module moduleInProg = new Module(line.split(" ")[1]);
		
		while((line = br.readLine()) != null){
			lineNum++;
			parseLine(moduleInProg, line);
		}
		
		br.close();
		return moduleInProg;
	}
	
	private void parseLine(Module moduleInProg, String line) throws UnrecognizedSyntaxException, CompiletimeException{
		try{
			String[] splitLine = line.replaceAll("\\s+", " ").split(" ");
			if(splitLine.length == 0 || line.length() == 0){
				return;
			}
			for(Instruction i : possibleInstructions){
				if(splitLine[0].equals(i.getInstructionId())){ 
					i.setCommandInfo(line);
					Instruction i2 = i.getCopy();
					moduleInProg.addInstruction(i2);
					return;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new CompiletimeException(lineNum);
		}
		
		throw new UnrecognizedSyntaxException("\'" + line + "\'", lineNum);
		
	}
	
}
