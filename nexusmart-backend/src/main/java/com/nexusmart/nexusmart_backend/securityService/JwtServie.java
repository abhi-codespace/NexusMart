// package com.nexusmart.nexusmart_backend.services;

// import java.security.Key;
// import java.security.NoSuchAlgorithmException;
// import java.util.Base64;
// import java.util.Date;
// import java.util.HashMap;
// import java.util.Map;
// import java.util.Set;
// import java.util.stream.Collectors;
// import java.util.function.Function;

// import javax.crypto.KeyGenerator;
// import javax.crypto.SecretKey;

// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.stereotype.Service;

// import io.jsonwebtoken.Claims;
// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;
// import io.jsonwebtoken.io.Decoders;
// import io.jsonwebtoken.security.Keys;

// @Service
// public class JWTService {

//     private String secretKey;

//     public JWTService() {
//         try {
//             KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA256");
//             SecretKey sk = keyGenerator.generateKey();
//             this.secretKey = Base64.getEncoder().encodeToString(sk.getEncoded());
//         } catch (NoSuchAlgorithmException e) {
//             throw new RuntimeException(e);
//         }
//     }

//     // Generate token including roles
//     public String generateToken(UserDetails userDetails) {
//         Map<String, Object> claims = new HashMap<>();
//         // Add roles to token
//         Set<String> roles = userDetails.getAuthorities()
//                 .stream()
//                 .map(GrantedAuthority::getAuthority)
//                 .collect(Collectors.toSet());
//         claims.put("roles", roles);

//         return Jwts.builder()
//                 .setClaims(claims)
//                 .setSubject(userDetails.getUsername())
//                 .setIssuedAt(new Date(System.currentTimeMillis()))
//                 .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30)) // 30 mins
//                 .signWith(getKey(), SignatureAlgorithm.HS256)
//                 .compact();
//     }

//     public String extractUsername(String token) {
//         return extractClaim(token, Claims::getSubject);
//     }

//     public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
//         final Claims claims = extractAllClaims(token);
//         return claimsResolver.apply(claims);
//     }

//     public boolean validateToken(String token, UserDetails userDetails) {
//         final String username = extractUsername(token);
//         return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
//     }

//     private boolean isTokenExpired(String token) {
//         return extractClaim(token, Claims::getExpiration).before(new Date());
//     }

//     private Claims extractAllClaims(String token) {
//         return Jwts.parserBuilder()
//                 .setSigningKey(getKey())
//                 .build()
//                 .parseClaimsJws(token)
//                 .getBody();
//     }

//     private Key getKey() {
//         byte[] keyBytes = Decoders.BASE64.decode(secretKey);
//         return Keys.hmacShaKeyFor(keyBytes);
//     }

//     // Extract roles from token
//     public Set<String> extractRoles(String token) {
//         return extractClaim(token, claims -> {
//             Object roles = claims.get("roles");
//             if (roles instanceof java.util.List<?>) {
//                 return ((java.util.List<?>) roles).stream()
//                         .map(Object::toString)
//                         .collect(Collectors.toSet());
//             }
//             return Set.of();
//         });
//     }
// }
