// package com.nexusmart.nexusmart_backend.filter;

// import java.io.IOException;
// import java.util.Set;
// import java.util.stream.Collectors;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
// import org.springframework.stereotype.Component;
// import org.springframework.web.filter.OncePerRequestFilter;

// import com.nexusmart.nexusmart_backend.services.JWTService;

// import jakarta.servlet.FilterChain;
// import jakarta.servlet.ServletException;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;

// @Component
// public class JwtFilter extends OncePerRequestFilter {

//     @Autowired
//     private JWTService jwtService;

//     @Override
//     protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//             throws ServletException, IOException {

//         final String authHeader = request.getHeader("Authorization");
//         String username = null;
//         String jwt = null;

//         if (authHeader != null && authHeader.startsWith("Bearer ")) {
//             jwt = authHeader.substring(7);
//             try {
//                 username = jwtService.extractUsername(jwt);
//             } catch (Exception e) {
//                 logger.error("JWT extraction failed: " + e.getMessage());
//             }
//         }

//         // Set authentication if valid
//         if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//             if (jwt != null) {
//                 // Extract roles from token
//                 Set<String> roles = jwtService.extractRoles(jwt);

//                 UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
//                         username,
//                         null,
//                         roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toSet())
//                 );

//                 authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                 SecurityContextHolder.getContext().setAuthentication(authToken);
//             }
//         }

//         filterChain.doFilter(request, response);
//     }
// }
