package com.rasysbox.crudspringboot.application.service;

import com.rasysbox.crudspringboot.domain.User;
import com.rasysbox.crudspringboot.domain.dto.UserCreateDTO;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(Long id);

    User createUser(UserCreateDTO user);

    void deleteUser(Long id);

    User updateUser(Long id, UserCreateDTO user);
}
