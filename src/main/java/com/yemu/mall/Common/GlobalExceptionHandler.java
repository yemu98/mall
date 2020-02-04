package com.yemu.mall.Common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Response handleExceptions(Exception ex){
        return Response.error(ex.getMessage());
    }
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<Map<String, String>> handleValidationExceptions(
//            MethodArgumentNotValidException ex) {
//        Map<String, String> errors = new HashMap<>();
//        ex.getBindingResult().getAllErrors().forEach((error) -> {
//            String fieldName = ((FieldError) error).getField();
//            String errorMessage = error.getDefaultMessage();
//            errors.put(fieldName, errorMessage);
//        });
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
//    }
//    @ExceptionHandler(MissingServletRequestParameterException.class)
//    public ResponseEntity<String> missingParam(MissingServletRequestParameterException ex){
//        return ResponseEntity.ok("有信息未填写");
//    }
//    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
//    public Response<String> mismatch(MethodArgumentTypeMismatchException e){
//        return Response.error(e.getMessage());
//    }
//    @ExceptionHandler(IllegalStateException.class)
//    public Response<String> IllegalStateException(IllegalStateException e){
//        return Response.error(e.getMessage());
//    }
}