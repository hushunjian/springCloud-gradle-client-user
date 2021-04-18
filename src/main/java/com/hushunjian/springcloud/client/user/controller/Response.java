package com.hushunjian.springcloud.client.user.controller;

import lombok.Data;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
public class Response<T> {

    private static final int DEFAULT_SUCCESS_STATUS = 200;
    private static final String DEFAULT_SUCCESS_MESSAGE = "success";

    private static final int DEFAULT_FAILURE_STATUS = 500;
    private static final String DEFAULT_FAILURE_MESSAGE = "failure";

    private int status;

    private String message;

    private T body;

    private Response(int status, String message, T body) {
        this.status = status;
        this.message = message;
        this.body = body;
    }

    private Response(int status, String message) {
        this.status = status;
        this.message = message;
    }


    public static <T> Response<T> success(T body) {
       return new Response<>(DEFAULT_SUCCESS_STATUS, DEFAULT_SUCCESS_MESSAGE, body);
    }

    public static <T> Response<T> success() {
       return new Response<>(DEFAULT_SUCCESS_STATUS, DEFAULT_SUCCESS_MESSAGE);
    }


    public static <T> Response<T> failure(T body) {
        return new Response<>(DEFAULT_FAILURE_STATUS, DEFAULT_FAILURE_MESSAGE, body);
    }

    public static <T> Response<T> failure() {
        return new Response<>(DEFAULT_FAILURE_STATUS, DEFAULT_FAILURE_MESSAGE);
    }
}
