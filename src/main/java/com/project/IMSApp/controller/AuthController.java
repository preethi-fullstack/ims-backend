package com.project.IMSApp.controller;

import com.project.IMSApp.dto.LoginRequest;
import com.project.IMSApp.dto.LoginResponse;
import com.project.IMSApp.entity.User;
import com.project.IMSApp.repository.UserRepository;
import com.project.IMSApp.security.CustomUserDetailsService;
import com.project.IMSApp.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private UserDetailsService userDetailsService;
    
    @Autowired
    private JwtUtil jwtUtil;
    
    @Autowired
    private UserRepository userRepository;
    
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        CustomUserDetailsService.CustomUserDetails userDetails = 
            (CustomUserDetailsService.CustomUserDetails) userDetailsService.loadUserByUsername(request.getEmail());
        
        // Generate token with role from user object
        String token = jwtUtil.generateToken(
            userDetails.getUsername(), 
            userDetails.getUser().getRole().name()
        );
        
        return ResponseEntity.ok(new LoginResponse(token));
    }
}