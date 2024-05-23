// MarketService.java
package com.example.task23;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional // Добавление аннотации Transactional
public class MarketService {

    private final MarketRepository marketRepository;

    @Autowired
    public MarketService(MarketRepository marketRepository) {
        this.marketRepository = marketRepository;
    }

    public Market createMarket(Market market) {
        Market savedMarket = marketRepository.save(market);
        return savedMarket;
    }

    public List<Market> getAllMarkets() {
        return marketRepository.findAll();
    }

    public void deleteMarket(Long id) {
        marketRepository.deleteById(id);
    }
}
