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
@Table(name = "divisional_education_office")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE,region = "DivisionalEducationOffice")
public class DivisionalEducationOffice {
    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "zonal_education_office_id", nullable = false)
    private ZonalEducationOffice zonalEducationOffice;

    private String name;
    private String i18nLocal;
}
