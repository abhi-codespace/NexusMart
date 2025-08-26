package com.nexusmart.nexusmart_backend.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="users")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;
    
    @Column(nullable = false)
    private String email;

     @Column(nullable = false,unique=true)
    private String password;


    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
        name="user_roles",
        joinColumns = @JoinColumn(name="user_id")
    )
    @Enumerated(EnumType.STRING)
    @Column(name="role")
    private Set<Role> roles=new HashSet<>();

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    private Cart cart;
    
}
