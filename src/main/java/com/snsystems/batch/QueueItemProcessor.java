package com.snsystems.batch;

import jms.PrinciplesMessageProducer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.snsystems.model.Report;

@Slf4j
@Component("queueItemProcessor")
public class QueueItemProcessor implements ItemProcessor<Report, String> {

	// private final static Logger LOG = Logger.getLogger(QueueItemProcessor.class);
	
	@Autowired
	private JmsTemplate producerTemplate;

	@Autowired
	private PrinciplesMessageProducer producer;
	
	@Override
	public String process(Report item) throws Exception {
		log.info("process: "+ item);
		producer.sendMessage(item+"");
		if (item != null)
			throw new Exception("Welcome... process");
		
		return item+"";
	}

}
