package com.mitesp.ssn.meta.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "zonal_education_office_local")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE,region = "ZonalEducationOfficeLocal")
public class ZonalEducationOfficeLocal {
    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "zonal_education_office_id", nullable = false)
    private ZonalEducationOffice zonalEducationOffice;
    private String lang;
    private String localVal;
}
