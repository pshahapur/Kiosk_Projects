package com.example.logging;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class LogTokenScanner {
	
	//private static final String REGEX = "\\Blog4j|java\\B";
	private static final String REGEX = "log4j|logger|sl4j";
	 //private static final String INPUT = "test sssssl4j sample";
	 String fileName = "c://Users/User/Downloads/lines.txt";
	
	public String ScanLogger() {
		Pattern p = Pattern.compile(REGEX);
		try {
			Files.lines(Paths.get(fileName))
					.map(p::matcher)
					.filter(Matcher::matches)
					.findFirst()
					.ifPresent(matcher -> System.out.println(matcher.find()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    //Matcher m = p.matcher(INPUT); 
		/*(if(m.find()) {
			return "line contains log4j";
		} else {
			return "line looks fine";
		}*/
		return "completed";
	}

}
