package com.example.mois_bussiness.service;

import com.example.mois_bussiness.domain.Address;
import com.example.mois_bussiness.dto.AddressDTO;
import com.example.mois_bussiness.dto.DestinationDTO;
import com.example.mois_bussiness.exception.InternalErrorException;
import com.example.mois_bussiness.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;

    public Address createAddress(AddressDTO addressDTO) {
        Address address = new Address();
        address.setPostCode(addressDTO.getPostCode());
        address.setCity(addressDTO.getCity());
        address.setStreet(addressDTO.getStreet());

        try {
            return addressRepository.save(address);
        } catch (Exception e) {
            throw new InternalErrorException("Internal error");
        }
    }
}
