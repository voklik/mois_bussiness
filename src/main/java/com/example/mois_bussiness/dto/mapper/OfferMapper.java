package com.example.mois_bussiness.dto.mapper;

import com.example.mois_bussiness.domain.Offer;
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

        CurrencyTypeDTO currencyTypeDTO = new CurrencyTypeDTO();
        currencyTypeDTO.setId(offer.getCurrencyType().getId());
        currencyTypeDTO.setName(offer.getCurrencyType().getName());

        offerDTO.setCurrencyType(currencyTypeDTO);

        FoodTypeDTO foodTypeDTO = new FoodTypeDTO();
        foodTypeDTO.setId(offer.getFoodType().getId());
        foodTypeDTO.setName(offer.getFoodType().getName());

        offerDTO.setFoodType(foodTypeDTO);

        TransportTypeDTO transportTypeDTO = new TransportTypeDTO();
        transportTypeDTO.setId(offer.getTransportType().getId());
        transportTypeDTO.setName(offer.getTransportType().getName());

        offerDTO.setTransportType(transportTypeDTO);

        DestinationDTO destinationDTO = new DestinationDTO();
        destinationDTO.setId(offer.getDestination().getId());
        destinationDTO.setName(offer.getDestination().getName());

        offerDTO.setDestination(destinationDTO);

        return offerDTO;
    }
}
