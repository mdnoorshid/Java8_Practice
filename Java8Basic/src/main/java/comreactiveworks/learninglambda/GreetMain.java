package comreactiveworks.learninglambda;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class GreetMain {
static Logger logger=Logger.getLogger(GreetMain.class);
public static void main(String[] args) {
	BasicConfigurator.configure();
	//This name variable should be final, here it is effectively final
	String name="Noorshid";
	//Lambda is always a type of Interface(Functional Interface---->Contains only one abstract method) 
	IGreeting greet1=m->logger.debug("Greeting Message----> "+m+" "+name);
	greet1.greet("Good Morning");
	greet1.greet("Good Night");
}
}
