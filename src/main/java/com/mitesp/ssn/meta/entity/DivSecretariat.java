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
@Table(name = "div_secretariat")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE,region = "DivSecretariat")
public class DivSecretariat {
    @Id
    private Integer id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "district_id", nullable = false)
    private District district;
    private String i18nLocal;
    private String divSecCode;
}
