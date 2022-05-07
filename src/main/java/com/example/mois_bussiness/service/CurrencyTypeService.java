package com.example.mois_bussiness.service;

import com.example.mois_bussiness.domain.CurrencyType;
import com.example.mois_bussiness.exception.ObjectNotExistsException;
import com.example.mois_bussiness.repository.CurrencyTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CurrencyTypeService {

    private final CurrencyTypeRepository currencyTypeRepository;

    public CurrencyType getCurrencyType(Long id) {
        Optional<CurrencyType> currencyType = currencyTypeRepository.findById(id);

        if (!currencyType.isPresent())
            throw new ObjectNotExistsException("Currency type not exists");

        return currencyType.get();
    }

    public List<CurrencyType> getAllCurrencies() {
        return currencyTypeRepository.findAll();
    }
}
