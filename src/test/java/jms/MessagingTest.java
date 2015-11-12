package jms;

import static org.junit.Assert.assertNotNull;

import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:jms/jmsConfig.xml" })
public class MessagingTest {

	private Logger LOG = Logger.getLogger("MessagingTest"); // LoggerFactory.getLogger(MessagingTest.class);

	@Autowired
	private PrinciplesMessageProducer msgSender;

	@Test
	public void testSendAndReceive() {

		assertNotNull("PrinciplesMessageProducer was null", msgSender);

		System.out.printf("PrinciplesMessageProducer instance -> %s%n",
				msgSender);
		LOG.info(msgSender.toString());
		try {
			msgSender.sendMessage("Welcome to JMS");
		} catch (Exception e) {
			LOG.info(e.toString());
		}
	}

}