package com.alevel.trucking.dto;

import com.alevel.trucking.model.person.driver.Category;
import com.alevel.trucking.model.person.driver.DriverLicense;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class DriverLicenseDto implements Serializable {

    @PastOrPresent
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date dateOfRegistration;

    @PastOrPresent
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date dateOfFirstRegistration;

    @Future
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date validity;

    @NotNull
    private Set<Category> categories;

    public static DriverLicense fromDto(DriverLicenseDto driverLicenseDto) {
        return DriverLicense.builder()
                .dateOfFirstRegistration(driverLicenseDto.getDateOfFirstRegistration())
                .dateOfRegistration(driverLicenseDto.getDateOfRegistration())
                .validity(driverLicenseDto.getValidity())
                .categories(driverLicenseDto.getCategories())
                .build();
    }

    public Date getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(Date dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    public Date getDateOfFirstRegistration() {
        return dateOfFirstRegistration;
    }

    public void setDateOfFirstRegistration(Date dateOfFirstRegistration) {
        this.dateOfFirstRegistration = dateOfFirstRegistration;
    }

    public Date getValidity() {
        return validity;
    }

    public void setValidity(Date validity) {
        this.validity = validity;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
