package com.example.mois_business.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "destinationtype")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DestinationType {

    @Id
    @Column(name = "IDDestinationType")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Actives")
    private String active;
}
