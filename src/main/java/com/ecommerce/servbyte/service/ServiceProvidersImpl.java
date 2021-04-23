package com.ecommerce.servbyte.service;

import com.ecommerce.servbyte.data.models.Category;
import com.ecommerce.servbyte.data.models.City;
import com.ecommerce.servbyte.data.models.Product;
import com.ecommerce.servbyte.data.models.ServiceProvider;
import com.ecommerce.servbyte.data.repository.ServiceProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceProvidersImpl implements ServiceProviderService {

    @Autowired
    private ServiceProviderRepository serviceProviderRepository;

    @Override
    public List<ServiceProvider> findAllServiceProviders() {
        return serviceProviderRepository.findAll();
    }

    @Override
    public List<ServiceProvider> findServiceProvidersByCity(City city) {
        return serviceProviderRepository.findByCity(city);
    }

    @Override
    public ServiceProvider findById(Long id) {
        return serviceProviderRepository.findById(id).orElse(null);
    }

    @Override
    public ServiceProvider addProductToServiceProvider(Product product, long idServiceProvider) {
        ServiceProvider serviceProvider = serviceProviderRepository.findById(idServiceProvider).orElse(null);
        serviceProvider.addProductToServiceProvider(product);
        return serviceProviderRepository.save(serviceProvider);

    }
}
