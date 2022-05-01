package com.snsystems.batch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.snsystems.mail.MailService;

@Slf4j
@Component("customStepExecutionListener")
public class CustomStepExecutionListener implements StepExecutionListener {

	// private Logger LOG = Logger.getLogger(CustomStepExecutionListener.class);
	
	@Autowired
	private MailService mailService;

	@Override
	public void beforeStep(StepExecution stepExecution) {

		log.info("StartTime: " + stepExecution.getStartTime());
		log.info("CommitCount: " + stepExecution.getCommitCount());
		log.info("ReadCount: " + stepExecution.getReadCount());
		log.info("Summary: " + stepExecution.getSummary());
		log.info("ExitDescription: "
				+ stepExecution.getExitStatus().getExitDescription());
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {

		log.info("EndTime: " + stepExecution.getEndTime());
		log.info("CommitCount: " + stepExecution.getCommitCount());
		log.info("ReadCount: " + stepExecution.getReadCount());
		log.info("Summary: " + stepExecution.getSummary());
		log.info("ExitDescription: "
				+ stepExecution.getExitStatus().getExitDescription());
		
		
    	if(ExitStatus.COMPLETED.equals(stepExecution.getExitStatus())) {
            //Send a composed mail
        	mailService.sendMail("sathyamus@hotmail.com", "sathyamus@outlook.com", "Test Subject", "Testing body");
    	}
    	
		return stepExecution.getExitStatus();
	}

}