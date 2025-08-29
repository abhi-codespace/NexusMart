package com.nexusmart.nexusmart_backend.filter;

import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
=======
>>>>>>> feature1
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

<<<<<<< HEAD
import com.nexusmart.nexusmart_backend.services.JWTService;
=======
import com.nexusmart.nexusmart_backend.securityService.JWTService;
>>>>>>> feature1

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
<<<<<<< HEAD

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JWTService jwtService;
=======
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private final JWTService jwtService;
>>>>>>> feature1

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

<<<<<<< HEAD
        final String authHeader = request.getHeader("Authorization");
=======
        if (request.getServletPath().startsWith("/api/auth")) {
            filterChain.doFilter(request, response);
            return;
        }

        String authHeader = request.getHeader("Authorization");
>>>>>>> feature1
        String username = null;
        String jwt = null;

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            jwt = authHeader.substring(7);
            try {
                username = jwtService.extractUsername(jwt);
            } catch (Exception e) {
                logger.error("JWT extraction failed: " + e.getMessage());
            }
        }

<<<<<<< HEAD
        // Set authentication if valid
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            if (jwt != null) {
                // Extract roles from token
                Set<String> roles = jwtService.extractRoles(jwt);

                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        username,
                        null,
                        roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toSet())
                );

=======
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            if (jwt != null) {
                Set<String> roles = jwtService.extractRoles(jwt);
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        username,
                        null,
                        roles.stream()
                                .map(role -> new SimpleGrantedAuthority("ROLE_" + role)) // Important for hasRole()
                                .collect(Collectors.toSet()));
>>>>>>> feature1
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }

        filterChain.doFilter(request, response);
    }
}
