package com.ecommerce.servbyte.data.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Data
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;

    private String pictureUrl;

    private Double price;

    private String description;

    private LocalTime preparationTime;

    @JsonBackReference(value = "category")
    @ManyToOne
    private Category category;

    @JsonBackReference(value = "service providers")
    @ManyToOne
    private ServiceProvider serviceProvider;
}
