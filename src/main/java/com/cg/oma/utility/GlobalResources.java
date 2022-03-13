package com.cg.oma.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GlobalResources {
	/**
	 *  implementation of Logger method which we use in service and controller class
	 */
	public static Logger getLogger(Class className) {
		return LoggerFactory.getLogger(className);
	}
}
