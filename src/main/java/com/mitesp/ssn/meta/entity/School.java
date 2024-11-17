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
@Table(name = "school")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE,region = "School")
public class School {
    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "divisional_education_officee_id", nullable = false)
    private DivisionalEducationOffice divisionalEducationOffice;

    private String name;
    private String i18nLocal;
}
