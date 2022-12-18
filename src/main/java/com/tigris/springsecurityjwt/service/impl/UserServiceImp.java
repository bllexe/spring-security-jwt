package com.tigris.springsecurityjwt.service.impl;

import com.tigris.springsecurityjwt.entities.User;
import com.tigris.springsecurityjwt.repo.UserRepository;
import com.tigris.springsecurityjwt.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).get();
    }

    @Override
    public void delete(Long userId) {
        //todo checking  exist user?
        userRepository.deleteById(userId);
    }

    @Override
    public User updateUser(Long userId, User user) {
       Optional<User> userDb=userRepository.findById(userId);
       if (userDb.isPresent()){
           User existUser=userDb.get();
           existUser.setUsername(user.getUsername());
           existUser.setPassword(user.getPassword());
           existUser.setCreateDate(new Date(System.currentTimeMillis()));
           return userRepository.save(existUser);
       }else
           return null;
    }

    @Override
    public User getUserByUsername(String userName) {
        return userRepository.findByUsername(userName);
    }
}
