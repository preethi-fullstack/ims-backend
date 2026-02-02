package com.project.IMSApp.service.impl;

import com.project.IMSApp.dto.TransactionRequest;
import com.project.IMSApp.dto.TransactionDto;
import com.project.IMSApp.entity.Product;
import com.project.IMSApp.entity.Supplier;
import com.project.IMSApp.entity.Transaction;
import com.project.IMSApp.entity.User;
import com.project.IMSApp.repository.ProductRepository;
import com.project.IMSApp.repository.SupplierRepository;
import com.project.IMSApp.repository.TransactionRepository;
import com.project.IMSApp.repository.UserRepository;
import com.project.IMSApp.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    @Transactional
    public TransactionDto createTransaction(TransactionRequest request) {
        System.out.println("---- Creating Transaction ----");
        System.out.println("Request details:");
        System.out.println("  User ID: " + request.getUserId());
        System.out.println("  Product ID: " + request.getProductId());
        System.out.println("  Supplier ID: " + request.getSupplierId());
        System.out.println("  Quantity: " + request.getQuantity());
        System.out.println("  Type: " + request.getType());
        System.out.println("  Unit Price: " + request.getUnitPrice());
        System.out.println("  Total Price: " + request.getTotalPrice());

        // Validate request
        if (request.getType() == null || request.getType().trim().isEmpty()) {
            throw new RuntimeException("Transaction type is required (PURCHASE or SALE)");
        }

        // FIX: Get authenticated user instead of using userId from request
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        System.out.println("Authenticated user: " + username);
        
        // Fetch User by email (username) instead of ID
        User user = userRepository.findByEmail(username)
                .orElseThrow(() -> {
                    System.out.println("❌ User not found for email: " + username);
                    return new RuntimeException("User not found with email: " + username);
                });
        System.out.println("✅ User found: " + user.getName() + " (ID: " + user.getId() + ")");

        // Fetch Product
        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> {
                    System.out.println("❌ Product not found for ID: " + request.getProductId());
                    return new RuntimeException("Product not found with ID: " + request.getProductId());
                });
        System.out.println(" Product found: " + product.getName() + " (Stock: " + product.getQuantity() + ")");

        // Create transaction
        Transaction transaction = new Transaction();
        transaction.setUser(user);
        transaction.setProduct(product);
        transaction.setQuantity(request.getQuantity());
        transaction.setTransactionDate(LocalDateTime.now());

        
        if (request.getUnitPrice() != null && request.getTotalPrice() != null) {
            transaction.setUnitPrice(request.getUnitPrice());  // FIXED: setUnitPrice instead of setTotalPrice
            transaction.setTotalPrice(request.getTotalPrice());
            System.out.println("Using provided prices - Unit: " + request.getUnitPrice() + ", Total: " + request.getTotalPrice());
        } else {
            // Fallback to product price if not provided
            transaction.setUnitPrice(product.getPrice());  // FIXED: setUnitPrice instead of setTotalPrice
            transaction.setTotalPrice(product.getPrice() * request.getQuantity());
            System.out.println("Using product price - Unit: " + product.getPrice() + ", Total: " + (product.getPrice() * request.getQuantity()));
        }

        // Handle PURCHASE vs SALE
        String transactionType = request.getType().toUpperCase();
        
        if ("PURCHASE".equals(transactionType)) {
            // Handle PURCHASE
            transaction.setType(Transaction.TransactionType.PURCHASE);
            
            // Fetch Supplier for purchase
            Supplier supplier = supplierRepository.findById(request.getSupplierId())
                    .orElseThrow(() -> {
                        System.out.println("❌ Supplier not found for ID: " + request.getSupplierId());
                        return new RuntimeException("Supplier not found for purchase with ID: " + request.getSupplierId());
                    });
            System.out.println(" Supplier found: " + supplier.getName());
            transaction.setSupplier(supplier);
            
            // For PURCHASE: INCREASE stock
            int newQuantity = product.getQuantity() + request.getQuantity();
            product.setQuantity(newQuantity);
            System.out.println(" Purchase: Increased product stock from " + (product.getQuantity() - request.getQuantity()) + " to " + newQuantity);
            
        } else if ("SALE".equals(transactionType)) {
            // Handle SALE
            transaction.setType(Transaction.TransactionType.SALE);
            
            // For SALE: Supplier is optional
            if (request.getSupplierId() != null) {
                Supplier supplier = supplierRepository.findById(request.getSupplierId()).orElse(null);
                transaction.setSupplier(supplier);
            }
            
            // For SALE: Set customer info
            transaction.setCustomerName(request.getCustomerName());
            transaction.setCustomerEmail(request.getCustomerEmail());
            
            // For SALE: Check stock availability and DECREASE stock
            if (request.getQuantity() > product.getQuantity()) {
                System.out.println("❌ Not enough stock for sale. Requested: " + request.getQuantity() + ", Available: " + product.getQuantity());
                throw new RuntimeException("Not enough product in stock for sale. Available: " + product.getQuantity() + ", Requested: " + request.getQuantity());
            }
            int newQuantity = product.getQuantity() - request.getQuantity();
            product.setQuantity(newQuantity);
            System.out.println(" Sale: Decreased product stock from " + (product.getQuantity() + request.getQuantity()) + " to " + newQuantity);
            
        } else {
            throw new RuntimeException("Invalid transaction type. Must be 'PURCHASE' or 'SALE'");
        }

        // Save product stock changes
        productRepository.save(product);
        
        // Save transaction
        Transaction savedTransaction = transactionRepository.save(transaction);
        System.out.println(" Transaction saved successfully with ID: " + savedTransaction.getId());
        System.out.println("---- Transaction Creation Completed ----");

        return mapToDto(savedTransaction);
    }

    @Override
    public TransactionDto getTransactionById(Long id) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
        return mapToDto(transaction);
    }

    @Override
    public List<TransactionDto> getAllTransactions() {
        return transactionRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    private TransactionDto mapToDto(Transaction transaction) {
        return new TransactionDto(
                transaction.getId(),
                transaction.getUser().getName(),
                transaction.getProduct().getName(),
                transaction.getSupplier() != null ? transaction.getSupplier().getName() : null,
                transaction.getQuantity(),
                transaction.getTotalPrice(),
                transaction.getTransactionDate(),
                transaction.getType().toString(),
                transaction.getCustomerName()
        );
    }
}