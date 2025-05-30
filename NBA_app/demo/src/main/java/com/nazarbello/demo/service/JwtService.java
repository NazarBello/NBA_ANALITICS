package com.nazarbello.demo.service;

import com.nazarbello.demo.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    @Value("${security.jwt.secret-key}")
    private String jwtSigningKey;

    // Define token validity durations in milliseconds.
    private static final long ACCESS_TOKEN_VALIDITY_MILLIS = 100000L * 60 * 24;
    private static final long REFRESH_TOKEN_VALIDITY_MILLIS = 2 * ACCESS_TOKEN_VALIDITY_MILLIS;

    // Enum to clearly distinguish token types.
    public enum TokenType {
        ACCESS,
        REFRESH
    }

    // Extracts the username/subject from the token.
    public String extractUserName(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    // Generates a token by selecting the type explicitly.
    public String generateToken(UserDetails userDetails, TokenType tokenType) {
        Map<String, Object> claims = new HashMap<>();

        // If the userDetails is of custom User type, add extra claims.
        if (userDetails instanceof User customUserDetails) {
            claims.put("id", customUserDetails.getId());
            claims.put("email", customUserDetails.getEmail());
        }

        // Select the validity period based on the token type.
        long validityPeriod = (tokenType == TokenType.ACCESS)
                ? ACCESS_TOKEN_VALIDITY_MILLIS
                : REFRESH_TOKEN_VALIDITY_MILLIS;

        return buildToken(claims, userDetails, validityPeriod);
    }

    // Builds the JWT with standard claims.
    private String buildToken(Map<String, Object> claims, UserDetails userDetails, long validityMillis) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + validityMillis);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    // Validates that the token belongs to the given user and is not expired.
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String userName = extractUserName(token);
        return userName.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    // Extracts a specific claim from the token.
    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    // Determines if the token has expired.
    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    // Extracts the expiration date from the token.
    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    // Parses the token to get all its claims.
    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // Decodes the secret key and generates the signing key.
    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(jwtSigningKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
