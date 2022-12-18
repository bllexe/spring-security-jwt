package com.tigris.springsecurityjwt.service;

import com.tigris.springsecurityjwt.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public List<User> getAllUser();
    public User save(User user);

    public User getUserById(Long userId);

    public void delete(Long userId);

    public User updateUser(Long userId,User user);

    public User getUserByUsername(String userName);

}
