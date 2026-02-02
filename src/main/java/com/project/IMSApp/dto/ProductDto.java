package com.project.IMSApp.dto;

public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private double price;
    private int quantity;
    private Long categoryId;
    private String categoryName;

    public ProductDto() {
        System.out.println("ProductDto created (empty).");
    }

    public ProductDto(Long id, String name, String description, double price, int quantity, Long categoryId, String categoryName) {
        System.out.println("ProductDto created with values → ID: " + id + ", Name: " + name);
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public Long getId() {
        System.out.println("ProductDto GET ID → " + id);
        return id;
    }

    public void setId(Long id) {
        System.out.println("ProductDto SET ID → " + id);
        this.id = id;
    }

    public String getName() {
        System.out.println("ProductDto GET NAME → " + name);
        return name;
    }

    public void setName(String name) {
        System.out.println("ProductDto SET NAME → " + name);
        this.name = name;
    }

    public String getDescription() {
        System.out.println("ProductDto GET DESCRIPTION → " + description);
        return description;
    }

    public void setDescription(String description) {
        System.out.println("ProductDto SET DESCRIPTION → " + description);
        this.description = description;
    }

    public double getPrice() {
        System.out.println("ProductDto GET PRICE → " + price);
        return price;
    }

    public void setPrice(double price) {
        System.out.println("ProductDto SET PRICE → " + price);
        this.price = price;
    }

    public int getQuantity() {
        System.out.println("ProductDto GET QUANTITY → " + quantity);
        return quantity;
    }

    public void setQuantity(int quantity) {
        System.out.println("ProductDto SET QUANTITY → " + quantity);
        this.quantity = quantity;
    }

    public Long getCategoryId() {
        System.out.println("ProductDto GET CATEGORY ID → " + categoryId);
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        System.out.println("ProductDto SET CATEGORY ID → " + categoryId);
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        System.out.println("ProductDto GET CATEGORY NAME → " + categoryName);
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        System.out.println("ProductDto SET CATEGORY NAME → " + categoryName);
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "ProductDto{id=" + id + ", name='" + name + "', categoryName='" + categoryName + "'}";
    }
}
