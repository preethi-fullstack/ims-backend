package com.project.IMSApp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private double price;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    public Product() {
        System.out.println("Product entity created.");
    }

    public Long getId() {
        System.out.println("GET PRODUCT ID → " + id);
        return id;
    }

    public void setId(Long id) {
        System.out.println("SET PRODUCT ID → " + id);
        this.id = id;
    }

    public String getName() {
        System.out.println("GET PRODUCT NAME → " + name);
        return name;
    }

    public void setName(String name) {
        System.out.println("SET PRODUCT NAME → " + name);
        this.name = name;
    }

    public String getDescription() {
        System.out.println("GET PRODUCT DESCRIPTION → " + description);
        return description;
    }

    public void setDescription(String description) {
        System.out.println("SET PRODUCT DESCRIPTION → " + description);
        this.description = description;
    }

    public double getPrice() {
        System.out.println("GET PRODUCT PRICE → " + price);
        return price;
    }

    public void setPrice(double price) {
        System.out.println("SET PRODUCT PRICE → " + price);
        this.price = price;
    }

    public int getQuantity() {
        System.out.println("GET PRODUCT QUANTITY → " + quantity);
        return quantity;
    }

    public void setQuantity(int quantity) {
        System.out.println("SET PRODUCT QUANTITY → " + quantity);
        this.quantity = quantity;
    }

    public Category getCategory() {
        System.out.println("GET PRODUCT CATEGORY → " + (category != null ? category.getName() : null));
        return category;
    }

    public void setCategory(Category category) {
        System.out.println("SET PRODUCT CATEGORY → " + (category != null ? category.getName() : null));
        this.category = category;
    }
}
