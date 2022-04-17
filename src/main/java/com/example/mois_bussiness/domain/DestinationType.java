package com.example.mois_bussiness.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "destinationtype")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DestinationType implements Serializable {

    @Id
    @Column(name = "IDDestinationType")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "Name")
    String name;

    @Column(name = "Actives")
    String active;
}
