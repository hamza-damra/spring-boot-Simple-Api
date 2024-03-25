package com.example.mystore.MyStore.repository;

import com.example.mystore.MyStore.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Address, Integer> {
}
