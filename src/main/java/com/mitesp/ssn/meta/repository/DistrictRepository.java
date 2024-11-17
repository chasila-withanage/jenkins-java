package com.mitesp.ssn.meta.repository;


import com.mitesp.ssn.meta.entity.District;
import com.mitesp.ssn.meta.model.MetaDataDTO;
import jakarta.persistence.QueryHint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DistrictRepository extends JpaRepository<District, Integer> {

    @Query("SELECT new com.mitesp.ssn.meta.model.MetaDataDTO(" +
            "p.id, " +
            "COALESCE(pl.localVal, p.districtName) " +
            ") " +
            "FROM District p " +
            "LEFT JOIN DistrictLocal pl ON p.id = pl.district.id AND pl.lang = :lang " +
            "WHERE (:lang = 'en' OR pl.lang = :lang)")
    @QueryHints({@QueryHint(name = "org.hibernate.cacheable", value = "true")})
    List<MetaDataDTO> findAllDistrictsByLang(@Param("lang") String lang);

}