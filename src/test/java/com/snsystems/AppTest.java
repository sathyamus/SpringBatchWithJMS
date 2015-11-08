package com.snsystems;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
	    "classpath*:spring/batch/config/database.xml",
		"classpath*:spring/batch/config/context.xml",
		"classpath*:spring/batch/jobs/job-report.xml"})

public class AppTest {

	@Autowired
	private JobLauncher jobLauncher;
	
	@Autowired
	private Job job;
	
	@Test
	public void launchJob() {
		String[] springConfig = { "spring/batch/config/database.xml",
				"spring/batch/config/context.xml",
				"spring/batch/jobs/job-report.xml" };

		ApplicationContext context = new ClassPathXmlApplicationContext(
				springConfig);

//		JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
//		Job job = (Job) context.getBean("reportJob");

		try {

			JobExecution execution = jobLauncher.run(job, new JobParameters());
			System.out.println("Exit Status : " + execution.getStatus());

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Done");
	}
}
