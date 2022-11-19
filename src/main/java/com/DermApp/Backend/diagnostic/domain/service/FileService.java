package com.DermApp.Backend.diagnostic.domain.service;


import com.DermApp.Backend.diagnostic.domain.model.entity.File;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FileService {

    List<File> getAll();
    Page<File> getAll(Pageable pageable);
    File getById(Long fileId);
    File create(File file);
    ResponseEntity<?> delete(Long fileId);

}
