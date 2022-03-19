package com.example.mois_business.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "destinationcontact")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DestinationContact {

    @Id
    @Column(name = "IDDestinationContact")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "value")
    private String value;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
    @JoinColumn(name = "IDContact", referencedColumnName = "idContact")
    private Contact contact;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
    @JoinColumn(name = "IDDestination", referencedColumnName = "IDDestination")
    private Destination destination;
}
