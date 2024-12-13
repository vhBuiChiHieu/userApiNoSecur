package com.vhbcieu.user_api.exception;

import com.vhbcieu.user_api.user.dto.response.ApiResponse;
import com.vhbcieu.user_api.user.dto.response.UserApiStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ApiResponse> exceptionHandler(Exception e) {
        log.error(e.getMessage(), e);
        ApiResponse apiResponse = new ApiResponse(false, "500", "Internal Server Error", null);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiResponse);
    }

    //Handle User
    @ExceptionHandler(value = UserException.class)
    ResponseEntity<ApiResponse> userExceptionHandler(UserException e) {
        ApiResponse apiResponse = new ApiResponse(e.getUserApiStatus());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
    }

    //Invalid body data
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<ApiResponse> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        String key = e.getFieldError().getDefaultMessage();
        UserApiStatus userApiStatus =UserApiStatus.valueOf(key);
        ApiResponse apiResponse = new ApiResponse(userApiStatus);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse);
    }
}
