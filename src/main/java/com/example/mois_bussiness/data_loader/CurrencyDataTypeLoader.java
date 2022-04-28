package com.example.mois_bussiness.data_loader;

import com.example.mois_bussiness.domain.CurrencyType;
import com.example.mois_bussiness.repository.CurrencyTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CurrencyDataTypeLoader implements CommandLineRunner {

    private final CurrencyTypeRepository currencyTypeRepository;

    @Override
    public void run(String... args) throws Exception {
        loadCurrencyTypeData();
    }

    private void loadCurrencyTypeData() {
        if (currencyTypeRepository.count() == 0) {
            CurrencyType currencyType1 = new CurrencyType( 1l, "CZK", true);
            CurrencyType currencyType2 = new CurrencyType( 2l, "EUR", true);
            CurrencyType currencyType3 = new CurrencyType( 3l, "USD", true);
            CurrencyType currencyType4 = new CurrencyType( 4l, "GBP", true);
            CurrencyType currencyType5 = new CurrencyType( 5l, "JPY", true);
            CurrencyType currencyType6 = new CurrencyType( 6l, "RUB", true);

            currencyTypeRepository.save(currencyType1);
            currencyTypeRepository.save(currencyType2);
            currencyTypeRepository.save(currencyType3);
            currencyTypeRepository.save(currencyType4);
            currencyTypeRepository.save(currencyType5);
            currencyTypeRepository.save(currencyType6);
        }
        System.out.println(currencyTypeRepository.count());
    }
}
