package com.example.mois_bussiness.data_loader;

import com.example.mois_bussiness.domain.OrderState;
import com.example.mois_bussiness.repository.OrderStateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderStateDataLoader implements CommandLineRunner {

    private final OrderStateRepository orderStateRepository;

    @Override
    public void run(String... args) throws Exception {
        loadOrderStateData();
    }

    private void loadOrderStateData() {
        if (orderStateRepository.count() == 0) {
            OrderState orderState1 = new OrderState( 1l, "Objednávka přijata", true);
            OrderState orderState2 = new OrderState( 2l, "Objednávka zaplacena", true);
            OrderState orderState3 = new OrderState( 3l, "Žádaná reklamace", true);
            OrderState orderState4 = new OrderState( 4l, "Dokončena reklamace", true);
            OrderState orderState5 = new OrderState( 5l, "Stornováno", true);
            OrderState orderState6 = new OrderState( 6l, "Připraveno", true);
            OrderState orderState7 = new OrderState( 7l, "Dokončeno", true);

            orderStateRepository.save(orderState1);
            orderStateRepository.save(orderState2);
            orderStateRepository.save(orderState3);
            orderStateRepository.save(orderState4);
            orderStateRepository.save(orderState5);
            orderStateRepository.save(orderState6);
            orderStateRepository.save(orderState7);
        }
        System.out.println(orderStateRepository.count());
    }
}
