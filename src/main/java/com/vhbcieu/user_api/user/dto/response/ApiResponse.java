package com.vhbcieu.user_api.user.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@AllArgsConstructor
public class ApiResponse <T>{

    private boolean success;
    private String statusCode;
    private String message;
    private T data;

    public ApiResponse(UserApiStatus userApiStatus, T data) {
        this.success = userApiStatus.isSuccess();
        this.statusCode = userApiStatus.getStatusCode();
        this.message = userApiStatus.getMessage();
        this.data = data;
    }

    public ApiResponse(UserApiStatus userApiStatus){
        this.success = userApiStatus.isSuccess();
        this.statusCode = userApiStatus.getStatusCode();
        this.message = userApiStatus.getMessage();
        this.data = null;
    }


}
