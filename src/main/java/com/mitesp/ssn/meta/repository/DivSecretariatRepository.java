package com.mitesp.ssn.meta.repository;


import com.mitesp.ssn.meta.entity.DivSecretariat;
import com.mitesp.ssn.meta.model.MetaDataDTO;
import jakarta.persistence.QueryHint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DivSecretariatRepository extends JpaRepository<DivSecretariat, Integer> {

    @Query("SELECT new com.mitesp.ssn.meta.model.MetaDataDTO(" +
            "p.id, " +
            "COALESCE(pl.localVal, p.name) " +
            ") " +
            "FROM DivSecretariat p " +
            "LEFT JOIN DivSecretariatLocal pl ON p.id = pl.divSecretariat.id AND pl.lang = :lang " +
            "WHERE p.district.id = :districtId AND (:lang = 'en' OR pl.lang = :lang)")
    @QueryHints({@QueryHint(name = "org.hibernate.cacheable", value = "true")})
    List<MetaDataDTO> findAllDivsecsByLang(@Param("districtId") Integer districtId, @Param("lang") String lang);
}