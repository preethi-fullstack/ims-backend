package com.project.IMSApp.dto;

import jakarta.validation.constraints.*;

public class TransactionRequest {
    
    private Long userId; 
    
    @NotNull(message = "Product ID is required")
    @Min(value = 1, message = "Product ID must be positive")
    private Long productId;
    
    // Make supplierId conditional based on transaction type
    private Long supplierId;
    
    @NotNull(message = "Quantity is required")
    @Min(value = 1, message = "Quantity must be at least 1")
    private Integer quantity;
    
    @NotBlank(message = "Transaction type is required")
    @Pattern(regexp = "PURCHASE|SALE", message = "Type must be PURCHASE or SALE")
    private String type;
    
    // Optional fields
    private String customerName;
    private String customerEmail;
    
    @NotNull(message = "Unit price is required")
    @DecimalMin(value = "0.01", message = "Unit price must be at least 0.01")
    private Double unitPrice;
    
    @NotNull(message = "Total price is required")
    @DecimalMin(value = "0.01", message = "Total price must be at least 0.01")
    private Double totalPrice;

    // Default constructor
    public TransactionRequest() {
        System.out.println("TransactionRequest constructor called");
    }

    // Getters & Setters
    public Long getUserId() {
        System.out.println("Getting User ID: " + userId);
        return userId;
    }

    public void setUserId(Long userId) {
        System.out.println("Setting User ID: " + userId);
        this.userId = userId;
    }

    public Long getProductId() {
        System.out.println("Getting Product ID: " + productId);
        return productId;
    }

    public void setProductId(Long productId) {
        System.out.println("Setting Product ID: " + productId);
        this.productId = productId;
    }

    public Long getSupplierId() {
        System.out.println("Getting Supplier ID: " + supplierId);
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        System.out.println("Setting Supplier ID: " + supplierId);
        this.supplierId = supplierId;
    }

    public Integer getQuantity() {
        System.out.println("Getting Quantity: " + quantity);
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        System.out.println("Setting Quantity: " + quantity);
        this.quantity = quantity;
    }
    
    public String getType() {
        System.out.println("Getting Transaction Type: " + type);
        return type;
    }
    
    public void setType(String type) {
        System.out.println("Setting Transaction Type: " + type);
        this.type = type;
    }
    
    public String getCustomerName() {
        System.out.println("Getting Customer Name: " + customerName);
        return customerName;
    }
    
    public void setCustomerName(String customerName) {
        System.out.println("Setting Customer Name: " + customerName);
        this.customerName = customerName;
    }
    
    public String getCustomerEmail() {
        System.out.println("Getting Customer Email: " + customerEmail);
        return customerEmail;
    }
    
    public void setCustomerEmail(String customerEmail) {
        System.out.println("Setting Customer Email: " + customerEmail);
        this.customerEmail = customerEmail;
    }
    
    public Double getUnitPrice() {
        System.out.println("Getting Unit Price: " + unitPrice);
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        System.out.println("Setting Unit Price: " + unitPrice);
        this.unitPrice = unitPrice;
    }
    
    public Double getTotalPrice() {
        System.out.println("Getting Total Price: " + totalPrice);
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        System.out.println("Setting Total Price: " + totalPrice);
        this.totalPrice = totalPrice;
    }
}