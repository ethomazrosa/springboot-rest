package com.ethomaz.springboot_rest.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ethomaz.springboot_rest.services.PersonServices;

@RestController
public class TestLogController {

    private Logger logger = LoggerFactory.getLogger(PersonServices.class.getName());

    @GetMapping("/test-log")
    public String testLog() {
        logger.debug("Debug log message");
        logger.info("Info log message");
        logger.warn("Warn log message");
        logger.error("Error log message");

        return "Logs generated successfully!";
    }

}
