package com.ecommerce.servbyte.service;

import com.ecommerce.servbyte.data.models.City;
import com.ecommerce.servbyte.data.models.Product;
import com.ecommerce.servbyte.data.models.ServiceProvider;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ServiceProviderService {
    List<ServiceProvider> findAllServiceProviders();
    List<ServiceProvider> findServiceProvidersByCity(City city);
    ServiceProvider findById(Long id);
    ServiceProvider addProductToServiceProvider(Product product, long idServiceProvider);
}
