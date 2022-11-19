package com.DermApp.Backend.diagnostic.mapping;

import com.DermApp.Backend.diagnostic.domain.model.entity.File;
import com.DermApp.Backend.diagnostic.resource.CreateFileResource;
import com.DermApp.Backend.diagnostic.resource.FileResource;
import com.DermApp.Backend.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class FileMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public FileResource toResource(File model){
        return mapper.map(model, FileResource.class);
    }

    public File toModel(CreateFileResource resource){
        return mapper.map(resource, File.class);
    }



}
