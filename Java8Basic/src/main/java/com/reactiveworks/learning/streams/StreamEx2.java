package com.reactiveworks.learning.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class StreamEx2 {
	static Logger logger=Logger.getLogger(StreamEx2.class);
 public static void playWithStream(){
	 String[] wordsArr ={"HELLO","WORLD"};
     Stream<String>stream=Arrays.stream(wordsArr);
     List<String>uniqueStream=stream.map(p->p.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());
     logger.debug("uniqueStream:: "+uniqueStream);
     
     //Returning Square of Numbers
     List<Integer>numbers=Arrays.asList(1,2,3,4,5);
     List<Integer>sqrNumbers=numbers.stream().map(i->i*i).collect(Collectors.toList());
     logger.debug("sqrNumbers---> "+sqrNumbers);
     
     //Returning Pairs Of Numbers
     List<Integer>numbers1=Arrays.asList(1,2,3);
     List<Integer>numbers2=Arrays.asList(3,4);
     List<int[]>pairs=numbers1.stream().flatMap(i->numbers2.stream().map(j->new int[]{i,j})).collect(Collectors.toList());
     
     //Returning first square number which is divide by 3
     List<Integer>someNumbers=Arrays.asList(2,1,4,3,5,6);
    Optional<Integer>optional= someNumbers.stream().map(i->i*i).filter(i->i%3==0).findFirst();
    int num=optional.get();
    logger.debug("num----> "+num);
    //Using lambda getting sum and reduced stream into a single number
    int sum=someNumbers.stream().reduce(0,(a,b)->a+b);
    logger.debug("sum---> "+sum);
    
    //Using method reference getting sum and reduced stream into a single number
    int sum2=someNumbers.stream().reduce(0,Integer::sum);
    logger.debug("sum2---> "+sum2);
    
    Optional<Integer> optionalMax=someNumbers.stream().reduce(Integer::max);
    int maxNumber=optionalMax.get();
    logger.debug("maxNumber:: "+maxNumber);
    Optional<Integer>optionalMin=someNumbers.stream().reduce((x,y)->x<y?x:y);
    logger.debug("optionalMin Num---> "+optionalMin.get());
    
    //Count value using map and reduce function
    int countVal=someNumbers.stream().map(d->1).reduce(0,(a,b)->a+b);
    logger.debug("countVal---> "+countVal);
    List<Integer>sortedList= someNumbers.stream().sorted().collect(Collectors.toList());
    logger.debug("sortedList---> "+sortedList);
    
    
    
   
 }
 public static void main(String[] args) {
	 BasicConfigurator.configure();
	 playWithStream();
}
}
