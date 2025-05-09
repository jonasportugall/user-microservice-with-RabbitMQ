package com.microservice.user.controllers;

import com.microservice.user.dtos.UserRecordDto;
import com.microservice.user.entities.User;
import com.microservice.user.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/api/users")
    public ResponseEntity<User> addUser(@RequestBody @Valid UserRecordDto userRecordDto){
        User user = new User();
        BeanUtils.copyProperties( userRecordDto , user );
        return ResponseEntity.status(HttpStatus.CREATED).body( userService.addUser(user) );
    }


}
