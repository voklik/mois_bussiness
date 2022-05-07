package com.example.mois_bussiness.data_loader;

import com.example.mois_bussiness.domain.Address;
import com.example.mois_bussiness.domain.Destination;
import com.example.mois_bussiness.repository.DestinationRepository;
import com.example.mois_bussiness.repository.DestinationTagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DestinationDataLoader implements CommandLineRunner {

    private final DestinationRepository destinationRepository;

    @Override
    public void run(String... args) throws Exception {
        loadDestinationData();
    }

    private void loadDestinationData() {
        if (destinationRepository.count() == 0) {
            //Destination destination1 = new Destination( 1l, "hradec", true, "pekne to mistecko", Address, 2, 4);
            //Destination destination2 = new Destination(2l, "PCE", "235 12", "Nekde, 12");
            //destinationRepository.save(destination1);
            //destinationRepository.save(destination2);
        }
        System.out.println(destinationRepository.count());
    }
}
