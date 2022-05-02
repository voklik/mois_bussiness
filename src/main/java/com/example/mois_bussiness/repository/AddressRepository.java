package com.example.mois_bussiness.repository;

import com.example.mois_bussiness.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    Address getById(Long aLong);
}
