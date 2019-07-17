package com.alevel.trucking.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @PostMapping("/new-manager")
    ResponseEntity createNewManager(){
        return null;
    }

    @PostMapping("/new-driver")
    ResponseEntity createNewDriver(){
        return null;
    }
}
