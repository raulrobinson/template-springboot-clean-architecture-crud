package com.rasysbox.crudspringboot.application.impl;

import com.rasysbox.crudspringboot.adapter.repository.JpaUserRepository;
import com.rasysbox.crudspringboot.adapter.persistence.UserJpaEntity;
import com.rasysbox.crudspringboot.application.service.UserService;
import com.rasysbox.crudspringboot.domain.User;
import com.rasysbox.crudspringboot.domain.dto.UserCreateDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final JpaUserRepository userRepository;

    @Autowired
    public UserServiceImpl(JpaUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll().stream()
                .map(entity -> new User(entity.getId(), entity.getName(), entity.getEmail()))
                .collect(Collectors.toList());
    }

    @Override
    public User getUserById(Long id) {
        UserJpaEntity entity = userRepository.findById(id).orElseThrow();
        return new User(entity.getId(), entity.getName(), entity.getEmail());
    }

    @Override
    public User createUser(UserCreateDTO user) {
        UserJpaEntity entity = new UserJpaEntity();
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        UserJpaEntity savedEntity = userRepository.save(entity);
        return new User(savedEntity.getId(), savedEntity.getName(), savedEntity.getEmail());
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User updateUser(Long id, UserCreateDTO user) {
        UserJpaEntity entity = userRepository.findById(id).orElseThrow();
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        UserJpaEntity savedEntity = userRepository.save(entity);
        return new User(savedEntity.getId(), savedEntity.getName(), savedEntity.getEmail());
    }
}
