package com.example.task23;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MarketRepository extends JpaRepository<Market, Long> {
    @Query("SELECT DISTINCT m FROM Market m JOIN FETCH m.products")
    List<Market> findAllWithProducts();
}
