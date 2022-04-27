package com.example.mois_bussiness.service;

import com.example.mois_bussiness.domain.Contact;
import com.example.mois_bussiness.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;

    public Contact getContact(Long id) {
        return contactRepository.getById(id);
    }

    public Contact getContactByName(String name) {
        return contactRepository.findByNameEquals(name);
    }
}
