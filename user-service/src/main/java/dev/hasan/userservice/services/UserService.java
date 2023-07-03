package dev.hasan.userservice.services;

import dev.hasan.userservice.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    User saveUser(User user);

    List<User> getAllUser();
    User getUserById(String userId);

    User deleteUserById(String userId);
    User updateUser(User user);

}
