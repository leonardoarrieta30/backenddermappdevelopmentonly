package com.DermApp.Backend.diagnostic.mapping;

import com.DermApp.Backend.diagnostic.domain.model.entity.File;
import com.DermApp.Backend.diagnostic.domain.model.entity.Patient;
import com.DermApp.Backend.diagnostic.resource.CreateFileResource;
import com.DermApp.Backend.diagnostic.resource.FileResource;
import com.DermApp.Backend.diagnostic.resource.PatientResource;
import com.DermApp.Backend.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class FileMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public FileResource toResource(File model){
        return mapper.map(model, FileResource.class);
    }

    public File toModel(CreateFileResource resource){
        return mapper.map(resource, File.class);
    }

    public Page<FileResource> modelListPage(List<File> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList, FileResource.class), pageable, modelList.size());
    }

}
