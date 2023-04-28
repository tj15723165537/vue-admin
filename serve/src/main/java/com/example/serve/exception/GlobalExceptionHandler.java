package com.example.serve.exception;

import com.example.serve.utils.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author chenliang
 * @since 2022-10-31
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    public Response catchException(Exception e) {
        logger.error(e.getMessage());
        e.printStackTrace();
        return Response.error("服务器繁忙，请稍后再试！");
    }

    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.OK)
    public Response catchBusinessException(BusinessException e) {
        logger.error(e.getMessage());
        return Response.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.OK)
    public Response catchBindException(BindException e) {
        logger.error(e.getMessage());
        BindingResult bindingResult = e.getBindingResult();
        String errorMessage = bindingResult.getAllErrors().stream().map(s -> s.getDefaultMessage()).collect(Collectors.joining("\n"));
        return Response.error(errorMessage);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.OK)
    public Response catchMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        logger.error(e.getMessage());
        BindingResult bindingResult = e.getBindingResult();
        String errorMessage = bindingResult.getAllErrors().stream().map(s -> s.getDefaultMessage()).collect(Collectors.joining(";\n"));
        return Response.error(errorMessage);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.OK)
    public Response catchConstraintViolationException(ConstraintViolationException e) {
        logger.error(e.getMessage());
        Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
        String errorMessage = constraintViolations.stream().map(s -> s.getMessage()).collect(Collectors.joining("\n"));
        return Response.error(errorMessage);
    }

}

