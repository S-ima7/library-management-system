package com.example.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.library.model.Rental;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {
}
