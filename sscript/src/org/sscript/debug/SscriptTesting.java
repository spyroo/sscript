package org.sscript.debug;

import java.io.File;
import java.io.IOException;

import org.sscript.core.Module;
import org.sscript.core.SScriptInterpreter;

public class SscriptTesting {

	public static void main(String[] args){
		new SscriptTesting();
	}
	
	public SscriptTesting(){
		SScriptInterpreter sint = new SScriptInterpreter();
		try {
			System.out.println("a");
			Module m = sint.parseFileToModule(new File("test.sscript"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
