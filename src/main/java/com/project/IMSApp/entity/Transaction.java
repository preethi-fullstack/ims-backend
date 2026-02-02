package com.project.IMSApp.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    private int quantity;
    @Column(name = "unit_price")
    private Double unitPrice;
    private double totalPrice;

    private LocalDateTime transactionDate;
    
    //  ADDED: Transaction type (PURCHASE or SALE)
    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_type")
    private TransactionType type;

    //  ADDED: Transaction Type Enum
    public enum TransactionType {
        PURCHASE,  // Buying from supplier (stock IN)
        SALE       // Selling to customer (stock OUT)
    }public Double getUnitPrice() {
        return unitPrice;
    }
    
    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }
    

    //  ADDED: Customer info for sales
    @Column(name = "customer_name")
    private String customerName;
    
    @Column(name = "customer_email")
    private String customerEmail;

    // Default constructor
    public Transaction() {
        this.transactionDate = LocalDateTime.now();
        System.out.println("Transaction entity constructor called.");
    }

    // Getters & Setters
    public Long getId() {
        System.out.println("Getting Transaction ID: " + id);
        return id;
    }
    public void setId(Long id) {
        System.out.println("Setting Transaction ID: " + id);
        this.id = id;
    }

    public User getUser() {
        System.out.println("Getting User: " + (user != null ? user.getId() : "No User"));
        return user;
    }
    public void setUser(User user) {
        System.out.println("Setting User: " + (user != null ? user.getId() : "No User"));
        this.user = user;
    }

    public Product getProduct() {
        System.out.println("Getting Product: " + (product != null ? product.getId() : "No Product"));
        return product;
    }
    public void setProduct(Product product) {
        System.out.println("Setting Product: " + (product != null ? product.getId() : "No Product"));
        this.product = product;
    }

    public Supplier getSupplier() {
        System.out.println("Getting Supplier: " + (supplier != null ? supplier.getId() : "No Supplier"));
        return supplier;
    }
    public void setSupplier(Supplier supplier) {
        System.out.println("Setting Supplier: " + (supplier != null ? supplier.getId() : "No Supplier"));
        this.supplier = supplier;
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
    
    // ✅ ADDED: Getter and setter for type
    public TransactionType getType() {
        System.out.println("Getting Transaction Type: " + type);
        return type;
    }
    
    public void setType(TransactionType type) {
        System.out.println("Setting Transaction Type: " + type);
        this.type = type;
    }
    
    // ✅ ADDED: Getter and setter for customer info
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
}