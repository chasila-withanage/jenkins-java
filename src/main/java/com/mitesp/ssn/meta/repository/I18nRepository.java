package com.mitesp.ssn.meta.repository;

import com.mitesp.ssn.meta.entity.I18n;
import com.mitesp.ssn.meta.model.ModuleName;
import jakarta.persistence.QueryHint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;

import java.util.List;

public interface I18nRepository extends JpaRepository<I18n, Integer> {
    @QueryHints({@QueryHint(name = "org.hibernate.cacheable", value = "true")})
    List<I18n> findAllByi18nLocalAndModule(String local, ModuleName module);
}