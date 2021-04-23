package com.ecommerce.servbyte.data.models;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class ServiceProvider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameOfRestaurant;


    private String email;

    private String phoneNumber;

    @Enumerated
    private City city;

    private String logoUrl;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Product> products;

    public void addProductToServiceProvider(Product product){
        if(getProducts() == null){
            this.products = new ArrayList<>();
        }
        getProducts().add(product);
        product.setServiceProvider(this);
    }

}
