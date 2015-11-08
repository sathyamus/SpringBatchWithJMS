package jms;

import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {
//	    "classpath*:jms/serviceBus.xml"})

public class MessagingTest {
	
	private Logger LOG = Logger.getLogger("ggg"); //LoggerFactory.getLogger(MessagingTest.class);

	private ApplicationContext applicationContext;
	
	
	@Autowired
	private PrinciplesMessageProducer msgSender;

	@Test
	public void testApplicationContext() {
		assertNotNull("Application Context was null.", applicationContext);
		LOG.info("Application Context instance -> {}" + applicationContext);
	}

	@Test
	public void testSendAndReceive() {
		msgSender = applicationContext.getBean("principlesMessageProducer",
				PrinciplesMessageProducer.class);
		assertNotNull("PrinciplesMessageProducer was null", msgSender);

		System.out.printf("PrinciplesMessageProducer instance -> %s%n",
				msgSender);
		try {
			msgSender.sendMessage("Welcome to JMS");
		} catch (Exception e) {
			LOG.info(e.toString());
		}
	}

	public Map<String, Object> data() {
		Map<String, Object> data = new HashMap<String, Object>();
		String[] langs = { "Java", "JavaScript", "Clojure", "Groovy" };
		data.put("Programming Languages", Arrays.asList(langs));
		return data;
	}

//	public String dataAsJson(Map<String, Object> data) {
//		Gson gson = new Gson();
//		return gson.toJson(data, Map.class);
//	}

	@Before
	public void setUp() {
		applicationContext = new ClassPathXmlApplicationContext(
				"classpath*:/jms/serviceBus.xml");
	}

	@After
	public void tearDown() {
		// applicationContext = null;
	}
}