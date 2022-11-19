package com.DermApp.Backend.diagnostic.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class UpdatePatientResource {

    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String name;

    @Max(70)
    @Min(18)
    private int age;

    @Size(max = 240)
    private String address;

    @Size(max = 400)
    private String description;

    private String message;

    private String urlToImage;

    private String status;

    private String diagnostic;

    private String treatment;
}
