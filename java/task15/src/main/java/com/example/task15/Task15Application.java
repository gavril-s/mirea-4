package com.example.Task15;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SpringBootApplication
@EnableJpaRepositories
@EntityScan("com.example.Task15")
@ComponentScan(basePackages = "com.example.Task15")
public class Task15Application {
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Task15Application.class, args);

		// Получаем экземпляр ProductController из контекста Spring
		ProductController productController = context.getBean(ProductController.class);

		// Создаем продукт
		Product product = new Product("Apple", 1.99);

		// Вызываем метод создания продукта через контроллер
		productController.createProduct(product);

		// Получаем список всех продуктов
		ResponseEntity<List<Product>> allProductsResponse = productController.getAllProducts();
		List<Product> allProducts = allProductsResponse.getBody();
		System.out.println("All Products:");
		for (Product p : allProducts) {
			System.out.println(p.getName() + ": $" + p.getPrice());
		}

		// Удаляем первый продукт из списка (если список не пустой)
		if (!allProducts.isEmpty()) {
			Long firstProductId = allProducts.get(0).getId();
			ResponseEntity<String> deleteResponse = productController.deleteProduct(firstProductId);
			System.out.println(deleteResponse.getBody());
		}


		// Получаем экземпляр MarketController из контекста Spring
		MarketController marketController = context.getBean(MarketController.class);

		// Создаем маркет
		Market market = new Market("Supermarket", "123 Main St");

		// Вызываем метод создания маркета через контроллер
		marketController.createMarket(market);

		// Получаем список всех маркетов
		ResponseEntity<List<Market>> allMarketsResponse = marketController.getAllMarkets();
		List<Market> allMarkets = allMarketsResponse.getBody();
		System.out.println("All Markets:");
		for (Market m : allMarkets) {
			System.out.println(m.getName() + ": " + m.getAddress());
		}

		// Удаляем первый маркет из списка (если список не пустой)
		if (!allMarkets.isEmpty()) {
			Long firstMarketId = allMarkets.get(0).getId();
			ResponseEntity<String> deleteResponse = marketController.deleteMarket(firstMarketId);
			System.out.println(deleteResponse.getBody());
		}
	}



}


