package com.alevel.trucking.model.person.driver;

import java.util.Date;
import java.util.Set;

public class DriverLicense {
    private Long id;
    private Date dateOfRegistration;
    private Date dateOfFirstRegistration;
    private String typeOfProperty;
    private Date validity;
    private Set<Category> categorys;
}
