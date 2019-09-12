package com.alevel.trucking.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;
import java.util.Date;

public class DriverRegistrationForm extends CustomerRegistrationForm {

    @NotBlank
    @Past
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date birthday;

    @NotBlank
    @PastOrPresent
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date startWork;

    @NotEmpty
    private DriverLicenseDto driverLicense;

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
