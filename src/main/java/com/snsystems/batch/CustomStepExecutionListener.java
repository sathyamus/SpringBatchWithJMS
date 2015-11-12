package com.snsystems.batch;

import org.apache.log4j.Logger;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.snsystems.mail.MailService;

@Component("customStepExecutionListener")
public class CustomStepExecutionListener implements StepExecutionListener {

	private Logger LOG = Logger.getLogger(CustomStepExecutionListener.class);
	
	@Autowired
	private MailService mailService;

	@Override
	public void beforeStep(StepExecution stepExecution) {

		LOG.info("StartTime: " + stepExecution.getStartTime());
		LOG.info("CommitCount: " + stepExecution.getCommitCount());
		LOG.info("ReadCount: " + stepExecution.getReadCount());
		LOG.info("Summary: " + stepExecution.getSummary());
		LOG.info("ExitDescription: "
				+ stepExecution.getExitStatus().getExitDescription());
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {

		LOG.info("EndTime: " + stepExecution.getEndTime());
		LOG.info("CommitCount: " + stepExecution.getCommitCount());
		LOG.info("ReadCount: " + stepExecution.getReadCount());
		LOG.info("Summary: " + stepExecution.getSummary());
		LOG.info("ExitDescription: "
				+ stepExecution.getExitStatus().getExitDescription());
		
		
    	if(ExitStatus.COMPLETED.equals(stepExecution.getExitStatus())) {
            //Send a composed mail
        	mailService.sendMail("sathyamus@hotmail.com", "sathyamus@outlook.com", "Test Subject", "Testing body");
    	}
    	
		return stepExecution.getExitStatus();
	}

}