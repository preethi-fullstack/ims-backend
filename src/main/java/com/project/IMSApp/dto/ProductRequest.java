package com.project.IMSApp.dto;

public class ProductRequest {
    private String name;
    private String description;
    private double price;
    private int quantity;
    private Long categoryId;

    public ProductRequest() {
        System.out.println("ProductRequest created.");
    }

    public String getName() {
        System.out.println("ProductRequest GET NAME → " + name);
        return name;
    }

    public void setName(String name) {
        System.out.println("ProductRequest SET NAME → " + name);
        this.name = name;
    }

    public String getDescription() {
        System.out.println("ProductRequest GET DESCRIPTION → " + description);
        return description;
    }

    public void setDescription(String description) {
        System.out.println("ProductRequest SET DESCRIPTION → " + description);
        this.description = description;
    }

    public double getPrice() {
        System.out.println("ProductRequest GET PRICE → " + price);
        return price;
    }

    public void setPrice(double price) {
        System.out.println("ProductRequest SET PRICE → " + price);
        this.price = price;
    }

    public int getQuantity() {
        System.out.println("ProductRequest GET QUANTITY → " + quantity);
        return quantity;
    }

    public void setQuantity(int quantity) {
        System.out.println("ProductRequest SET QUANTITY → " + quantity);
        this.quantity = quantity;
    }

    public Long getCategoryId() {
        System.out.println("ProductRequest GET CATEGORY ID → " + categoryId);
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        System.out.println("ProductRequest SET CATEGORY ID → " + categoryId);
        this.categoryId = categoryId;
    }
}
