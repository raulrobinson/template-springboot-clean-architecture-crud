package com.rasysbox.ws.application.service;

import com.rasysbox.ws.domain.User;
import com.rasysbox.ws.domain.dto.UserCreateDTO;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(Long id);

    User createUser(UserCreateDTO user);

    void deleteUser(Long id);

    User updateUser(Long id, UserCreateDTO user);
}
