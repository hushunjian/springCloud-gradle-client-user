package com.hushunjian.springcloud.client.user.controller;

import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

public class BaseController {

    private static String STATUS = "status";
    private static String BODY = "body";
    private static String MESSAGE = "message";

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public Map<String, Object> handleValidationException(MethodArgumentNotValidException e) {
        Map<String, Object> errors = new HashMap<>();
        if (e.getBindingResult().hasErrors()) {
            for (ObjectError objectError : e.getBindingResult().getAllErrors()) {
                String code = objectError.getCodes()[1];
                String field = code.replaceAll("^.*\\.", "");
                errors.put(STATUS, "4000");
                String message = String.format("%s %s", field, objectError.getDefaultMessage());
                Map<String, Object> body = new HashMap<>();
                body.put(MESSAGE, message);
                errors.put(BODY, body);
                break;
            }
        }
        return errors;
    }

    public Object success(Object body) {
        Map<String, Object> response = new HashMap<>();
        response.put(STATUS, 200);
        response.put(BODY, body);
        return response;
    }

    public Object success() {
        Map<String, Object> response = new HashMap<>();
        response.put(STATUS, 200);
        Map<String, Object> body = new HashMap<>();
        response.put(BODY, body);
        return response;
    }

    public Object filure(Object body) {
        Map<String, Object> response = new HashMap<>();
        response.put(STATUS, 500);
        response.put(BODY, body);
        return response;
    }

    public Object filure() {
        Map<String, Object> response = new HashMap<>();
        response.put(STATUS, 500);
        Map<String, Object> body = new HashMap<>();
        response.put(BODY, body);
        return response;
    }
}
