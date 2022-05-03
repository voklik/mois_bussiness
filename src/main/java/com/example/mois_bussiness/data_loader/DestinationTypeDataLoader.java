package com.example.mois_bussiness.data_loader;

import com.example.mois_bussiness.domain.DestinationType;
import com.example.mois_bussiness.repository.DestinationTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DestinationTypeDataLoader implements CommandLineRunner {

    private final DestinationTypeRepository destinationTypeRepository;

    @Override
    public void run(String... args) throws Exception {
        loadDestinationTypeData();
    }

    private void loadDestinationTypeData() {
        if (destinationTypeRepository.count() == 0) {
            DestinationType destinationType1 = new DestinationType( 1l, "Hotel");
            DestinationType destinationType2 = new DestinationType( 2l, "Penzion");
            DestinationType destinationType3 = new DestinationType( 3l, "Zájezd");
            DestinationType destinationType4 = new DestinationType( 4l, "Zábavní park");
            DestinationType destinationType5 = new DestinationType( 5l, "Bar");
            DestinationType destinationType6 = new DestinationType( 6l, "Divadlo");
            DestinationType destinationType7 = new DestinationType( 7l, "Událost");
            DestinationType destinationType8 = new DestinationType( 8l, "Speciální akce");
            DestinationType destinationType9 = new DestinationType( 9l, "Vzdělávací akce");

            destinationTypeRepository.save(destinationType1);
            destinationTypeRepository.save(destinationType2);
            destinationTypeRepository.save(destinationType3);
            destinationTypeRepository.save(destinationType4);
            destinationTypeRepository.save(destinationType5);
            destinationTypeRepository.save(destinationType6);
            destinationTypeRepository.save(destinationType7);
            destinationTypeRepository.save(destinationType8);
            destinationTypeRepository.save(destinationType9);
        }
        System.out.println(destinationTypeRepository.count());
    }
}
