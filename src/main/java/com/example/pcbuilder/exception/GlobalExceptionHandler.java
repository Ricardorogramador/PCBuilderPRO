package com.example.pcbuilder.exception;

import com.example.pcbuilder.dto.response.ApiResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    public ApiResponse<ApiResponse<Void>> illegalArgumentHandler(IllegalArgumentException ex){
        return new ApiResponse<>(new ApiResponse<>(ex.getMessage(), null), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalStateException.class)
    public ApiResponse<ApiResponse<Void>> illegalStateHandler(IllegalStateException ex){
        return new ApiResponse<>(new ApiResponse<>(ex.getMessage(), null), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResponse<ApiResponse<Void>> methodArgumentHandler(MethodArgumentNotValidException ex){
        String errorMessage = ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
        return new ApiResponse<>(new ApiResponse<>(errorMessage,null), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ApiResponse<ApiResponse<Void>> dataIntegrityHandler(){
        return new ApiResponse<>(new ApiResponse<>("Duplicated values", null), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ApiResponse<ApiResponse<Void>> typeMismatchHandler(MethodArgumentTypeMismatchException ex){
        String message = "Invalid value for parameter: " + ex.getMessage();
        return new ApiResponse<>(new ApiResponse<>(message, null), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ApiResponse<Void>> notFoundHandler(NoSuchElementException ex){
        return new ResponseEntity<>(new ApiResponse<>(ex.getMessage(), null), HttpStatus.NOT_FOUND);
    }
}
