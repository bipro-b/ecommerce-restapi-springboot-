package com.bipro.ecommerce.Domain.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="products")

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="product_name")
    private String name;
    @Column(name="description")
    private String description;
    @Column(name="price")
    private double price;
    @Column (name="status")
    private boolean isAvailable;

}
