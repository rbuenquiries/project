package com.rbu.logapp.log_audit_service.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LogService {
	Logger logger = LoggerFactory.getLogger(LogService.class);

	public void auditlogintofile(String problemtype, String description) {
		if (problemtype.equals("error")) {
			logger.error(description);
		} else if (problemtype.equals("info")) {
			logger.info(description);
		}
	}
}
