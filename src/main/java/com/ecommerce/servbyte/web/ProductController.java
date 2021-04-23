package com.ecommerce.servbyte.web;

import com.ecommerce.servbyte.data.models.Product;
import com.ecommerce.servbyte.data.payload.request.ProductRequest;
import com.ecommerce.servbyte.data.repository.ProductRepository;
import com.ecommerce.servbyte.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class ProductController {


    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

//    @PostMapping("/addProductToCategory/{idCategory}")
//    Product addProductToCategory(@RequestBody Product product, @PathVariable long idCategory) {
//        return productService.addProductToCategory(product, idCategory);
//    }
    @PostMapping("/create-product/")
    Product createProduct(@RequestBody ProductRequest productRequest) {
        return productService.save(productRequest);
    }

    @PutMapping("/editProduct/{id}")
    Product editProduct(@RequestBody Product product, @PathVariable long id) {
        return productService.editProduct(product, id);
    }

    @GetMapping("/findProductById/{id}")
    Product findProductById(@PathVariable long id) {
        return productService.findProductById(id);
    }

    @DeleteMapping("/deleteProduct/{id}")
    void deleteProduct(@PathVariable long id) {
        productService.deleteProduct(id);
    }

    @GetMapping("/findAllProducts")
    List<Product> findAllProducts() {
        return productService.findAllProducts();
    }

    @GetMapping("/findProductsForCategory/{idCategory}")
    List<Product> findProductsForCategory(@PathVariable long idCategory) {
        return productService.findProductsForCategory(idCategory);
    }

    @GetMapping("/findByName/{name}")
    List<Product> findByName(@PathVariable String name) {
        return productRepository.findByName("%" + name + "%");
    }
}
