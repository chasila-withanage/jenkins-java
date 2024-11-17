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
@Table(name = "divisional_education_office_local")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE,region = "DivisionalEducationOfficeLocal")
public class DivisionalEducationOfficeLocal {
    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "divisional_education_office_id", nullable = false)
    private DivisionalEducationOffice divisionalEducationOffice;
    private String lang;
    private String localVal;
}
