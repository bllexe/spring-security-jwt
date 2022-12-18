package com.tigris.springsecurityjwt.controller;

import com.tigris.springsecurityjwt.entities.User;
import com.tigris.springsecurityjwt.modal.UserResponse;
import com.tigris.springsecurityjwt.service.impl.UserServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserServiceImp userService;

    public UserController(UserServiceImp userService) {
        this.userService = userService;
    }

    @GetMapping
    List<UserResponse> getAllUsers(){
        return userService.getAllUser().stream().map(UserResponse::new).collect(Collectors.toList());
        //user bilgisi gelmezse burayi kontrol et ???
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody User newUser){
        User user=userService.save(newUser);
        if(user !=null){
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/{userId}")
    public UserResponse getUserById(@PathVariable Long userId) {
        User user = userService.getUserById(userId);
        if(user == null) {
            throw new UsernameNotFoundException("user not found");
        }
        return new UserResponse(user);
    }

    @DeleteMapping("/{userId}")
    public void deleteUserById(@PathVariable Long userId) {
        userService.delete(userId);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Void> UpdateUser(@PathVariable Long userId, @RequestBody User newUser) {
        User user = userService.updateUser(userId, newUser);
        if(user != null)
            return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
