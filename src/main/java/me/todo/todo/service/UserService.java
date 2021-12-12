package me.todo.todo.service;

import me.todo.todo.entity.User;
import me.todo.todo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User findByUserId(int userId) {
        return userRepository.findById(userId);
    }

    public User update(User user, int userId) {
        User us = userRepository.findById(userId);
        us.setLastName(user.getLastName());
        us.setFirstName(user.getFirstName());
        us.setUsername(user.getUsername());
        us.setEmail(user.getEmail());
        userRepository.save(us);
        return us;
    }

    public ResponseEntity deleteById(Long userId){
        userRepository.deleteById(userId);
        return ResponseEntity.ok().build();
    }
}
