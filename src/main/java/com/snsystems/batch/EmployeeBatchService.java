package com.snsystems.batch;

import org.apache.log4j.Logger;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("employeeBatchService")
public class EmployeeBatchService {
	
	private Logger LOG = Logger.getLogger(EmployeeBatchService.class);
	
	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private Job job;

	public void startJobProcess() {

		try {
			JobExecution execution = jobLauncher.run(job, new JobParameters());
			LOG.info("Exit Status : " + execution.getStatus());

		} catch (Exception e) {
			LOG.info(e.getMessage());
			e.printStackTrace();
		}
		LOG.info("Done");
	}
}