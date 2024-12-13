package com.vhbcieu.user_api.exception;

import com.vhbcieu.user_api.user.dto.response.UserApiStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserException extends RuntimeException{

    private UserApiStatus userApiStatus;

}
