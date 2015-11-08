package jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.stereotype.Component;

@Component
public class PrinciplesMessageConsumer implements MessageListener {

	@Override
	public void onMessage(Message message) {
		TextMessage msgText = (TextMessage) message;
		try {
			System.out.format("Consumed message -> %s", msgText.getText());
		} catch (JMSException e) {
			System.out.format("%s", e.toString());
		}
	}

}
