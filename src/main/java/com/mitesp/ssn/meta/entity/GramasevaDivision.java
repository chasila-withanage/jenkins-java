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
@Table(name = "gramaseva_division")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE,region = "GramasevaDivision")
public class GramasevaDivision {
    @Id
    private Integer id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "div_sec_id", nullable = false)
    private DivSecretariat divSecretariat;
    private String i18nLocal;
    private String gramasevaDivisionCode;
}
