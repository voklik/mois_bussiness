package com.example.mois_bussiness.service;

import com.example.mois_bussiness.domain.*;
import com.example.mois_bussiness.repository.OrderDestinationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderDestinationService {

    private final OrderDestinationRepository orderDestinationRepository;
    private final OrderStateService orderStateService;
    private final CurrencyTypeService currencyTypeService;
    private final OfferService offerService;

    public List<OrderDestination> getAllOrders() {
        return orderDestinationRepository.findAll();
    }

    public OrderDestination getOrderDestination(Long id) {
        return orderDestinationRepository.getById(id);
    }

    public OrderDestination createOrder(LocalDateTime dateOrder, double discount, double price,
                             Long currencyTypeId, Long orderStateId, Long offerId, Long userId) {
        OrderDestination orderDestination = new OrderDestination();
        orderDestination.setDateOrder(dateOrder);
        orderDestination.setDiscount(discount);
        orderDestination.setPrice(price);
        CurrencyType currencyType= currencyTypeService.getCurrencyType(currencyTypeId);
        orderDestination.setCurrencyType(currencyType);
        OrderState orderState = orderStateService.getOrderState(orderStateId);
        orderDestination.setOrderState(orderState);
        Offer offer = offerService.getOffer(offerId);
        orderDestination.setOffer(offer);
        orderDestination.setUserId(userId);

        try {
            orderDestinationRepository.save(orderDestination);
        } catch (Exception e) {
        }

        return orderDestination;
    }
}
