package com.reactiveworks.learning.defaultmethod;

import org.apache.log4j.Logger;

public class AirtelSIM implements SIM {
static Logger logger=Logger.getLogger(AirtelSIM.class);
	@Override
	public void call() {
     logger.debug("Calling from Airtel SIM");		
	}

	@Override
	public void sms() {
		logger.debug("Messaging from Airtel SIM");
		
	}
	public void videoCall(){
		logger.debug("Video calling from Airtel SIM");
	}

}
