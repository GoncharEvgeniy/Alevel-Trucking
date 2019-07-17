package com.alevel.trucking.model.person.manager;

import com.alevel.trucking.model.person.Person;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

public class Manager extends Person {
    private Date startWork;
    private Date birthday;
}
