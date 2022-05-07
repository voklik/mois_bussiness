package com.example.mois_bussiness.service;

import com.example.mois_bussiness.domain.*;
import com.example.mois_bussiness.dto.OfferDTO;
import com.example.mois_bussiness.dto.mapper.OfferMapper;
import com.example.mois_bussiness.exception.InternalErrorException;
import com.example.mois_bussiness.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OfferService {

    private final OfferRepository offerRepository;
    private final DestinationService destinationService;
    private final CurrencyTypeService currencyTypeService;
    private final FoodTypeService foodTypeService;
    private final TransportTypeService transportTypeService;
    private final OfferMapper offerMapper;

    public Page<OfferDTO> getAllOffers(Pageable pageable) {

        Page<Offer> pageOffers = offerRepository.findAll(pageable);
        List<OfferDTO> offerDTOList = new ArrayList<>();
        List<Offer> offers = pageOffers.getContent();
        for (Offer offer : offers) {
            offerDTOList.add(offerMapper.offerToDTO(offer));
        }
        Page<OfferDTO> pageOfferDTO = new PageImpl<>(offerDTOList,
                pageable, offerDTOList.size());

        return pageOfferDTO;
    }

    public Offer getOffer(Long id) {
        return offerRepository.getById(id);
    }

    public Offer createOffer(OfferDTO offerDTO) {
        Offer offer = new Offer();
        offer.setCapacity(offerDTO.getCapacity());
        offer.setActive(offerDTO.isActive());
        offer.setDateAction(offerDTO.getDateAction());
        offer.setDateExpiration(offerDTO.getDateExpiration());
        offer.setDayStart(offerDTO.getDayStart());
        offer.setDayEnd(offerDTO.getDayEnd());
        offer.setDescription(offerDTO.getDescription());
        offer.setPrice(offerDTO.getPrice());
        CurrencyType currencyType = currencyTypeService.getCurrencyType(offerDTO.getCurrencyType().getId());
        offer.setCurrencyType(currencyType);
        FoodType foodType = foodTypeService.getFoodType(offerDTO.getFoodType().getId());
        offer.setFoodType(foodType);
        Destination destination = destinationService.getDestination(offerDTO.getDestination().getId());
        offer.setDestination(destination);
        TransportType transportType = transportTypeService.getTransportType(offerDTO.getTransportType().getId());
        offer.setTransportType(transportType);

        try {
            offerRepository.save(offer);
        } catch (Exception e) {
            throw new InternalErrorException("Internal error");
        }

        return offer;
    }
}
