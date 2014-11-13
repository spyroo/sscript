package org.sscript.core;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.sscript.core.instructions.InstructionCreateVariable;
import org.sscript.core.instructions.InstructionPrint;
import org.sscript.core.instructions.InstructionPrintLine;
import org.sscript.exceptions.CompiletimeException;
import org.sscript.exceptions.RuntimeException;
import org.sscript.exceptions.UnrecognizedFiletypeException;
import org.sscript.exceptions.UnrecognizedSyntaxException;

public class SScriptCore {
	
	private Module currentModule;
	private SScriptInterpreter sint;
	private int executionPosition;
	private boolean canChangePosition;
	public static boolean enableDeveloperMessages;
	
	public SScriptCore(){
		sint = new SScriptInterpreter();
		addCoreCommands();
		canChangePosition = false;
		enableDeveloperMessages = false;
	}
	
	public static void printDebugString(String debug){
		if(enableDeveloperMessages)
			System.out.println("...> " + debug);
	}
	
	public void addCoreCommands(){
		sint.addPossibleInstruction(new InstructionPrint());
		sint.addPossibleInstruction(new InstructionPrintLine());
		sint.addPossibleInstruction(new InstructionCreateVariable());
	}
	
	public void setCurrentExecutionPosition(int newPos){
		if(canChangePosition)
			this.executionPosition = newPos;
	}
	
	private void forceSetCurrentExecutionPosition(int newPos){
		this.executionPosition = newPos;
	}
	
	public int getExecutionPosition(){
		return executionPosition;
	}
	
	public boolean canChangeExecutionPosition(){
		return canChangePosition;
	}
	
	private boolean run() throws RuntimeException {
		long startExecution = System.currentTimeMillis();
		
		currentModule.allocateMemory();
		
		ArrayList<Instruction> instructions = currentModule.getInstructions();
		for(executionPosition = 0; executionPosition < instructions.size(); executionPosition++){
			instructions.get(executionPosition).execute(currentModule);
		}
		
		long endExecution = System.currentTimeMillis();
		long finalTime = endExecution - startExecution;
		if(enableDeveloperMessages){
			System.out.println("\n\n...> ----------EXECUTION SUCCESSFUL----------");
			System.out.println("...> Finished executing in " + finalTime + " mills\n");
		}
		return true;
	}
	
	public Module[] compileSscript(File... sscriptFiles) throws IOException, UnrecognizedSyntaxException, CompiletimeException, UnrecognizedFiletypeException{
		long time = System.currentTimeMillis();
		if(sscriptFiles.length == 0){
			return null;
		}
		Module[] marray = new Module[sscriptFiles.length];
		int pos = 0;
		for(File f : sscriptFiles){
			Module m = sint.parseFileToModule(f);
			marray[pos++] = m;
		}
		long time2 = System.currentTimeMillis();
		long finalTime = time2-time;
		if(enableDeveloperMessages){
			System.out.println("...> ----------COMPILE   SUCCESSFUL----------");
			System.out.println("...> Finished compiling in " + finalTime + " mills\n");
		}
		return marray;
	}
	
	public boolean runSscriptFile(Module m) throws RuntimeException{
		this.currentModule = m;
		return run();
	}
	
	public String[] getReservedWords(){
		ArrayList<Instruction> insts = sint.getPossibleInstructions();
		String[] words = new String[insts.size()];
		int pos = 0;
		for(Instruction i : insts){
			words[pos++] = i.getInstructionId();
		}
		return words;
	}

}
