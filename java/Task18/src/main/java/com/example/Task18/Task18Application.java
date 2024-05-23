package com.example.Task18;

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
@EntityScan("com.example.Task18")
@ComponentScan(basePackages = "com.example.Task18")
public class Task18Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Task18Application.class, args);

		// Получаем экземпляры контроллеров из контекста Spring
		ProductController productController = context.getBean(ProductController.class);
		MarketController marketController = context.getBean(MarketController.class);
		MarketRepository marketRepository = context.getBean(MarketRepository.class);
		productController.deleteAllProducts();


		// Создаем несколько продуктов
		Product product1 = new Product("Apple", 1.99);
		Product product2 = new Product("Banana", 0.99);
		Product product3 = new Product("Orange", 2.49);
		Product product4 = new Product("Milk", 1.49);
		Product product5 = new Product("Apple", 2.1);

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
		productController.createProduct(product5);

		// Получаем список всех продуктов
		ResponseEntity<List<Product>> allProductsResponse = productController.getAllProducts();
		List<Product> allProducts = allProductsResponse.getBody();

		// Выводим список всех продуктов
		System.out.println("All Products:");
		for (Product product : allProducts) {
			System.out.println("- " + product.getName() + ": $" + product.getPrice());
		}

		// Фильтрация продуктов по имени и цене
		ResponseEntity<List<Product>> filteredProductsResponse = productController.filterProducts("Apple", 1.99);
		List<Product> filteredProducts = filteredProductsResponse.getBody();
		System.out.println("Filtered Products:");
		for (Product p : filteredProducts) {
			System.out.println("- " + p.getName() + ": $" + p.getPrice());
		}
	}

}
