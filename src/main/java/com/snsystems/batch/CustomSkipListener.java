package com.snsystems.batch;

import org.apache.log4j.Logger;
import org.springframework.batch.core.SkipListener;
import org.springframework.stereotype.Component;

@Component("customSkipListener")
public class CustomSkipListener implements SkipListener<Object, Object> {

	private Logger LOG = Logger.getLogger(CustomSkipListener.class);
	
	@Override
	public void onSkipInProcess(Object arg0, Throwable arg1) {
		LOG.info("onSkipInProcess");
		LOG.info(arg0+"");
	}

	@Override
	public void onSkipInRead(Throwable arg0) {
		LOG.info("onSkipInRead");
	}

	@Override
	public void onSkipInWrite(Object item, Throwable arg1) {
		LOG.info("onSkipInWrite");
		LOG.info("Error in the record :" + item.toString() + " Type of Error : " + arg1.getClass());

	}

}