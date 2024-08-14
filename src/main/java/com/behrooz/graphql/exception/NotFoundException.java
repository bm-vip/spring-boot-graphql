package com.behrooz.graphql.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
@Slf4j
public class NotFoundException extends BaseException{
    public NotFoundException() {
        super("not found!", HttpStatus.NOT_FOUND);
        log.error(String.valueOf(this));
    }
    public NotFoundException(String msg) {
        super(msg, HttpStatus.NOT_FOUND);
        log.error(String.valueOf(this));
    }
    public NotFoundException(String msg, Throwable e) {
        super(msg,HttpStatus.NOT_FOUND, e);
        log.error(String.valueOf(this));
    }

    public Throwable fillInStackTrace() {
        return this;
    }
}

