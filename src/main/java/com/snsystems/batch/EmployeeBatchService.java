package com.snsystems.batch;

import lombok.extern.slf4j.Slf4j;
// import org.apache.log4j.Logger;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service("employeeBatchService")
public class EmployeeBatchService {
	
	// private Logger LOG = Logger.getLogger(EmployeeBatchService.class);
	
	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private Job job;

	public void startJobProcess() {

		try {
			JobExecution execution = jobLauncher.run(job, new JobParameters());
			log.info("Exit Status : " + execution.getStatus());

		} catch (Exception e) {
			log.info(e.getMessage());
			e.printStackTrace();
		}
		log.info("Done");
	}
}