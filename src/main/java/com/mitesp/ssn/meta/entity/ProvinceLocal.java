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
@Table(name = "province_local")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE,region = "ProvinceLocal")
public class ProvinceLocal {
    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "province_id", nullable = false)
    private Province province;
    private String lang;
    private String localVal;

}
