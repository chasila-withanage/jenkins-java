package com.mitesp.ssn.meta.repository;

import com.mitesp.ssn.meta.entity.School;
import com.mitesp.ssn.meta.model.MetaDataDTO;
import jakarta.persistence.QueryHint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface SchoolRepository extends JpaRepository<School, Integer> {

    @Query("SELECT new com.mitesp.ssn.meta.model.MetaDataDTO(" +
            "p.id, " +
            "COALESCE(pl.localVal, p.name) " +
            ") " +
            "FROM School p " +
            "LEFT JOIN SchoolLocal pl ON p.id = pl.school.id AND pl.lang = :lang " +
            "WHERE p.divisionalEducationOffice.id = :divId and (:lang = 'en' OR pl.lang = :lang)")
    @QueryHints({@QueryHint(name = "org.hibernate.cacheable", value = "true")})
    List<MetaDataDTO> findAllSchoolsByLang(@Param("divId") Integer divId, @Param("lang") String lang);
}