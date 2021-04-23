package com.ecommerce.servbyte.service;

import com.ecommerce.servbyte.data.models.Product;
import com.ecommerce.servbyte.data.payload.request.ProductRequest;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface ProductService {
    Product save(ProductRequest productRequest);
//    Product addProductToCategory(Product product, long idCategory);

    Product editProduct(Product product, long id);

    Product findProductById(long id);

    void deleteProduct(long id);

    List<Product> findAllProducts();

    List<Product> findProductsForCategory(long idCategory);

    Product getProduct(long id);
}
