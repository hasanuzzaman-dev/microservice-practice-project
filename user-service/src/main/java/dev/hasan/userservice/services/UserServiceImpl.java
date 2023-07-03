package dev.hasan.userservice.services;

import dev.hasan.userservice.entities.User;
import dev.hasan.userservice.exeptions.ResourceNotFoundException;
import dev.hasan.userservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Override
    public User saveUser(User user) {
        String randomUUID = UUID.randomUUID().toString();
        user.setUserId(randomUUID);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(String userId) {
        return userRepository.findById(userId)
                .orElseThrow( ()-> new ResourceNotFoundException("User with given id not found on the server!! : "+userId));
    }

    @Override
    public User deleteUserById(String userId) {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }
}
