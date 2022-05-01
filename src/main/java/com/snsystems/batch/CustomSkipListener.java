package com.snsystems.batch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.SkipListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component("customSkipListener")
public class CustomSkipListener implements SkipListener<Object, Object> {

	// private Logger LOG = Logger.getLogger(CustomSkipListener.class);
	
	@Override
	public void onSkipInProcess(Object arg0, Throwable arg1) {
		log.info("onSkipInProcess");
		log.info(arg0+"");
	}

	@Override
	public void onSkipInRead(Throwable arg0) {
		log.info("onSkipInRead");
	}

	@Override
	public void onSkipInWrite(Object item, Throwable arg1) {
		log.info("onSkipInWrite");
		log.info("Error in the record :" + item.toString() + " Type of Error : " + arg1.getClass());

	}

}