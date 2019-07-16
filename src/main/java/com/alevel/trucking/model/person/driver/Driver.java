package com.alevel.trucking.model.person.driver;

import com.alevel.trucking.model.person.Person;

import java.util.Date;

public class Driver extends Person {
    private Date startWork;
    private Date birthday;
    private DriverLicense driverLicense;
    private DriverStatus status;
}
