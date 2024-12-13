package com.vhbcieu.user_api.user.service;

import com.vhbcieu.user_api.exception.UserException;
import com.vhbcieu.user_api.user.dto.request.UserCreateRequest;
import com.vhbcieu.user_api.user.dto.request.UserUpdateRequest;
import com.vhbcieu.user_api.user.dto.response.UserApiStatus;
import com.vhbcieu.user_api.user.entity.User;
import com.vhbcieu.user_api.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //create
    public User createUser(UserCreateRequest request) {
        if (isUsernameExist(request.getUsername()))
            throw new UserException(UserApiStatus.USER_ALREADY_EXISTS);
        User user = User.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .fullName(request.getFullName())
                .gender(request.getGender())
                .birthday(request.getBirthday())
                .phone(request.getPhone())
                .build();
        return userRepository.save(user);
    }

    //update
    public User updateUser(String id, UserUpdateRequest request) {
        User existedUser = userRepository.findById(id).orElseThrow(() -> new UserException(UserApiStatus.USER_NOT_FOUND));
        existedUser.setPassword(request.getPassword());
        existedUser.setFullName(request.getFullName());
        existedUser.setGender(request.getGender());
        existedUser.setBirthday(request.getBirthday());
        existedUser.setPhone(request.getPhone());

        return userRepository.save(existedUser);
    }

    //get
    public User findUserById(String id) {
        return userRepository.findById(id).orElseThrow(() -> new UserException(UserApiStatus.USER_NOT_FOUND));
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    //Delete
    public void deleteUser(String id) {
        User user = findUserById(id);
        userRepository.delete(user);
    }

    //
    public boolean isUsernameExist(String username) {
        return userRepository.existsByUsername(username);
    }
}
