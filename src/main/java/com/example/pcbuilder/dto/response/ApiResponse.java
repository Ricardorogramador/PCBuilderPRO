package com.example.pcbuilder.dto.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
public class ApiResponse<T> {
    private String message;
    private T data;

    public ApiResponse(String message, T data) {
        this.message = message;
        this.data = data;
    }

    public ApiResponse(ApiResponse<Object> objectApiResponse, HttpStatus httpStatus) {
    } //Dont know why this is needed, i used before that Handler class...

}
