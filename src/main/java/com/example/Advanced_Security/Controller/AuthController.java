package com.example.Advanced_Security.Controller;

import com.example.Advanced_Security.Entity.User;
import com.example.Advanced_Security.Security.JwtTokenProvider;
import com.example.Advanced_Security.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthController(UserService userService, JwtTokenProvider jwtTokenProvider) {
        this.userService = userService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        try {
            userService.registerUser(user);
            String token = jwtTokenProvider.generateToken(user.getUsername());
            return ResponseEntity.ok("Registration successful. Token: " + token);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Registration failed: " + e.getMessage());
        }
    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        User existingUser = userService.findByUsername(user.getUsername());
        if (existingUser != null && userService.isPasswordValid(user.getPassword(), existingUser.getPassword())) {
            String token = jwtTokenProvider.generateToken(existingUser.getUsername());
            return ResponseEntity.ok("Login successful. Token: " + token);
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        String result = userService.deleteUserById(id);
        if ("User deleted successfully.".equals(result)) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(404).body(result);  // User not found
        }
    }

}
