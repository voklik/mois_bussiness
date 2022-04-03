package com.example.mois_bussiness.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "orderstate")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderState implements Serializable {

    @Id
    @Column(name = "IDState")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "Name")
    String name;

    @Column(name = "Actives")
    boolean active;
}
