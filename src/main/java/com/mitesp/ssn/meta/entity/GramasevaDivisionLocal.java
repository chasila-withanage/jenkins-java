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
@Table(name = "gramaseva_division_local")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE,region = "GramasevaDivisionLocal")
public class GramasevaDivisionLocal {
    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "gramaseva_division_id", nullable = false)
    private GramasevaDivision gramasevaDivision;

    private String lang;
    private String localVal;
}
