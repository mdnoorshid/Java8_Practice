package com.reactiveworks.learning.javanashron.javascript;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class Java8NashronEx {
	static Logger logger=Logger.getLogger(Java8NashronEx.class);
public static void main(String[] args) {
	BasicConfigurator.configure();
	//Creating Script Engine
    ScriptEngine scriptEngine=new ScriptEngineManager().getEngineByName("Nashorn");
    
    //Reading nashorn file
    try {
		scriptEngine.eval(new FileReader("E:\\ReactiveWorks\\Learning\\Java8\\Java8Basic\\src\\main\\resources\\javaNasron.js"));
	} catch (ScriptException e) {
		logger.error("ERROR===> "+e);
	} catch (FileNotFoundException e) {
		logger.error("ERROR===> "+e);
	}
}
}
