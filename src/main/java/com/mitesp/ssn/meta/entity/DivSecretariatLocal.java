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
@Table(name = "div_secretariat_local")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "DivSecretariatLocal")
public class DivSecretariatLocal {
    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "div_sec_id", nullable = false)
    private DivSecretariat divSecretariat;

    @Column(length = 5)
    private String lang;

    @Column(name = "local_val", length = 256)
    private String localVal;
}
