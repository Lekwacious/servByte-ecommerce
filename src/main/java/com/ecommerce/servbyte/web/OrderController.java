package com.ecommerce.servbyte.web;

import com.ecommerce.servbyte.data.models.Order;
import com.ecommerce.servbyte.data.models.OrderProduct;
import com.ecommerce.servbyte.data.models.OrderStatus;
import com.ecommerce.servbyte.data.models.ResourceNotFoundException;
import com.ecommerce.servbyte.data.models.dto.OrderProductDto;
import com.ecommerce.servbyte.service.OrderProductService;
import com.ecommerce.servbyte.service.OrderService;
import com.ecommerce.servbyte.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private ProductService productService;
    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderProductService orderProductService;

    public OrderController(ProductService productService, OrderService orderService,
                           OrderProductService orderProductService) {
        super();
        this.productService = productService;
        this.orderService = orderService;
        this.orderProductService = orderProductService;
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public @NotNull Iterable<Order> list(){
        return this.orderService.getAllOrders();
    }


    @PostMapping("/orders")
    public ResponseEntity<Order> create(@RequestBody OrderForm form){
        List<OrderProductDto> formDtos = form.getpOrderProductDtos();
        validateProductsExistance(formDtos);
        Order order = new Order();
        order.setStatus(OrderStatus.PAID.name());
        order = this.orderService.create(order);

        List<OrderProduct> orderProducts = new ArrayList<OrderProduct>();
        for(OrderProductDto dto: formDtos) {
            orderProducts.add(orderProductService.create(new OrderProduct(order, productService.getProduct(dto.getProduct().getId()), dto.getQuantity())));
        }
        order.setOrderProducts(orderProducts);
        this.orderService.update(order);

        String uri = ServletUriComponentsBuilder
                .fromCurrentServletMapping()
                .path("/orders/{id}")
                .buildAndExpand(order.getId())
                .toString();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", uri);

        return new ResponseEntity<>(order, headers, HttpStatus.CREATED);

    }

    private void validateProductsExistance(List<OrderProductDto> orderProducts) {
        List<OrderProductDto> list = orderProducts
                .stream()
                .filter(op -> Objects.isNull(productService.getProduct(op.getProduct().getId())))
                .collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(list)) {
            new ResourceNotFoundException("Product not found");

        }
    }

    public static  class OrderForm {
        private List<OrderProductDto> orderProductDtos;

        public List<OrderProductDto> getpOrderProductDtos() {
            return orderProductDtos;
        }

        public void setpOrderProductDtos(List<OrderProductDto> orderProductDtos) {
            this.orderProductDtos = orderProductDtos;
        }
    }

}
