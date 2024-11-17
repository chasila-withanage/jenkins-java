package com.mitesp.ssn.meta.repository;

import com.mitesp.ssn.meta.entity.ZonalEducationOffice;
import com.mitesp.ssn.meta.model.MetaDataDTO;
import jakarta.persistence.QueryHint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ZonalEducationOfficeRepository extends JpaRepository<ZonalEducationOffice, Integer> {

    @Query("SELECT new com.mitesp.ssn.meta.model.MetaDataDTO(" +
            "p.id, " +
            "COALESCE(pl.localVal, p.name) " +
            ") " +
            "FROM ZonalEducationOffice p " +
            "LEFT JOIN ZonalEducationOfficeLocal pl ON p.id = pl.zonalEducationOffice.id AND pl.lang = :lang " +
            "WHERE (:lang = 'en' OR pl.lang = :lang)")
    @QueryHints({@QueryHint(name = "org.hibernate.cacheable", value = "true")})
    List<MetaDataDTO> findAllZonalEdusByLang(@Param("lang") String lang);
}