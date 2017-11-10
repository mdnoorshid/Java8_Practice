package com.reactiveworks.learning.streams;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class StreamFromFile {
	static Logger logger=Logger.getLogger(StreamFromFile.class);
public static List<String> getUniqueWords(){
	List<String>uniqueWords = null;
	try {
		Stream<String>lines=Files.lines(Paths.get("C:\\Users\\Niyamat\\Desktop\\work.txt"),Charset.defaultCharset());
		uniqueWords=lines.flatMap(l->Arrays.stream(l.split(" "))).distinct().collect(Collectors.toList());
	} catch (IOException e) {
		logger.error(e);
	}
	return uniqueWords;
}
public static void main(String[] args) {
	BasicConfigurator.configure();
	List<String>workList=getUniqueWords();
	logger.debug("workList:: "+workList);
	logger.debug("countVal:: "+workList.size());
}
}
