package com.example.mois_bussiness.dto.mapper;

import com.example.mois_bussiness.domain.CurrencyType;
import com.example.mois_bussiness.domain.OrderDestination;
import com.example.mois_bussiness.domain.OrderState;
import com.example.mois_bussiness.dto.OfferDTO;
import com.example.mois_bussiness.dto.OrderDestinationDTO;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public OrderDestinationDTO orderDestinationToDTO(OrderDestination orderDestination) {
        OrderDestinationDTO orderDestinationDTO = new OrderDestinationDTO();
        orderDestinationDTO.setId(orderDestination.getId());
        orderDestinationDTO.setUserId(orderDestination.getUserId());
        orderDestinationDTO.setDateOrder(orderDestination.getDateOrder());
        orderDestinationDTO.setPrice(orderDestination.getPrice());

        CurrencyType currencyType = new CurrencyType();
        currencyType.setId(orderDestination.getCurrencyType().getId());
        currencyType.setName(orderDestination.getCurrencyType().getName());

        orderDestinationDTO.setCurrencyType(currencyType);

        OrderState orderState = new OrderState();
        orderState.setId(orderDestination.getOrderState().getId());
        orderState.setName(orderDestination.getOrderState().getName());

        orderDestinationDTO.setOrderState(orderState);

        OfferDTO offerDTO = new OfferDTO();
        offerDTO.setId(orderDestination.getOffer().getId());

        orderDestinationDTO.setOffer(offerDTO);

        return orderDestinationDTO;
    }
}
