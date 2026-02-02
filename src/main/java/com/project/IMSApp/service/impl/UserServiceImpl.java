package com.project.IMSApp.service.impl;

import com.project.IMSApp.dto.RegisterRequest;
import com.project.IMSApp.dto.UserDto;
import com.project.IMSApp.entity.User;
import com.project.IMSApp.enums.UserRole;
import com.project.IMSApp.repository.UserRepository;
import com.project.IMSApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    @Transactional
    public UserDto register(RegisterRequest request) {
        // Check if email already exists
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists!");
        }
        
        // Check role limits
        UserRole role = UserRole.valueOf(request.getRole().toUpperCase());
        checkRoleLimit(role);
        
        // Create new user
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(role);
        
        userRepository.save(user);
        
        return new UserDto(
            user.getId(),
            user.getName(),
            user.getEmail(),
            user.getRole().name()
        );
    }
    
    private void checkRoleLimit(UserRole role) {
        long count = userRepository.countByRole(role);
        
        switch (role) {
            case OWNER:
                if (count >= 1) {
                    throw new RuntimeException("Only one owner can be registered!");
                }
                break;
            case ADMIN:
                if (count >= 1) {
                    throw new RuntimeException("Only one admin can be registered!");
                }
                break;
            case STAFF:
                if (count >= 2) {
                    throw new RuntimeException("Maximum 2 staff members allowed!");
                }
                break;
        }
    }
    
    @Override
    public UserDto getUserById(long id) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));
        
        return new UserDto(
            user.getId(),
            user.getName(),
            user.getEmail(),
            user.getRole().name()
        );
    }
    
    // Additional method to get all users (for owner/admin)
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
            .map(user -> new UserDto(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole().name()
            ))
            .toList();
    }

	@Override
	public UserDto getUserById(Long id) {
		
		return null;
	}
}