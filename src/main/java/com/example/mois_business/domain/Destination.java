package com.example.mois_business.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "destination")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Destination {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDDestination")
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Actives")
    private boolean active;

    @Column(name = "Text")
    private String text;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
    @JoinColumn(name = "IDAddress", referencedColumnName = "IDAddress")
    private Address address;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
    @JoinColumn(name = "IDCountry", referencedColumnName = "IDCountry")
    private Country country;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
    @JoinColumn(name = "IDType", referencedColumnName = "IDDestinationType")
    private DestinationType destinationType;
}
