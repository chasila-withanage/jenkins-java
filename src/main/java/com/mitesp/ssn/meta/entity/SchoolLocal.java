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
@Table(name = "school_local")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE,region = "SchoolLocal")
public class SchoolLocal {
    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "school_id", nullable = false)
    private School school;
    private String lang;
    private String localVal;
}
