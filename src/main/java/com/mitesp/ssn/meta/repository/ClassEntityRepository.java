package com.mitesp.ssn.meta.repository;


import com.mitesp.ssn.meta.entity.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClassEntityRepository extends JpaRepository<ClassEntity, Integer> {
}