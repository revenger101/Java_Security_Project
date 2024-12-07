package com.example.Advanced_Security.Security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Collections;

@Component
public class JwtTokenProvider {

    private SecretKey jwtSecret;
    private long jwtExpirationInMs = 86400000; // 1 day in milliseconds

    // Initialize jwtSecret using the Keys.secretKeyFor method
    public JwtTokenProvider() {
        this.jwtSecret = Keys.secretKeyFor(SignatureAlgorithm.HS512); // This generates a 512-bit key
    }

    // Generate JWT Token
    public String generateToken(String username) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(jwtSecret)
                .compact();
    }

    // Validate JWT Token
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(jwtSecret).build().parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException | ExpiredJwtException | UnsupportedJwtException | IllegalArgumentException ex) {
            System.out.println("Invalid JWT: " + ex.getMessage());
            return false;
        }
    }

    // Get username from JWT Token
    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(jwtSecret)
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    // Create Authentication object from JWT Token
    public Authentication getAuthentication(String token) {
        String username = getUsernameFromToken(token); // Extract username from token
        // In this case, we are not including roles, but you can extend this if roles are present in the token
        return new UsernamePasswordAuthenticationToken(username, null, Collections.emptyList());
    }
}
