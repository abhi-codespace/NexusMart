package com.nexusmart.nexusmart_backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(
    name="product"
)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="poduct_name",nullable = false)
    private String productName;

    private String description;

    @Column(nullable = false)
    private Double price;

    private String imageUrl;

    private Integer stock;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;
    
}
