package com.beverage.beveragejavaclient.model.input;

import lombok.Data;

@Data
public class AddressInput {

    private String cep;
    private String street;
    private String number;
    private String complement;
    private String neighborhood;
    private CityIdInput city;
}
