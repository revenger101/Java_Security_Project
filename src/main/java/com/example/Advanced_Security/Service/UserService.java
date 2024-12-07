package com.example.Advanced_Security.Service;

import com.example.Advanced_Security.Entity.User;
import com.example.Advanced_Security.Repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public String encodePassword(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    public User registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public boolean isPasswordValid(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public String deleteUserById(Long id) {
        // Check if the user exists
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);  // Delete the user
            return "User deleted successfully.";
        } else {
            return "User not found.";
        }
    }
}
