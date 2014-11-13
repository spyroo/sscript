package org.sscript.debug;

import java.io.File;
import java.io.IOException;

import org.sscript.core.Instruction;
import org.sscript.core.Module;
import org.sscript.core.SScriptCore;
import org.sscript.core.SScriptInterpreter;
import org.sscript.core.instructions.InstructionPrint;
import org.sscript.core.instructions.InstructionPrintLine;
import org.sscript.exceptions.CompiletimeException;
import org.sscript.exceptions.RuntimeException;
import org.sscript.exceptions.UnrecognizedFiletypeException;
import org.sscript.exceptions.UnrecognizedSyntaxException;

public class SscriptTesting {

	public static void main(String[] args){
		new SscriptTesting();
	}
	
	public SscriptTesting(){

		try {
			
			SScriptCore score = new SScriptCore();
			SScriptCore.enableDeveloperMessages = true;
			Module m = score.compileSscript(new File("test.sscript"))[0];
			score.runSscriptFile(m);
			
		} catch (IOException e) {
			e.printStackTrace();
		}catch (UnrecognizedSyntaxException e) {
			e.printStackTrace();
		} catch (CompiletimeException e) {
			e.printStackTrace();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} catch (UnrecognizedFiletypeException e) {
			e.printStackTrace();
		}
	}
	
}
