package com.project.IMSApp.controller;

import com.project.IMSApp.dto.RegisterRequest;
import com.project.IMSApp.dto.UserDto;
import com.project.IMSApp.service.UserService;
import com.project.IMSApp.service.impl.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    // Public registration
    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(userService.register(request));
    }
    
    // Owner only endpoint
    @GetMapping("/owner-only")
    @PreAuthorize("hasRole('OWNER')")
    public ResponseEntity<String> ownerOnly() {
        return ResponseEntity.ok("This is accessible only by OWNER");
    }
    
    // Admin and Owner endpoint
    @GetMapping("/admin-only")
    @PreAuthorize("hasAnyRole('ADMIN', 'OWNER')")
    public ResponseEntity<String> adminOnly() {
        return ResponseEntity.ok("This is accessible by ADMIN and OWNER");
    }
    
    // Get all users (only for owner/admin)
    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'OWNER')")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        // Cast to UserServiceImpl to access getAllUsers method
        UserServiceImpl userServiceImpl = (UserServiceImpl) userService;
        return ResponseEntity.ok(userServiceImpl.getAllUsers());
    }
    
    // Get user by ID (accessible by all authenticated users)
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }
}