package com.DermApp.Backend.diagnostic.resource;


import lombok.*;


@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class DermatologistResource {
    private Long id;
    private String name;
    private int age;
    private String gender;
    private String specialty;
    private String address;
    private String description;
    private String message;
    private String urlToImage;
}
