package com.example.mois_bussiness.data_loader;

import com.example.mois_bussiness.domain.OrderState;
import com.example.mois_bussiness.domain.TransportType;
import com.example.mois_bussiness.repository.OrderStateRepository;
import com.example.mois_bussiness.repository.TransportTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TransportTypeDataLoader implements CommandLineRunner {

    private final TransportTypeRepository transportTypeRepository;

    @Override
    public void run(String... args) throws Exception {
        loadTransportTypeData();
    }

    private void loadTransportTypeData() {
        if (transportTypeRepository.count() == 0) {
            TransportType transportType1 = new TransportType( 1l, "SamoDoprava", true);
            TransportType transportType2 = new TransportType( 2l, "Letadlo", true);
            TransportType transportType3 = new TransportType( 3l, "Autobus", true);
            TransportType transportType4 = new TransportType( 4l, "Vlak", true);
            TransportType transportType5 = new TransportType( 5l, "Autobus+Letadlo", true);
            TransportType transportType6 = new TransportType( 6l, "Autobus+Vlak", true);
            TransportType transportType7 = new TransportType( 7l, "Letadlo+Vlak", true);

            transportTypeRepository.save(transportType1);
            transportTypeRepository.save(transportType2);
            transportTypeRepository.save(transportType3);
            transportTypeRepository.save(transportType4);
            transportTypeRepository.save(transportType5);
            transportTypeRepository.save(transportType6);
            transportTypeRepository.save(transportType7);
        }
        System.out.println(transportTypeRepository.count());
    }
}
