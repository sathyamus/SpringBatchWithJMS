package com.snsystems.batch;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.snsystems.model.Report;

@Slf4j
@Component("queueItemWriter")
public class QueueItemWriter implements ItemWriter<Report> {

	// private Logger LOG = Logger.getLogger(QueueItemWriter.class);
	
	@Autowired
	private JmsTemplate producerTemplate;

	@Override
	public void write(List<? extends Report> items) throws Exception {

		log.info("items: " + items.size());
		
		if (items.size() == 10) {
			throw new Exception("welcome...");
		}
	}

}
