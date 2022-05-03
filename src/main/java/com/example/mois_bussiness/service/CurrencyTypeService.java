package com.example.mois_bussiness.service;

import com.example.mois_bussiness.domain.CurrencyType;
import com.example.mois_bussiness.repository.CurrencyTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrencyTypeService {

    private final CurrencyTypeRepository currencyTypeRepository;

    public CurrencyType getCurrencyType(Long id) {
        return currencyTypeRepository.getById(id);
    }

    public List<CurrencyType> getAllCurrencies() {
        return currencyTypeRepository.findAll();
    }
}
