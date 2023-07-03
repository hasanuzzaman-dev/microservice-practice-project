package dev.hasan.userservice.controller;

import dev.hasan.userservice.entities.User;
import dev.hasan.userservice.payload.ApiResponse;
import dev.hasan.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userService.saveUser(user);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedUser);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId) {
        User user = userService.getUserById(userId);
        return ResponseEntity.status(HttpStatus.FOUND).body(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        List<User> allUser = userService.getAllUser();

        if (allUser.isEmpty()){
            return ResponseEntity.status(HttpStatus.FOUND).body(allUser);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(allUser);
    }
}
