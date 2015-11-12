package com.snsystems;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.snsystems.batch.EmployeeBatchService;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath*:spring/batch/config/database.xml",
		"classpath*:spring/batch/config/context.xml",
		"classpath*:spring/batch/jobs/job-report.xml",
		"classpath*:spring/jms/jmsConfig.xml"})
public class EmployeeBatchTest {

	@Autowired
	private EmployeeBatchService employeeBatchService;
	
	@Test
	public void launchJob() {

		employeeBatchService.startJobProcess();
		
	}
}
