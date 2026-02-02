package com.project.IMSApp.config;

import com.project.IMSApp.entity.User;
import com.project.IMSApp.enums.UserRole;
import com.project.IMSApp.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    
    private static final Logger logger = LoggerFactory.getLogger(DataInitializer.class);
    
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    
    public DataInitializer(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    
    @Override
    public void run(String... args) throws Exception {
        initializeOwner();
        initializeAdmin();
        initializeStaff();
        logger.info("Data initialization completed");
    }
    
    private void initializeOwner() {
        if (!userRepository.existsByEmail("owner@ims.com")) {
            User owner = new User();
            owner.setName("System Owner");
            owner.setEmail("owner@ims.com");
            owner.setPassword(passwordEncoder.encode("owner123"));
            owner.setRole(UserRole.OWNER);
            
            userRepository.save(owner);
            logger.info("Default owner created: owner@ims.com / owner123");
        } else {
            logger.info("Owner already exists");
        }
    }
    
    private void initializeAdmin() {
        if (!userRepository.existsByEmail("admin@ims.com")) {
            User admin = new User();
            admin.setName("System Admin");
            admin.setEmail("admin@ims.com");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setRole(UserRole.ADMIN);
            
            userRepository.save(admin);
            logger.info("Default admin created: admin@ims.com / admin123");
        } else {
            logger.info("Admin already exists");
        }
    }
    
    private void initializeStaff() {
        // Create staff user 1
        if (!userRepository.existsByEmail("staff1@ims.com")) {
            User staff1 = new User();
            staff1.setName("Staff User 1");
            staff1.setEmail("staff1@ims.com");
            staff1.setPassword(passwordEncoder.encode("staff123"));
            staff1.setRole(UserRole.STAFF);
            
            userRepository.save(staff1);
            logger.info("Staff 1 created: staff1@ims.com / staff123");
        }
        
        // Create staff user 2
        if (!userRepository.existsByEmail("staff2@ims.com")) {
            User staff2 = new User();
            staff2.setName("Staff User 2");
            staff2.setEmail("staff2@ims.com");
            staff2.setPassword(passwordEncoder.encode("staff123"));
            staff2.setRole(UserRole.STAFF);
            
            userRepository.save(staff2);
            logger.info("Staff 2 created: staff2@ims.com / staff123");
        }
    }
}