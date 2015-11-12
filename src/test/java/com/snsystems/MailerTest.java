package com.snsystems;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.snsystems.mail.MailService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath*:spring/batch/config/database.xml",
		"classpath*:spring/batch/config/context.xml",
		"classpath*:spring/batch/jobs/job-report.xml",
		"classpath*:spring/jms/jmsConfig.xml"})
public class MailerTest {
 
	@Autowired
	private MailService mailService;

	@Test
    public void testMail() {
 
        //Send a composed mail
    	mailService.sendMail("sathyamus@hotmail.com", "sathyamus@outlook.com", "Test Subject", "Testing body");
 
        //Send a pre-configured mail
    	mailService.sendPreConfiguredMail("Exception occurred everywhere.. where are you ????");
    }
}
 