package com.example.mois_bussiness.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "transporttype")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TransportType implements Serializable {

    @Id
    @Column(name = "IDTransport")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "Name")
    String name;

    @Column(name = "Actives")
    boolean active;
}
