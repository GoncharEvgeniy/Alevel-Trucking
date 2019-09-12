package com.alevel.trucking.dto;

import com.alevel.trucking.model.person.manager.Manager;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;
import java.util.Date;

public class ManagerRegistrationForm extends CustomerRegistrationForm {

    @Past
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date birthday;

    @PastOrPresent
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date startWork;

    public static Manager fromDto(ManagerRegistrationForm managerRegistrationForm) {
        return Manager.managerBuilder()
                .username(managerRegistrationForm.getUsername())
                .email(managerRegistrationForm.getEmail())
                .password(managerRegistrationForm.getPassword())
                .firstName(managerRegistrationForm.getFirstName())
                .secondName(managerRegistrationForm.getSecondName())
                .lastName(managerRegistrationForm.getLastName())
                .phone(managerRegistrationForm.getPhone())
                .isAccountNonExpired(true)
                .isAccountNonLocked(true)
                .isCredentialsNonExpired(true)
                .isEnabled(true)
                .birthday(managerRegistrationForm.getBirthday())
                .startWork(managerRegistrationForm.getStartWork())
                .build();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getStartWork() {
        return startWork;
    }

    public void setStartWork(Date startWork) {
        this.startWork = startWork;
    }
}
