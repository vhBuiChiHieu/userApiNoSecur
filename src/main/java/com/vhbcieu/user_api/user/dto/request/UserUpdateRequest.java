package com.vhbcieu.user_api.user.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class UserUpdateRequest {

    @NotNull
    private String password;
    private String fullName;
    private String gender;
    private LocalDate birthday;
    private String phone;
}
