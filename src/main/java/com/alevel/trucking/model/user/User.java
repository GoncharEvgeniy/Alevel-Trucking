package com.alevel.trucking.model.user;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank
    @Size(min = 3, max = 50)
    @Column(name = "username", unique = true)
    private String username;

    @NotBlank
    @Size(min = 6, max = 100)
    @Column(name = "password")
    private String password;

    @NotBlank
    @Size(min = 3, max = 50)
    @Column(name = "first_name")
    private String firstName;

    @NotBlank
    @Size(min = 3, max = 50)
    @Column(name = "second_name")
    private String secondName;

    @NotBlank
    @Size(min = 3, max = 50)
    @Column(name = "last_name")
    private String lastName;

    @NotBlank
    @Size(max = 50)
    @Email
    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "phone", unique = true)
    private String phone;

    @Column(name = "status")
    private Status status;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private Set<Role> roles;
}
