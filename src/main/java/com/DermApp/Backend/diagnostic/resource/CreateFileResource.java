package com.DermApp.Backend.diagnostic.resource;

import javax.validation.constraints.Size;

public class CreateFileResource {
    @Size(max = 400)
    private String urlToImage;
}
