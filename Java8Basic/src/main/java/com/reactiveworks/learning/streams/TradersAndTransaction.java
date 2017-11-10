package com.reactiveworks.learning.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class TradersAndTransaction {
	static Logger logger=Logger.getLogger(TradersAndTransaction.class);
public static void main(String[] args) {
	BasicConfigurator.configure();
	Trader raoul = new Trader("Raoul", "Cambridge");
	Trader mario = new Trader("Mario","Milan");
	Trader alan = new Trader("Alan","Cambridge");
	Trader brian = new Trader("Brian","Cambridge");
	
	List<Transaction> transactions = Arrays.asList(
			new Transaction(brian, 2011, 300),
			new Transaction(raoul, 2012, 1000),
			new Transaction(raoul, 2011, 400),
			new Transaction(mario, 2012, 710),
			new Transaction(mario, 2012, 700),
			new Transaction(alan, 2012, 950)
			);
	//Find all transactions in the year 2011 and sort them by value (small to high)
    List<Transaction>solList1=transactions.stream().filter(t->t.getYear()==2011).sorted(new Comparator<Transaction>() {

		@Override
		public int compare(Transaction o1, Transaction o2) {
			
			return o1.getValue()-o2.getValue();
		}
    	
	}).collect(Collectors.toList());
    
    logger.debug("solList1---> "+solList1);
                   //Converting whole line into lambda
     List<Transaction>solList=transactions.stream().filter(t->t.getYear()==2011).sorted((o1,o2)->o1.getValue()-o2.getValue()).collect(Collectors.toList());
     logger.debug("solList---> "+solList);
     
     //What are all the unique cities where the traders work?
     List<String>uniqueCitiesList=transactions.stream().map(t->t.getTrader().getCity()).distinct().collect(Collectors.toList());
     logger.debug("uniqueCitiesList:: "+uniqueCitiesList);
     
     //Find all traders from Cambridge and sort them by name
     List<Trader>traderCambridge=transactions.stream().map(t->t.getTrader()).filter(c->c.getCity().equalsIgnoreCase("Cambridge")).distinct().sorted((t1,t2)->t1.getName().compareTo(t2.getName())).collect(Collectors.toList());
     logger.debug("traderCambridge:: "+traderCambridge);
     
     //Return a string of all traders’ names sorted alphabetically
     String tradeStr=transactions.stream().map(t->t.getTrader().getName()).distinct().sorted().reduce("",(n1,n2)->n1+n2);
     logger.debug("tradeStr:: "+tradeStr);
     
     //Are any traders based in Milan?
     boolean isTraderBasedInMilan=transactions.stream().anyMatch(t->t.getTrader().getCity().equalsIgnoreCase("Milan"));
     logger.debug("isTraderBasedInMilan---> "+isTraderBasedInMilan);
     
     //Print all transactions’ values from the traders living in Cambridge.
     List<Integer>allTransactionValList=transactions.stream().filter(t->t.getTrader().getCity().equalsIgnoreCase("Cambridge")).map(Transaction::getValue).collect(Collectors.toList());
     logger.debug("allTransactionValList---> "+allTransactionValList);
     
     //What’s the highest value of all the transactions
     Optional<Integer> optTransMaxVal=transactions.stream().map(t->t.getValue()).reduce(Integer::max);
     logger.debug("optTransVal:: "+optTransMaxVal.get());
     
     //Find the transaction with the smallest value
     Optional<Integer>optTransMinVal=transactions.stream().map(t->t.getValue()).reduce(Integer::min);
     logger.debug("optTransMinVal---> "+optTransMinVal.get());
/*-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
     
     /*The problem with this code(.reduce(0, Integer::sum)) is that there’s an insidious boxing cost. Behind the scenes each
     Integer needs to be unboxed to a primitive before performing the summation*/  
     int sumOfValues=transactions.stream().mapToInt(t->t.getValue()).distinct().sum();
     logger.debug("sumOfValues:: "+sumOfValues);

     //To convert from a primitive stream to a general stream
     IntStream intStream=transactions.stream().mapToInt(t->t.getValue());//Converting a Stream to a numeric Stream
     Stream<Integer>stream=intStream.boxed();//Converting numeric stream to a stream
     
     //To get Max of transaction value
     OptionalInt maxValOpt=transactions.stream().mapToInt(v->v.getValue()).max();
     int maxVal=maxValOpt.orElse(1);
     logger.debug("maxVal:: "+maxVal);
     
/*---------------------------------------------------NUMERIC RANGE---------------------------------------------------------------------*/
     IntStream intStreamRangeEvenNumber=IntStream.rangeClosed(1, 100).filter(n->n%2==0);
    //logger.debug("Total Event Numbers:: "+intStreamRangeEvenNumber.count()); //Finding Counts
    intStreamRangeEvenNumber.forEach(n->logger.debug("Even number: "+n)); //Printing every even numbers
    
    //Pythagora's triples
    Stream<double []>pythagoransTriples2=IntStream.rangeClosed(1,100).boxed().flatMap(a->IntStream.rangeClosed(a,100).mapToObj(b->new double[]{a,b,Math.sqrt(a*a+b*b)})).filter(t->t[2]%1==0);
    
    
    
    
     
}
}
