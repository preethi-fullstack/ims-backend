package com.project.IMSApp.security;

import com.project.IMSApp.entity.User;
import com.project.IMSApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
        
        return new CustomUserDetails(
            user.getEmail(),
            user.getPassword(),
            Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + user.getRole().name())),
            user
        );
    }
    
    // Custom UserDetails implementation to include user object
    public static class CustomUserDetails extends org.springframework.security.core.userdetails.User {
        private final User user;
        
        public CustomUserDetails(String username, String password, 
                               Collection<? extends GrantedAuthority> authorities, 
                               User user) {
            super(username, password, authorities);
            this.user = user;
        }
        
        public User getUser() {
            return user;
        }
    }
}