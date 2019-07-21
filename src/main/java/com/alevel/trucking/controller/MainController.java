package com.alevel.trucking.controller;

import com.alevel.trucking.dto.UserFormRegistration;
import com.alevel.trucking.model.user.User;
import com.alevel.trucking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class MainController {

    private final UserService userService;

    @Autowired
    public MainController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/reg")
    public ResponseEntity newUser(@RequestBody UserFormRegistration userDto) {
        User user = UserFormRegistration.fromUserDto(userDto);
        return ResponseEntity.ok(userService.save(user));
    }

    //TODO only for test
    @GetMapping()
    public ResponseEntity getAllUsers() {
        return ResponseEntity.ok(userService.getAllUser());
    }
}
