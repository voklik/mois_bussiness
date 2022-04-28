package com.example.mois_bussiness.data_loader;

import com.example.mois_bussiness.domain.Contact;
import com.example.mois_bussiness.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ContactDataLoader implements CommandLineRunner {

    private final ContactRepository contactRepository;

    @Override
    public void run(String... args) throws Exception {
        loadContactData();
    }

    private void loadContactData() {
        if (contactRepository.count() == 0) {
            Contact contact1 = new Contact( 1l, "Telefon");
            Contact contact2 = new Contact(2l, "Email");
            Contact contact3 = new Contact(3l, "Mobil");
            contactRepository.save(contact1);
            contactRepository.save(contact2);
            contactRepository.save(contact3);
        }
        System.out.println(contactRepository.count());
    }
}
