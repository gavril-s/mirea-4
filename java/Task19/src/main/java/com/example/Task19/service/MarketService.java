package com.example.Task19.service;


import com.example.Task19.Market;
import com.example.Task19.MarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarketService {

    private final MarketRepository marketRepository;

    @Autowired
    public MarketService(MarketRepository marketRepository) {
        this.marketRepository = marketRepository;
    }

    public Market createMarket(Market market) {
        return marketRepository.save(market);
    }

    public List<Market> getAllMarkets() {
        return marketRepository.findAll();
    }

    public void deleteMarket(Long id) {
        marketRepository.deleteById(id);
    }
}
