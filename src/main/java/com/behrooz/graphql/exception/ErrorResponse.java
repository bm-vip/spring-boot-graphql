package com.behrooz.graphql.exception;

import org.springframework.http.HttpStatus;

import java.util.Date;

public class ErrorResponse {
    private Date timestamp;
    private int status;
    private String error;
    private String path;
    private Object message;
    private String code;

    public ErrorResponse(HttpStatus status, String path, Object message, String code) {
        this.status = status.value();
        this.error = status.getReasonPhrase();
        this.path = path;
        this.message = message;
        this.code = code;
        this.timestamp = new Date();
    }

    public ErrorResponse(HttpStatus status, String path, Object message) {
        this.status = status.value();
        this.error = status.getReasonPhrase();
        this.path = path;
        this.message = message;
        this.timestamp = new Date();
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    public int getStatus() {
        return this.status;
    }

    public String getError() {
        return this.error;
    }

    public String getPath() {
        return this.path;
    }

    public Object getMessage() {
        return this.message;
    }
}

