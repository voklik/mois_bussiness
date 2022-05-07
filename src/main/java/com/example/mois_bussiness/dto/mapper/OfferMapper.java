package com.example.mois_bussiness.dto.mapper;

import com.example.mois_bussiness.domain.CurrencyType;
import com.example.mois_bussiness.domain.FoodType;
import com.example.mois_bussiness.domain.Offer;
import com.example.mois_bussiness.domain.TransportType;
import com.example.mois_bussiness.dto.*;
import org.springframework.stereotype.Component;


@Component
public class OfferMapper {

    public OfferDTO offerToDTO(Offer offer) {
        OfferDTO offerDTO = new OfferDTO();
        offerDTO.setId(offer.getId());
        offerDTO.setActive(offer.isActive());
        offerDTO.setCapacity(offer.getCapacity());
        offerDTO.setDateAction(offer.getDateAction());
        offerDTO.setDateExpiration(offer.getDateExpiration());
        offerDTO.setDayStart(offer.getDayStart());
        offerDTO.setDayEnd(offer.getDayEnd());
        offerDTO.setDescription(offer.getDescription());
        offerDTO.setPrice(offer.getPrice());

        CurrencyType currencyType = new CurrencyType();
        currencyType.setId(offer.getCurrencyType().getId());
        currencyType.setName(offer.getCurrencyType().getName());

        offerDTO.setCurrencyType(currencyType);

        FoodType foodType = new FoodType();
        foodType.setId(offer.getFoodType().getId());
        foodType.setName(offer.getFoodType().getName());

        offerDTO.setFoodType(foodType);

        TransportType transportType = new TransportType();
        transportType.setId(offer.getTransportType().getId());
        transportType.setName(offer.getTransportType().getName());

        offerDTO.setTransportType(transportType);

        DestinationDTO destinationDTO = new DestinationDTO();
        destinationDTO.setId(offer.getDestination().getId());
        destinationDTO.setName(offer.getDestination().getName());

        offerDTO.setDestination(destinationDTO);

        return offerDTO;
    }
}
