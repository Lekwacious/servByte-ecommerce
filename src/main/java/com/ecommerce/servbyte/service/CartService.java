package com.ecommerce.servbyte.service;

import com.ecommerce.servbyte.data.models.Cart;

import java.util.List;

public interface CartService {

    Cart addCartToUser(Cart cart, long idUser);

    void deleteCart(long id);

    List<Cart> findCartsForUser(long idUser);

    Cart findCartById(long id);

    void removeFromCart(long idCart, long idUser);

    Cart findByCartName(String name);
}
