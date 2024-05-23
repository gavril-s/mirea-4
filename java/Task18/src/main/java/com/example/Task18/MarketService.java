package com.example.Task18;


import com.example.Task18.Market;
import com.example.Task18.MarketRepository;
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
