package com.ecommerce.servbyte.data.models;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class Meal extends Product {


    private LocalDateTime preparationTime;


}
