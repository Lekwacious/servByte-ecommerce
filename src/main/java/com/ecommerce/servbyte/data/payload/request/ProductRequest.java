package com.ecommerce.servbyte.data.payload.request;

import com.ecommerce.servbyte.data.models.Category;
import com.ecommerce.servbyte.data.models.ServiceProvider;
import lombok.Data;

import java.time.LocalTime;

@Data
public class ProductRequest {
    private String name;

    private String pictureUrl;

    private Double price;

    private String description;

    private LocalTime preparationTime;

    private Category category;

    private ServiceProvider serviceProvider;

}
