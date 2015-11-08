package jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("principlesMessageProducer")
public class PrinciplesMessageProducer {

	@Autowired
	private JmsTemplate producerTemplate;

	public PrinciplesMessageProducer() {
	}

	public void sendMessage(final String message) throws JMSException {
		producerTemplate.send(new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(message);
			}
		});
	}
}
