package com.mitesp.ssn.meta.repository;



import com.mitesp.ssn.meta.entity.Branch;
import jakarta.persistence.QueryHint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;

import java.util.List;
import java.util.Optional;

public interface BranchRepository extends JpaRepository<Branch, Integer> {
    @QueryHints({@QueryHint(name = "org.hibernate.cacheable", value = "true")})
    List<Branch> findAllByBank_id(Integer bankId);

    Optional<Branch> findReferenceById(Integer id);
}