package com.alevel.trucking.controller;

import com.alevel.trucking.dto.DriverRegistrationForm;
import com.alevel.trucking.dto.ManagerRegistrationForm;
import com.alevel.trucking.dto.UsersBuilder;
import com.alevel.trucking.model.person.driver.Driver;
import com.alevel.trucking.model.person.manager.Manager;
import com.alevel.trucking.service.driver.DriverService;
import com.alevel.trucking.service.manager.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final ManagerService managerService;

    private final DriverService driverService;

    @Autowired
    public AdminController(ManagerService managerService, DriverService driverService) {
        this.managerService = managerService;
        this.driverService = driverService;
    }

    @PostMapping("/new-manager")
    ResponseEntity createNewManager(@RequestBody ManagerRegistrationForm managerRegistrationForm) {
        Manager manager = UsersBuilder.fromDto(managerRegistrationForm);
        return ResponseEntity.ok(managerService.save(manager));
    }

    @PostMapping("/new-driver")
    ResponseEntity createNewDriver(@RequestBody DriverRegistrationForm driverRegistrationForm) {
        Driver driver = UsersBuilder.fromDto(driverRegistrationForm);
        return ResponseEntity.ok(driverService.save(driver));
    }
}
