package com.alevel.trucking.dto;

import com.alevel.trucking.model.person.driver.Driver;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;
import java.util.Date;

public class DriverRegistrationForm extends CustomerRegistrationForm {

    @Past
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date birthday;

    @PastOrPresent
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date startWork;

    @NotNull
    private DriverLicenseDto driverLicense;

    public static Driver fromDto(DriverRegistrationForm driverRegistrationForm) {
        return Driver.managerBuilder()
                .username(driverRegistrationForm.getUsername())
                .email(driverRegistrationForm.getEmail())
                .password(driverRegistrationForm.getPassword())
                .firstName(driverRegistrationForm.getFirstName())
                .secondName(driverRegistrationForm.getSecondName())
                .lastName(driverRegistrationForm.getLastName())
                .phone(driverRegistrationForm.getPhone())
                .isAccountNonExpired(true)
                .isAccountNonLocked(true)
                .isCredentialsNonExpired(true)
                .isEnabled(true)
                .birthday(driverRegistrationForm.getBirthday())
                .startWork(driverRegistrationForm.getStartWork())
                .driverLicense(DriverLicenseDto.fromDto(driverRegistrationForm.getDriverLicense()))
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

    public DriverLicenseDto getDriverLicense() {
        return driverLicense;
    }

    public void setDriverLicense(DriverLicenseDto driverLicense) {
        this.driverLicense = driverLicense;
    }
}
