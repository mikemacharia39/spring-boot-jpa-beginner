package com.mikehenry.springbootjpabeginner.repository;

import com.mikehenry.springbootjpabeginner.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
