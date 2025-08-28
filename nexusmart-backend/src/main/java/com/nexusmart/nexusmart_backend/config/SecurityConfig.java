// package com.nexusmart.nexusmart_backend.config;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
// import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// import com.nexusmart.nexusmart_backend.filter.JwtFilter;
// import com.nexusmart.nexusmart_backend.services.CustomUserDetailsService;

// @Configuration
// public class SecurityConfig {

//     @Autowired
//     private CustomUserDetailsService userDetailsService;

//     @Autowired
//     private JwtFilter jwtFilter;

//     // Password encoder
//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }

//     // Authentication manager
//     @Bean
//     public AuthenticationManager authManager(HttpSecurity http) throws Exception {
//         return http.getSharedObject(AuthenticationManagerBuilder.class)
//                 .userDetailsService(userDetailsService)
//                 .passwordEncoder(passwordEncoder())
//                 .and()
//                 .build();
//     }

//     // Security filter chain
//     @Bean
//     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//         http.csrf(csrf -> csrf.disable())
//             .authorizeHttpRequests(auth -> auth
//                 .requestMatchers("/auth/**").permitAll()      // Public endpoints
//                 .requestMatchers("/admin/**").hasRole("ADMIN") // Admin endpoints
//                 .requestMatchers("/user/**").hasRole("USER")   // User endpoints
//                 .anyRequest().authenticated()
//             )
//             .sessionManagement(session -> session
//                 .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//             );

//         // Add JWT filter before Spring Security authentication
//         http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

//         return http.build();
//     }
// }
