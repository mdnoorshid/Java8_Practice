package com.reactiveworks.learning.defaultmethod;

import org.apache.log4j.Logger;

public interface SIM {
	static Logger logger=Logger.getLogger(SIM.class);
void call();
void sms();
default void videoCall(){
	logger.debug("Default Video Call.....");
};
}
