package com.example.mois_bussiness.dto.mapper;

import com.example.mois_bussiness.domain.OrderDestination;
import com.example.mois_bussiness.dto.CurrencyTypeDTO;
import com.example.mois_bussiness.dto.OfferDTO;
import com.example.mois_bussiness.dto.OrderDestinationDTO;
import com.example.mois_bussiness.dto.OrderStateDTO;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public OrderDestinationDTO orderDestinationToDTO(OrderDestination orderDestination) {
        OrderDestinationDTO orderDestinationDTO = new OrderDestinationDTO();
        orderDestinationDTO.setId(orderDestination.getId());
        orderDestinationDTO.setUserId(orderDestination.getUserId());
        orderDestinationDTO.setDateOrder(orderDestination.getDateOrder());
        orderDestinationDTO.setPrice(orderDestination.getPrice());

        CurrencyTypeDTO currencyTypeDTO = new CurrencyTypeDTO();
        currencyTypeDTO.setId(orderDestination.getCurrencyType().getId());
        currencyTypeDTO.setName(orderDestination.getCurrencyType().getName());

        orderDestinationDTO.setCurrencyType(currencyTypeDTO);

        OrderStateDTO orderStateDTO = new OrderStateDTO();
        orderStateDTO.setId(orderDestination.getOrderState().getId());
        orderStateDTO.setName(orderDestination.getOrderState().getName());

        orderDestinationDTO.setOrderState(orderStateDTO);

        OfferDTO offerDTO = new OfferDTO();
        offerDTO.setId(orderDestination.getOffer().getId());

        orderDestinationDTO.setOffer(offerDTO);

        return orderDestinationDTO;
    }
}
