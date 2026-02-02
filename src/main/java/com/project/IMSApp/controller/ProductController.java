package com.project.IMSApp.controller;

import com.project.IMSApp.dto.ProductRequest;
import com.project.IMSApp.dto.ProductDto;
import com.project.IMSApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Create new product
    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductRequest request) {

        System.out.println("=== CREATE PRODUCT REQUEST RECEIVED ===");
        System.out.println("Product Name: " + request.getName());
        System.out.println("Description: " + request.getDescription());
        System.out.println("Price: " + request.getPrice());
        System.out.println("Quantity: " + request.getQuantity());
        System.out.println("Category ID: " + request.getCategoryId());

        ProductDto created = productService.createProduct(request);

        System.out.println("Product Created: " + created);

        return ResponseEntity.ok(created);
    }

    // Get product by ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable Long id) {

        System.out.println("=== GET PRODUCT BY ID REQUEST ===");
        System.out.println("Product ID: " + id);

        ProductDto product = productService.getProductById(id);

        System.out.println("Product Found: " + product);

        return ResponseEntity.ok(product);
    }

    // Get all products
    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts() {

        System.out.println("=== GET ALL PRODUCTS REQUEST ===");

        List<ProductDto> products = productService.getAllProducts();

        System.out.println("Total Products Found: " + products.size());
        products.forEach(p -> System.out.println("Product: " + p));

        return ResponseEntity.ok(products);
    }

    // Update product
    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable Long id, @RequestBody ProductRequest request) {

        System.out.println("=== UPDATE PRODUCT REQUEST ===");
        System.out.println("Product ID: " + id);
        System.out.println("Updated Name: " + request.getName());
        System.out.println("Updated Description: " + request.getDescription());
        System.out.println("Updated Price: " + request.getPrice());
        System.out.println("Updated Quantity: " + request.getQuantity());
        System.out.println("Updated Category ID: " + request.getCategoryId());

        ProductDto updated = productService.updateProduct(id, request);

        System.out.println("Product Updated: " + updated);

        return ResponseEntity.ok(updated);
    }

    // Delete product
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {

        System.out.println("=== DELETE PRODUCT REQUEST ===");
        System.out.println("Deleting Product ID: " + id);

        productService.deleteProduct(id);

        System.out.println("Product deleted successfully.");

        return ResponseEntity.ok("Product deleted successfully");
    }
}
