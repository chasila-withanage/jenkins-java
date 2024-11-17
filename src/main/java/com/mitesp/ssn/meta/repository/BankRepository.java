package com.mitesp.ssn.meta.repository;



import com.mitesp.ssn.meta.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BankRepository extends JpaRepository<Bank, Integer> {
    Optional<Bank> findReferenceById(Integer id);
}