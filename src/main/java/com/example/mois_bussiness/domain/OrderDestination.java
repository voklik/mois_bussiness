package com.example.mois_bussiness.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "orderdestination")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDestination implements Serializable {

    @Id
    @Column(name = "IDOrder")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "DateOrder")
    LocalDateTime dateOrder;

    @Column(name = "Price")
    double price;

    @Column(name = "discount")
    double discount;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
    @JoinColumn(name = "IDOffer", referencedColumnName = "IDOffer")
    Offer offer;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
    @JoinColumn(name = "IDOrderState", referencedColumnName = "IDState")
    OrderState OrderState;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
    @JoinColumn(name = "IDCurrency", referencedColumnName = "IDCurrency")
    CurrencyType currencyType;

    //TODO id correctly towards userService
}
