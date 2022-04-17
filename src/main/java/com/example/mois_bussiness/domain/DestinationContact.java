package com.example.mois_bussiness.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "destinationcontact")
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DestinationContact implements Serializable {

    @Id
    @Column(name = "IDDestinationContact")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "value")
    String value;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
    @JoinColumn(name = "IDContact", referencedColumnName = "idContact")
    Contact contact;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
    @JoinColumn(name = "IDDestination", referencedColumnName = "IDDestination")
    Destination destination;
}
