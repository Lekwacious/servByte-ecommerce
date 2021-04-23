package com.ecommerce.servbyte.data.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JsonBackReference(value = "user")
    @ManyToOne
    private User user;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private List<Product> products;

    public void addProductToCategory(Product product){
        if(getProducts() == null){
            this.products = new ArrayList<>();
        }
        getProducts().add(product);
        product.setCategory(this);
    }
}
