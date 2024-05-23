package com.example.Task17;

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
    private ProductRepository productRepository;

    @Autowired
    public MarketController(MarketRepository marketRepository) {
        this.marketRepository = marketRepository;
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

    @PostMapping("/markets")
    public ResponseEntity<String> createMarket(@RequestBody Market market) {
        marketRepository.save(market);

        List<Product> products = market.getProducts();
        if (products != null) {
            for (Product product : products) {
                product.setMarket(market);
                productRepository.save(product);
            }
        }

        return ResponseEntity.status(HttpStatus.CREATED).body("Market created successfully");
    }

    @GetMapping("/markets")
    public ResponseEntity<List<Market>> getAllMarkets() {
        List<Market> markets = marketRepository.findAllWithProducts();
        return ResponseEntity.ok(markets);
    }
    @GetMapping("/markets/{id}/products")
    public ResponseEntity<List<Product>> getProductsForMarket(@PathVariable Long id) {
        Optional<Market> optionalMarket = marketRepository.findById(id);
        if (optionalMarket.isPresent()) {
            Market market = optionalMarket.get();
            List<Product> products = market.getProducts();
            return ResponseEntity.ok(products);
        } else {
            return ResponseEntity.notFound().build();
        }

    }
}
