package com.mitesp.ssn.meta.repository;

import com.mitesp.ssn.meta.entity.DivisionalEducationOffice;
import com.mitesp.ssn.meta.model.MetaDataDTO;
import jakarta.persistence.QueryHint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface DivisionalEducationOfficeRepository extends JpaRepository<DivisionalEducationOffice, Integer> {

    @Query("SELECT new com.mitesp.ssn.meta.model.MetaDataDTO(" +
            "p.id, " +
            "COALESCE(pl.localVal, p.name) " +
            ") " +
            "FROM DivisionalEducationOffice p " +
            "LEFT JOIN DivisionalEducationOfficeLocal pl ON p.id = pl.divisionalEducationOffice.id AND pl.lang = :lang " +
            "WHERE p.zonalEducationOffice.id = :zonalId AND (:lang = 'en' OR pl.lang = :lang)")
    @QueryHints({@QueryHint(name = "org.hibernate.cacheable", value = "true")})
    List<MetaDataDTO> findAllDivSecByLang(@Param("zonalId") Integer zonalId, @Param("lang") String lang);

}