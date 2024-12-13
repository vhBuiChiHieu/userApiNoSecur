package com.vhbcieu.user_api.user.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserCreateRequest {

    @Size(min = 5, max = 20, message = "USERNAME_INVALID")
    private String username;
    @Size(min = 5, max = 20, message = "PASSWORD_INVALID")
    private String password;
    private String fullName;
    private String gender;
    private LocalDate birthday;
    private String phone;

}
