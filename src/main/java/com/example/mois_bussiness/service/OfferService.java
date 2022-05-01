package com.example.mois_bussiness.service;

import com.example.mois_bussiness.domain.*;
import com.example.mois_bussiness.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OfferService {

    private final OfferRepository offerRepository;
    private final DestinationService destinationService;
    private final CurrencyTypeService currencyTypeService;
    private final FoodTypeService foodTypeService;
    private final TransportTypeService transportTypeService;

    public List<Offer> getAllOffers() {
        return offerRepository.findAll();
    }

    public Offer getOffer(Long id) {
        return offerRepository.getById(id);
    }

    public Offer createOffer(int capacity, LocalDateTime dateAction, LocalDateTime dateExpiration, LocalDateTime dayEnd,
                             LocalDateTime dayStart, String description, boolean isActive, double discount, double price,
                             Long currencyTypeId, Long foodTypeId, Long destinationId, Long transportTypeId) {
        Offer offer = new Offer();
        offer.setCapacity(capacity);
        offer.setActive(isActive);
        offer.setDateAction(dateAction);
        offer.setDateExpiration(dateExpiration);
        offer.setDayStart(dayStart);
        offer.setDayEnd(dayEnd);
        offer.setDescription(description);
        offer.setDiscount(discount);
        offer.setPrice(price);
        CurrencyType currencyType = currencyTypeService.getCurrencyType(currencyTypeId);
        offer.setCurrencyType(currencyType);
        FoodType foodType = foodTypeService.getFoodType(foodTypeId);
        offer.setFoodType(foodType);
        Destination destination = destinationService.getDestination(destinationId);
        offer.setDestination(destination);
        TransportType transportType = transportTypeService.getTransportType(transportTypeId);
        offer.setTransportType(transportType);

        try {
            offerRepository.save(offer);
        } catch (Exception e) {
        }

        return offer;
    }
}
