package com.example.Task14;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MarketController {
    private final List<Market> markets = new ArrayList<>();

    @PostMapping("/markets")
    public ResponseEntity<String> createMarket(@RequestBody Market market) {
        markets.add(market);
        return ResponseEntity.status(HttpStatus.CREATED).body("Market created successfully");
    }

    @GetMapping("/markets")
    public ResponseEntity<List<Market>> getAllMarkets() {
        return ResponseEntity.ok(markets);
    }

    @DeleteMapping("/markets/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        if (id >= 0 && id < markets.size()) {
            markets.remove(id);
            return ResponseEntity.ok("Market deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Market not found");
        }
    }
}


