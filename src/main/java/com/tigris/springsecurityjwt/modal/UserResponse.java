package com.tigris.springsecurityjwt.modal;

import com.tigris.springsecurityjwt.entities.User;
import lombok.Data;

@Data
public class UserResponse {

    private Long id;
    private String username;


    public UserResponse(User user){
        this.id=user.getId();
        this.username=user.getUsername();

    }
}
