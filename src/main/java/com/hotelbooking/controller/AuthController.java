package com.hotelbooking.controller;

import com.hotelbooking.exception.UserAlreadyExistsException;
import com.hotelbooking.model.User;
import com.hotelbooking.service.IUserService;
import com.hotelbooking.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final IUserService userService;

    @PostMapping("/register-user")
    public ResponseEntity<?> registerUser(@RequestBody User user){
     try {
         userService.registerUser(user);
         return ResponseEntity.ok("User Registration Successfully..");
     }catch (UserAlreadyExistsException e){
         return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
     }
    }
}
