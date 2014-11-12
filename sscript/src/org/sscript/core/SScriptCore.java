package org.sscript.core;

import java.io.File;
import java.io.IOException;

import org.sscript.core.instructions.InstructionPrint;
import org.sscript.core.instructions.InstructionPrintLine;
import org.sscript.exceptions.CompiletimeException;
import org.sscript.exceptions.UnrecognizedSyntaxException;

public class SScriptCore implements Runnable{
	
	private Module currentModule;
	private SScriptInterpreter sint;
	
	public SScriptCore(){
		sint = new SScriptInterpreter();

	}
	
	public void addCoreCommands(){
		sint.addPossibleInstruction(new InstructionPrint());
		sint.addPossibleInstruction(new InstructionPrintLine());
	}
	
	@Override
	public void run() {
		
	}
	
	public Module[] compileSscript(File... sscriptFiles) throws IOException, UnrecognizedSyntaxException, CompiletimeException{
		if(sscriptFiles.length == 0){
			return null;
		}
		Module[] marray = new Module[sscriptFiles.length];
		int pos = 0;
		for(File f : sscriptFiles){
			Module m = sint.parseFileToModule(f);
			marray[pos++] = m;
		}
		return marray;
	}
	
	public boolean runSscriptFile(Module m){
		this.currentModule = m;
		new Thread(this).start();
		return true;
	}

}
