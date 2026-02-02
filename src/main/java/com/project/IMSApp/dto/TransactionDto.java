package com.project.IMSApp.dto;

import java.time.LocalDateTime;

public class TransactionDto {
    private Long id;
    private String userName;
    private String productName;
    private String supplierName;
    private int quantity;
    private double totalPrice;
    private LocalDateTime transactionDate;
    private String type;  //  ADDED: "PURCHASE" or "SALE"
    private String customerName;  //  ADDED: For sales

    public TransactionDto() {
        System.out.println("TransactionDto default constructor called");
    }

    public TransactionDto(Long id, String userName, String productName, String supplierName,
                          int quantity, double totalPrice, LocalDateTime transactionDate,
                          String type, String customerName) {  //  UPDATED constructor
        this.id = id;
        this.userName = userName;
        this.productName = productName;
        this.supplierName = supplierName;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.transactionDate = transactionDate;
        this.type = type; 
        this.customerName = customerName;  

        System.out.println("TransactionDto constructor called with parameters:");
        System.out.println("ID: " + id);
        System.out.println("User Name: " + userName);
        System.out.println("Product Name: " + productName);
        System.out.println("Supplier Name: " + supplierName);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Price: " + totalPrice);
        System.out.println("Transaction Date: " + transactionDate);
        System.out.println("Type: " + type);  
        System.out.println("Customer Name: " + customerName); 
    }

    // Getters & Setters
    public Long getId() {
        System.out.println("Getting ID: " + id);
        return id;
    }
    public void setId(Long id) {
        System.out.println("Setting ID: " + id);
        this.id = id;
    }

    public String getUserName() {
        System.out.println("Getting User Name: " + userName);
        return userName;
    }
    public void setUserName(String userName) {
        System.out.println("Setting User Name: " + userName);
        this.userName = userName;
    }

    public String getProductName() {
        System.out.println("Getting Product Name: " + productName);
        return productName;
    }
    public void setProductName(String productName) {
        System.out.println("Setting Product Name: " + productName);
        this.productName = productName;
    }

    public String getSupplierName() {
        System.out.println("Getting Supplier Name: " + supplierName);
        return supplierName;
    }
    public void setSupplierName(String supplierName) {
        System.out.println("Setting Supplier Name: " + supplierName);
        this.supplierName = supplierName;
    }

    public int getQuantity() {
        System.out.println("Getting Quantity: " + quantity);
        return quantity;
    }
    public void setQuantity(int quantity) {
        System.out.println("Setting Quantity: " + quantity);
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        System.out.println("Getting Total Price: " + totalPrice);
        return totalPrice;
    }
    public void setTotalPrice(double totalPrice) {
        System.out.println("Setting Total Price: " + totalPrice);
        this.totalPrice = totalPrice;
    }

    public LocalDateTime getTransactionDate() {
        System.out.println("Getting Transaction Date: " + transactionDate);
        return transactionDate;
    }
    public void setTransactionDate(LocalDateTime transactionDate) {
        System.out.println("Setting Transaction Date: " + transactionDate);
        this.transactionDate = transactionDate;
    }
    
    //  ADDED: Type getter and setter
    public String getType() {
        System.out.println("Getting Transaction Type: " + type);
        return type;
    }
    
    public void setType(String type) {
        System.out.println("Setting Transaction Type: " + type);
        this.type = type;
    }
    
    //  ADDED: Customer name getter and setter
    public String getCustomerName() {
        System.out.println("Getting Customer Name: " + customerName);
        return customerName;
    }
    
    public void setCustomerName(String customerName) {
        System.out.println("Setting Customer Name: " + customerName);
        this.customerName = customerName;
    }
}