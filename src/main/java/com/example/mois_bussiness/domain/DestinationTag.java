package com.example.mois_bussiness.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "destinationtag")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DestinationTag implements Serializable {

    @Id
    @Column(name = "IDDestinationTag")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
    @JoinColumn(name = "IDTag", referencedColumnName = "IDTag")
    Tag tag;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
    @JoinColumn(name = "IDDestination", referencedColumnName = "IDDestination")
    Destination destination;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
    @JoinColumn(name = "IDOffer", referencedColumnName = "IDOffer")
    Offer offer;
}
