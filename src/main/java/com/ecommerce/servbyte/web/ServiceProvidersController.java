package com.ecommerce.servbyte.web;

import com.ecommerce.servbyte.data.models.City;
import com.ecommerce.servbyte.data.models.Product;
import com.ecommerce.servbyte.data.models.ServiceProvider;
import com.ecommerce.servbyte.service.ServiceProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class ServiceProvidersController {

    @Autowired
    ServiceProviderService serviceProviderService;

    @PostMapping("/addProductToCategory/{idCategory}")
    ServiceProvider addProductToServiceProvider(@RequestBody Product product, @PathVariable long idServiceProvider) {
        return serviceProviderService.addProductToServiceProvider(product, idServiceProvider);
    }

    @GetMapping("/service-providers/findAll")
    List<ServiceProvider> findAllServiceProvider() {
        return serviceProviderService.findAllServiceProviders();
    }


    @GetMapping("/service-providers/findByCity")
    List<ServiceProvider> findServiceProviderByCity(@RequestBody City city) {
        return serviceProviderService.findServiceProvidersByCity(city);
    }

    @GetMapping("/findServiceProvidersById/{id}")
    ServiceProvider findServiceProviderById(@PathVariable long id) {
        return serviceProviderService.findById(id);
    }

}
