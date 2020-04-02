package com.yemu.mall.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常统一处理
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Response handleExceptions(Exception ex, HttpServletResponse response) {
        response.setStatus(HttpStatus.BAD_REQUEST.value());
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