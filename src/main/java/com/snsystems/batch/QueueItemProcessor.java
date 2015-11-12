package com.snsystems.batch;

import jms.PrinciplesMessageProducer;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.snsystems.model.Report;

@Component("queueItemProcessor")
public class QueueItemProcessor implements ItemProcessor<Report, String> {

	private final static Logger LOG = Logger.getLogger(QueueItemProcessor.class);
	
	@Autowired
	private JmsTemplate producerTemplate;

	@Autowired
	private PrinciplesMessageProducer producer;
	
	@Override
	public String process(Report item) throws Exception {
		LOG.info("process: "+ item);
		producer.sendMessage(item+"");
		if (item != null)
			throw new Exception("Welcome... process");
		
		return item+"";
	}

}
