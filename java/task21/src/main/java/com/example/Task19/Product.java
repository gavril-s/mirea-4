package com.example.Task19;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "market_id")
    private Market market;


    // Конструктор без параметров (необходим для JPA)
    public Product() {
    }

    // Конструктор с параметрами
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Геттер для id
    public Long getId() {
        return id;
    }

    // Сеттер для id (обычно не используется, так как id генерируется автоматически)
    public void setId(Long id) {
        this.id = id;
    }

    // Геттер для name
    public String getName() {
        return name;
    }

    // Сеттер для name
    public void setName(String name) {
        this.name = name;
    }

    // Геттер для price
    public double getPrice() {
        return price;
    }

    // Сеттер для price
    public void setPrice(double price) {
        this.price = price;
    }
    public void setMarket(Market market) {
        this.market = market;
    }

    public Market getMarket() {
        return market;
    }
}

