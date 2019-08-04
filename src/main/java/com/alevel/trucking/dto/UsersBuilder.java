package com.alevel.trucking.dto;

import com.alevel.trucking.model.person.customer.Customer;
import com.alevel.trucking.model.person.driver.Driver;
import com.alevel.trucking.model.person.manager.Manager;

public class UsersBuilder {

    public static Driver fromDto(DriverRegistrationForm driverRegistrationForm){
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
                .driverLicense(DriverLicenseDto.fromDto(driverRegistrationForm.getDriverLicenseDto()))
                .build();
    }

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

    public static Customer fromDto(CustomerRegistrationForm customerRegistrationForm) {
        return Customer.customerBuilder()
                .username(customerRegistrationForm.getUsername())
                .email(customerRegistrationForm.getEmail())
                .password(customerRegistrationForm.getPassword())
                .firstName(customerRegistrationForm.getFirstName())
                .secondName(customerRegistrationForm.getSecondName())
                .lastName(customerRegistrationForm.getLastName())
                .phone(customerRegistrationForm.getPhone())
                .isAccountNonExpired(true)
                .isAccountNonLocked(true)
                .isCredentialsNonExpired(true)
                .isEnabled(true)
                .build();
    }
}
