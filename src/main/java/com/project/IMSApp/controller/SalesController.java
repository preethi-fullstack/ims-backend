package com.project.IMSApp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sales")
public class SalesController {
    
    @PostMapping("/checkout")
    @PreAuthorize("hasAnyRole('STAFF', 'MANAGER', 'OWNER')")
    public ResponseEntity<String> processSale() {
        
        return ResponseEntity.ok("Sale processed successfully");
    }
    
    @GetMapping("/daily")
    @PreAuthorize("hasAnyRole('STAFF', 'MANAGER', 'OWNER')")
    public ResponseEntity<String> getDailySales() {
        // View daily sales summary
        return ResponseEntity.ok("Daily sales: $1500");
    }
}