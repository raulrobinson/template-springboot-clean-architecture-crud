package com.rasysbox.ws.infrastructure;

import com.rasysbox.ws.application.service.UserService;
import com.rasysbox.ws.domain.User;
import com.rasysbox.ws.domain.dto.UserCreateDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Tag(name = "User", description = "Users Operations")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @Operation(summary = "Get all users", description = "Returns all users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get user by id", description = "Returns a user based on the ID provided")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    @Operation(summary = "Creates a new user", description = "Creates a new user")
    public User createUser(@RequestBody UserCreateDTO user) {
        return userService.createUser(user);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove a user", description = "Removes a user based on the ID provided")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a user", description = "Updates a user based on the ID provided")
    public User updateUser(@PathVariable Long id, @RequestBody UserCreateDTO user) {
        return userService.updateUser(id, user);
    }
}
