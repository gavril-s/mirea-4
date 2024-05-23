package com.example.Task18;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
public class MarketController {

    private final MarketService marketService;

    @Autowired
    public MarketController(MarketService marketService) {
        this.marketService = marketService;
    }

    @PostMapping("/markets")
    public ResponseEntity<String> createMarket(@RequestBody Market market) {
        marketService.createMarket(market);
        return ResponseEntity.status(HttpStatus.CREATED).body("Market created successfully");
    }

    @GetMapping("/markets")
    public ResponseEntity<List<Market>> getAllMarkets() {
        List<Market> markets = marketService.getAllMarkets();
        return ResponseEntity.ok(markets);
    }

    @DeleteMapping("/markets/{id}")
    public ResponseEntity<String> deleteMarket(@PathVariable Long id) {
        marketService.deleteMarket(id);
        return ResponseEntity.ok("Market deleted successfully");
    }
}

