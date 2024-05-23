package com.example.Task16;

import org.hibernate.Hibernate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableJpaRepositories
@EntityScan("com.example.Task16")
@ComponentScan(basePackages = "com.example.Task16")
public class Task16Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Task16Application.class, args);

		// Получаем экземпляры контроллеров из контекста Spring
		ProductController productController = context.getBean(ProductController.class);
		MarketController marketController = context.getBean(MarketController.class);

		// Создаем несколько продуктов
		Product product1 = new Product("Apple", 1.99);
		Product product2 = new Product("Banana", 0.99);
		Product product3 = new Product("Orange", 1.49);
		Product product4 = new Product("Milk", 2.49);

		// Создаем несколько магазинов
		Market market1 = new Market("Supermarket", "123 Main St");
		Market market2 = new Market("Grocery Store", "456 Elm St");

		// Привязываем продукты к магазинам
		market1.setProducts(Arrays.asList(product1, product2));
		market2.setProducts(Arrays.asList(product3, product4));

		// Создаем магазины и продукты через контроллеры
		marketController.createMarket(market1);
		marketController.createMarket(market2);

		productController.createProduct(product1);
		productController.createProduct(product2);
		productController.createProduct(product3);
		productController.createProduct(product4);

		// Получаем экземпляр MarketRepository из контекста Spring
		MarketRepository marketRepository = context.getBean(MarketRepository.class);

// Получаем список всех магазинов и их продуктов одним запросом
		List<Market> allMarketsWithProducts = marketRepository.findAllWithProducts();

// Выводим список магазинов и их продуктов
		System.out.println("All Markets:");
		for (Market m : allMarketsWithProducts) {
			System.out.println(m.getName() + ": " + m.getAddress());
			System.out.println("Products:");
			for (Product p : m.getProducts()) {
				System.out.println("- " + p.getName() + ": $" + p.getPrice());
			}
		}
	}
	
}
