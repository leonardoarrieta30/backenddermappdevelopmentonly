package com.DermApp.Backend.diagnostic.domain.persistence;

import com.DermApp.Backend.diagnostic.domain.model.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {
    File findFileById(Long fileId);
}
