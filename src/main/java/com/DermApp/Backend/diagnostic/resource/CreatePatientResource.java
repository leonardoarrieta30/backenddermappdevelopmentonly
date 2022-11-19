package com.DermApp.Backend.diagnostic.resource;

import lombok.*;

import javax.validation.constraints.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CreatePatientResource {
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
}
