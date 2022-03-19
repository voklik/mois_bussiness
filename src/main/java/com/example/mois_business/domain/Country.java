package com.example.mois_business.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "country")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country {

    @Id
    @Column(name = "IDCountry")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Country")
    private String country;

    @Column(name = "Code")
    private String code;

    @Column(name = "Actives")
    private boolean active;
}
