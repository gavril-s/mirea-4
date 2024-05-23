package com.example.Task15;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MarketController {
    @Autowired
    private MarketRepository marketRepository;

    @Autowired
    public MarketController(MarketRepository marketRepository) {
        this.marketRepository = marketRepository;
    }

    @PostMapping("/markets")
    public ResponseEntity<String> createMarket(@RequestBody Market market) {
        marketRepository.save(market);
        return ResponseEntity.status(HttpStatus.CREATED).body("Market created successfully");
    }

    @GetMapping("/markets")
    public ResponseEntity<List<Market>> getAllMarkets() {
        List<Market> markets = marketRepository.findAll();
        return ResponseEntity.ok(markets);
    }

    @DeleteMapping("/markets/{id}")
    public ResponseEntity<String> deleteMarket(@PathVariable Long id) {
        Optional<Market> optionalMarket = marketRepository.findById(id);
        if (optionalMarket.isPresent()) {
            marketRepository.deleteById(id);
            return ResponseEntity.ok("Market deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Market not found");
        }
    }




}

