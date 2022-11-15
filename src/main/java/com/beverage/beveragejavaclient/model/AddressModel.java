package com.beverage.beveragejavaclient.model;

import com.beverage.beveragejavaclient.model.input.CityIdInput;
import lombok.Data;

@Data
public class AddressModel {

    private String cep;
    private String street;
    private String number;
    private String complement;
    private String neighborhood;
    private CitySummaryModel city;
}
