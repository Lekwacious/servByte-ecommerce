package com.ecommerce.servbyte.service;

import com.ecommerce.servbyte.data.models.Category;
import com.ecommerce.servbyte.data.models.Product;
import com.ecommerce.servbyte.data.models.ServiceProvider;
import com.ecommerce.servbyte.data.payload.request.ProductRequest;
import com.ecommerce.servbyte.data.repository.CategoryRepository;
import com.ecommerce.servbyte.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Product save(ProductRequest productRequest) {
        Product newProduct = new Product();
        newProduct.setName(productRequest.getName());
        newProduct.setDescription(productRequest.getDescription());
        newProduct.setPrice(productRequest.getPrice());
        newProduct.setPictureUrl(productRequest.getPictureUrl());
        newProduct.setPreparationTime(productRequest.getPreparationTime());
        newProduct.setCategory(productRequest.getCategory());
        newProduct.setServiceProvider(productRequest.getServiceProvider());
        return productRepository.save(newProduct);
    }

//    @Override
//    public Product addProductToCategory(Product product, long idCategory) {
//        Category category = categoryRepository.findById(idCategory).orElse(null);
//        category.addProductToCategory(product);
//        return productRepository.save(product);
//    }

    @Override
    public Product editProduct(Product product, long id) {
        Product existProduct = productRepository.findById(id).orElse(null);
        existProduct.setName(product.getName());
        existProduct.setDescription(product.getDescription());
        existProduct.setPictureUrl(product.getPictureUrl());
        existProduct.setPrice(product.getPrice());
        return productRepository.save(existProduct);
    }

    @Override
    public Product findProductById(long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteProduct(long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findProductsForCategory(long idCategory) {
        Category category = categoryRepository.findById(idCategory).orElse(null);
        return category.getProducts();
    }

    @Override
    public Product getProduct(long id) {
        return productRepository.findById(id).orElse(null);
    }
}
