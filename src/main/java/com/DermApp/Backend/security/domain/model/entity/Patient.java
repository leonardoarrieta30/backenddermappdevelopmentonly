package com.DermApp.Backend.security.domain.model.entity;

import com.DermApp.Backend.shared.domain.model.AuditModel;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Patient extends AuditModel {


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


    public Patient(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
