package com.DermApp.Backend.security.domain.model.entity;

import com.DermApp.Backend.shared.domain.model.AuditModel;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

public class Dermatologist extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank
    @NotNull
    @Size(max = 50)
    @Column(unique = true)
    private String username;

    @NotNull
    @NotBlank
    @Size(max = 50)
    @Column(unique = true)
    @Email
    private String email;


    @NotBlank
    @Size
    private String password;

//
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "user_roles",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id"))
//    private Set<Role> roles = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "dermatologist_patients",
            joinColumns = @JoinColumn(name ="dermatologist_id"),
            inverseJoinColumns = @JoinColumn(name = "patient_id"))
    private Set<Patient> patients = new HashSet<>();



    public Dermatologist(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
