package com.DermApp.Backend.diagnostic.service;

import com.DermApp.Backend.diagnostic.domain.model.entity.File;
import com.DermApp.Backend.diagnostic.domain.persistence.FileRepository;
import com.DermApp.Backend.diagnostic.domain.service.FileService;
import com.DermApp.Backend.shared.exception.ResourceNotFoundException;
import com.DermApp.Backend.shared.exception.ResourceValidationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;


@Service
public class FileServiceImpl implements FileService {

    private static final String ENTITY = "File";
    private final FileRepository fileRepository;
    private final Validator validator;

    public FileServiceImpl(FileRepository fileRepository, Validator validator) {
        this.fileRepository = fileRepository;
        this.validator = validator;
    }


    @Override
    public List<File> getAll() {
        return fileRepository.findAll();
    }

    @Override
    public Page<File> getAll(Pageable pageable) {
        return fileRepository.findAll(pageable);
    }

    @Override
    public File getById(Long fileId) {
        return fileRepository.findById(fileId)
                .orElseThrow(()->new ResourceNotFoundException(ENTITY,fileId));
    }

    @Override
    public File create(File file) {
        Set<ConstraintViolation<File>> violations = validator.validate(file);

        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);


        return fileRepository.save(file);

    }

//    @Override
//    public File update(Long fileId, File request) {
//        Set<ConstraintViolation<File>> violations = validator.validate(request);
//
//        if(!violations.isEmpty())
//            throw new ResourceValidationException(ENTITY, violations);
//
//        return fileRepository.findById(fileId).
//
//
//    }

//    @Override
//    public ResponseEntity<?> delete(Long fileId) {
//        return fileRepository.findById(fileId).map(file -> {
//            fileRepository.delete(file);
//            return ResponseEntity.ok().build();
//        }).orElseThrow(()->new ResourceNotFoundException(ENTITY,fileId));
//    }
}
