package com.mitesp.ssn.meta.repository;


import com.mitesp.ssn.meta.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface GradeRepository extends JpaRepository<Grade, Integer> {

}