package com.DermApp.Backend.diagnostic.domain.persistence;

import com.DermApp.Backend.diagnostic.domain.model.entity.Dermatologist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DermatologistRepository extends JpaRepository<Dermatologist, Long> {
    List<Dermatologist> findAllByAge(int age);

    Dermatologist findByName(String name);
}
