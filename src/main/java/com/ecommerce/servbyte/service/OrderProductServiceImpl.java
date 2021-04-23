package com.ecommerce.servbyte.service;

import com.ecommerce.servbyte.data.models.OrderProduct;
import com.ecommerce.servbyte.data.repository.OrderProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Transactional
@Component
public class OrderProductServiceImpl implements OrderProductService{
    @Autowired
    OrderProductRepository orderProductRepository;
    @Override
    public OrderProduct create(@NotNull(message = "The products for order cannot be null.") @Valid OrderProduct orderProduct) {
        return this.orderProductRepository.save(orderProduct);
    }
}
