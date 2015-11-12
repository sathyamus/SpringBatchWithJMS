package com.snsystems.batch;

import java.util.StringTokenizer;

import javax.jms.Message;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.snsystems.model.Report;

@Component("queueItemReader")
public class QueueItemReader implements ItemReader<Report>{

	private Logger LOG = Logger.getLogger(QueueItemReader.class);
	
	@Autowired
	private JmsTemplate producerTemplate;

	@Override
	public Report read() throws Exception, UnexpectedInputException,
			ParseException, NonTransientResourceException {
		
		LOG.info("QueueItemReader");
		Message message = producerTemplate.receive();
		TextMessage msgText = (TextMessage) message;
		LOG.info(msgText.getText());
		StringTokenizer tokenizer = new StringTokenizer(msgText.getText(), ",");
		tokenizer.countTokens();
		LOG.info(tokenizer.nextElement()+"");
		//return new Report();
		return null;
	}

}
