package com.project.IMSApp.controller;

import com.project.IMSApp.dto.SupplierRequest;
import com.project.IMSApp.dto.SupplierDto;
import com.project.IMSApp.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    // Create supplier
    @PostMapping
    public ResponseEntity<SupplierDto> createSupplier(@RequestBody SupplierRequest request) {

        System.out.println("=== CREATE SUPPLIER REQUEST RECEIVED ===");
        System.out.println("Name: " + request.getName());
        System.out.println("Email: " + request.getEmail());
        System.out.println("Phone: " + request.getPhone());
        System.out.println("Address: " + request.getAddress());

        SupplierDto created = supplierService.createSupplier(request);

        System.out.println("Supplier Created: " + created);

        return ResponseEntity.ok(created);
    }

    // Get supplier by ID
    @GetMapping("/{id}")
    public ResponseEntity<SupplierDto> getSupplier(@PathVariable Long id) {

        System.out.println("=== GET SUPPLIER BY ID REQUEST ===");
        System.out.println("Supplier ID: " + id);

        SupplierDto supplier = supplierService.getSupplierById(id);

        System.out.println("Supplier Found: " + supplier);

        return ResponseEntity.ok(supplier);
    }

    // Get all suppliers
    @GetMapping
    public ResponseEntity<List<SupplierDto>> getAllSuppliers() {

        System.out.println("=== GET ALL SUPPLIERS REQUEST ===");

        List<SupplierDto> suppliers = supplierService.getAllSuppliers();

        System.out.println("Total Suppliers Found: " + suppliers.size());
        suppliers.forEach(s -> System.out.println("Supplier: " + s));

        return ResponseEntity.ok(suppliers);
    }

    // Update supplier
    @PutMapping("/{id}")
    public ResponseEntity<SupplierDto> updateSupplier(@PathVariable Long id, @RequestBody SupplierRequest request) {

        System.out.println("=== UPDATE SUPPLIER REQUEST ===");
        System.out.println("Supplier ID: " + id);
        System.out.println("Updated Name: " + request.getName());
        System.out.println("Updated Email: " + request.getEmail());
        System.out.println("Updated Phone: " + request.getPhone());
        System.out.println("Updated Address: " + request.getAddress());

        SupplierDto updated = supplierService.updateSupplier(id, request);

        System.out.println("Supplier Updated: " + updated);

        return ResponseEntity.ok(updated);
    }

    // Delete supplier
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSupplier(@PathVariable Long id) {

        System.out.println("=== DELETE SUPPLIER REQUEST ===");
        System.out.println("Deleting Supplier ID: " + id);

        supplierService.deleteSupplier(id);

        System.out.println("Supplier deleted successfully.");

        return ResponseEntity.ok("Supplier deleted successfully");
    }
}
