package com.snsystems.batch;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.snsystems.model.Report;

@Component("queueItemWriter")
public class QueueItemWriter implements ItemWriter<Report> {

	private Logger LOG = Logger.getLogger(QueueItemWriter.class);
	
	@Autowired
	private JmsTemplate producerTemplate;

	@Override
	public void write(List<? extends Report> items) throws Exception {

		LOG.info("items: " + items.size());
		
		if (items.size() == 10) {
			throw new Exception("welcome...");
		}
	}

}
