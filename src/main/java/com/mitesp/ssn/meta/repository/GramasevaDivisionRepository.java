package com.mitesp.ssn.meta.repository;



import com.mitesp.ssn.meta.entity.GramasevaDivision;
import com.mitesp.ssn.meta.model.MetaDataDTO;
import jakarta.persistence.QueryHint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface GramasevaDivisionRepository extends JpaRepository<GramasevaDivision, Integer> {

    @Query("SELECT new com.mitesp.ssn.meta.model.MetaDataDTO(" +
            "p.id, " +
            "COALESCE(pl.localVal, p.name) " +
            ") " +
            "FROM GramasevaDivision p " +
            "LEFT JOIN GramasevaDivisionLocal pl ON p.id = pl.gramasevaDivision.id AND pl.lang = :lang " +
            "WHERE p.divSecretariat.id = :divSecId AND (:lang = 'en' OR pl.lang = :lang)")
    @QueryHints({@QueryHint(name = "org.hibernate.cacheable", value = "true")})
    List<MetaDataDTO> findAllGsByLang(@Param("divSecId") Integer divSecId, @Param("lang") String lang);


}