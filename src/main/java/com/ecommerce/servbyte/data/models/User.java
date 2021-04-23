package com.ecommerce.servbyte.data.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(unique = true)
    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private String email;

    private String address;

    @JsonProperty(access = JsonProperty.Access.AUTO)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Category> categories;

    @JsonProperty(access = JsonProperty.Access.AUTO)
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "user")
    private List<Cart> carts;

    public User() {
        super();
    }
    public void addCategoryToUser(Category category) {
        if (getCategories()==null) {
            this.categories = new ArrayList<>();
        }
        getCategories().add(category);
        category.setUser(this);
    }

    public void addCartToUser(Cart cart) {
        if(getCarts()==null) {
            this.carts = new ArrayList<>();
        }
        getCarts().add(cart);
        cart.setUser(this);
    }

    public void removeFromCart(Cart cart) {
        if (getCarts()!=null) {
            getCarts().remove(cart);
        }
    }

}
