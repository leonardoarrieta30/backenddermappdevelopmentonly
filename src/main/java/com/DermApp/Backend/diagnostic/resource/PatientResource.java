package com.DermApp.Backend.diagnostic.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class PatientResource {
    private Long id;
    private String name;
    private int age;
    private String address;
    private String description;

    private String message;

    private String urlToImage;

    private String status;

    private String diagnostic;

    private String treatment;
}
