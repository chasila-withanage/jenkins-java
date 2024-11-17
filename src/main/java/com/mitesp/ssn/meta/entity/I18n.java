package com.mitesp.ssn.meta.entity;

import com.mitesp.ssn.meta.model.ModuleName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "i18n")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE,region = "I18n")
public class I18n {

    @Id
    private Integer id;
    private String label;
    private String i18nLocal;
    private String localVal;
    @Enumerated(EnumType.STRING)
    private ModuleName module; // e.g., Vendor, Consumer
    private String description;
}
