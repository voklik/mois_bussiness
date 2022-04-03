package com.example.mois_bussiness.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "country")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Country implements Serializable {

    @Id
    @Column(name = "IDCountry")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "Country")
    String country;

    @Column(name = "Code")
    String code;

    @Column(name = "Actives")
    boolean active;
}
