package com.alevel.trucking.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class DriverRegistrationForm extends CustomerRegistrationForm {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date birthday;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date startWork;

    private DriverLicenseDto driverLicenseDto;

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

    public DriverLicenseDto getDriverLicenseDto() {
        return driverLicenseDto;
    }

    public void setDriverLicenseDto(DriverLicenseDto driverLicenseDto) {
        this.driverLicenseDto = driverLicenseDto;
    }
}
