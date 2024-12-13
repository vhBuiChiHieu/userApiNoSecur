package com.vhbcieu.user_api.user.dto.response;

import lombok.Getter;

@Getter
public enum UserApiStatus {
    GET_ALL_SUCCESS(true, "200",""),
    CREATE_USER_SUCCESS(true, "201","Create user success"),
    GET_USER_SUCCESS(true, "202","Get user success"),
    USER_NOT_FOUND(false, "404","User not found"),
    USER_ALREADY_EXISTS(false, "500","User already exists"),
    DELETE_USER_SUCCESS(true, "203","Delete user success"),
    UPDATE_USER_SUCCESS(true, "204","Update user success"),
    ;

    private final boolean success;
    private final String statusCode;
    private final String message;

    private UserApiStatus(boolean success, String statusCode, String message) {
        this.success = success;
        this.statusCode = statusCode;
        this.message = message;
    }

}
