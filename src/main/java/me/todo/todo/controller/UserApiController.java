package me.todo.todo.controller;

import lombok.RequiredArgsConstructor;
import me.todo.todo.model.Address;
import me.todo.todo.model.User;
import me.todo.todo.repository.AddressRepository;
import me.todo.todo.repository.UserRepository;
import me.todo.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserApiController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getAllUser();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable("id") int id) {
        return userService.findByUserId(id);
    }

    @PostMapping("/users")
    public User createUser(@Valid @RequestBody User user) {
        return userService.saveUser(user);
    }

    @PutMapping("/users/{id}")
    public User updateUser(@Valid @RequestBody User user, @PathVariable("id") int id) {
        return userService.update(user, id);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity deleteUser(@PathVariable("id") Long id) {
        return userService.deleteById(id);
    }
}
