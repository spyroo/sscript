package org.sscript.debug;

import java.io.File;
import java.io.IOException;

import org.sscript.core.Instruction;
import org.sscript.core.Module;
import org.sscript.core.SScriptInterpreter;
import org.sscript.core.instructions.InstructionPrint;
import org.sscript.core.instructions.InstructionPrintLine;

public class SscriptTesting {

	public static void main(String[] args){
		new SscriptTesting();
	}
	
	public SscriptTesting(){
		SScriptInterpreter sint = new SScriptInterpreter();
		sint.addPossibleInstruction(new InstructionPrint());
		sint.addPossibleInstruction(new InstructionPrintLine());
		try {
			Module m = sint.parseFileToModule(new File("test.sscript"));
			
			System.out.println("----------COMPILED test.sscript----------");
			System.out.println("----------RUNNING  test.sscript----------");
			for(Instruction i : m.getInstructions()){
				if(i != null)
					i.execute();
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
