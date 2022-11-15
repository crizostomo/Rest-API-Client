package com.beverage.beveragejavaclient.model.input;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RestaurantInput {

    private String name;
    private BigDecimal delivery;

    private KitchenIdInput kitchen;
    private AddressInput address;
}
