package com.ecommerce.servbyte.data.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(name = "carts")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double price;
    private int quantity;
    private String pictureUrl;

    @JsonBackReference(value = "user")
    @ManyToOne
    private User user;

}
