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
@Table(name = "offer")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Offer implements Serializable {

    @Id
    @Column(name = "IDOffer")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "DateAction")
    LocalDateTime dateAction;

    @Column(name = "DateExpiration")
    LocalDateTime dateExpiration;

    @Column(name = "Number")
    int number;

    @Column(name = "NumberLeft")
    int numberLeft;

    @Column(name = "Text")
    String text;

    @Column(name = "DayStart")
    LocalDateTime dayStart;

    @Column(name = "DayEnd")
    LocalDateTime dayEnd;

    @Column(name = "price")
    double price;

    @Column(name = "Actives")
    boolean active;

    @Column(name = "Discount")
    double discount;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
    @JoinColumn(name = "IDDestination", referencedColumnName = "IDDestination")
    Destination destination;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
    @JoinColumn(name = "IDFood", referencedColumnName = "IDFood")
    FoodType foodType;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
    @JoinColumn(name = "IDCurrency", referencedColumnName = "IDCurrency")
    CurrencyType currencyType;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
    @JoinColumn(name = "IDTransport", referencedColumnName = "IDTransport")
    TransportType transportType;
}
