package com.cx.users.csv.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class MainControllerAdvice {
    private Logger logger = LoggerFactory.getLogger(MainControllerAdvice.class);

    @ExceptionHandler({Exception.class})
    public final String handleException(Exception e, WebRequest req) {
        logger.error("Unhandled exception: " + e.getMessage());
        return "index";
    }
}
