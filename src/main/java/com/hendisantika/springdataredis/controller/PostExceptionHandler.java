package com.hendisantika.springdataredis.controller;

import com.hendisantika.springdataredis.exception.PostNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-data-redis
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 22/12/17
 * Time: 09.18
 * To change this template use File | Settings | File Templates.
 */

@ControllerAdvice
public class PostExceptionHandler {
    private final Logger log = LoggerFactory.getLogger(PostExceptionHandler.class);

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Post Not Found")
    @ExceptionHandler(PostNotFoundException.class)
    public void handlePostNotFound(HttpServletRequest request, Exception ex) {
        log.error("{} : {}", ex.getMessage(), request.getRequestURI());
    }
}
