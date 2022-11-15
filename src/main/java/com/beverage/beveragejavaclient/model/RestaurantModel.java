package com.beverage.beveragejavaclient.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RestaurantModel {

    private Long id;
    private String name;
    private BigDecimal delivery;
    private KitchenModel kitchen;
}
