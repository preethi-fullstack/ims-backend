package com.project.IMSApp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test")
public class TestController {
    
    @GetMapping("/auth")
    public ResponseEntity<?> testAuth() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return ResponseEntity.ok("Authenticated as: " + auth.getName() + 
                               ", Authorities: " + auth.getAuthorities());
    }
    
    @GetMapping("/owner-only")
    @PreAuthorize("hasRole('OWNER')")
    public ResponseEntity<String> ownerOnly() {
        return ResponseEntity.ok("Owner access granted!");
    }
    
    @GetMapping("/admin-only")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> adminOnly() {
        return ResponseEntity.ok("Admin access granted!");
    }
    
    @GetMapping("/staff-only")
    @PreAuthorize("hasRole('STAFF')")
    public ResponseEntity<String> staffOnly() {
        return ResponseEntity.ok("Staff access granted!");
    }
    
    @GetMapping("/admin-or-owner")
    @PreAuthorize("hasAnyRole('ADMIN', 'OWNER')")
    public ResponseEntity<String> adminOrOwner() {
        return ResponseEntity.ok("Admin or Owner access granted!");
    }
}
