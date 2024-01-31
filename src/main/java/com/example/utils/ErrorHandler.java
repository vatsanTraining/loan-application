package com.example.utils;

import com.example.model.ErrorMessage;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.io.IOException;
import java.time.LocalDateTime;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(ElementNotFoundException.class)
    public ErrorMessage handleNotFound(Exception ex, WebRequest request){

        return new ErrorMessage("ERR-101",ex.getMessage(),
                LocalDateTime.now(),request.getDescription(false));
    }

    @ExceptionHandler(RuntimeException.class)
    public ErrorMessage handleRunTime(Exception ex, WebRequest request){

        return new ErrorMessage("ERR-111",ex.getMessage(),
                LocalDateTime.now(),request.getDescription(false));
    }

    @ExceptionHandler(IOException.class)
    public ErrorMessage handleIoException(Exception ex, WebRequest request){

        return new ErrorMessage("ERR-123",ex.getMessage(),
                LocalDateTime.now(),request.getDescription(false));
    }
}
