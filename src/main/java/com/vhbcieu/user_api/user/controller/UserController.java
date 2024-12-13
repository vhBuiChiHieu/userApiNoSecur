package com.vhbcieu.user_api.user.controller;

import com.vhbcieu.user_api.user.dto.request.UserCreateRequest;
import com.vhbcieu.user_api.user.dto.request.UserUpdateRequest;
import com.vhbcieu.user_api.user.dto.response.ApiResponse;
import com.vhbcieu.user_api.user.dto.response.UserApiStatus;
import com.vhbcieu.user_api.user.entity.User;
import com.vhbcieu.user_api.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    //Get by id
    @GetMapping("/{userId}")
    public ApiResponse<User> getUserById(@PathVariable String userId) {
        User existedUser = userService.findUserById(userId);
        return new ApiResponse<>(UserApiStatus.GET_USER_SUCCESS, existedUser);
    }

    //Get All
    @GetMapping("")
    public ApiResponse<List<User>> getAllUsers() {
        List<User> users = userService.findAllUsers();
        return new ApiResponse<>(UserApiStatus.GET_USER_SUCCESS, users);
    }

    //Create
    @PostMapping()
    public ApiResponse<User> createUser(@RequestBody @Valid UserCreateRequest request) {
        User createdUser = userService.createUser(request);
        return new ApiResponse<>(UserApiStatus.CREATE_USER_SUCCESS, createdUser);
    }

    //Update
    @PutMapping("/{userId}")
    public ApiResponse<User> updateUser(@PathVariable String userId, @RequestBody @Valid UserUpdateRequest request) {
        User updatedUser = userService.updateUser(userId, request);
        return new ApiResponse<>(UserApiStatus.UPDATE_USER_SUCCESS, updatedUser);
    }

    //Delete
    @DeleteMapping("/{userId}")
    public ApiResponse<String> deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        return new ApiResponse<>(UserApiStatus.DELETE_USER_SUCCESS);
    }
}
