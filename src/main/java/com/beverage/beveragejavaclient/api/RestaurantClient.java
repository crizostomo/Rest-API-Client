package com.beverage.beveragejavaclient.api;


import com.beverage.beveragejavaclient.model.RestaurantModel;
import lombok.AllArgsConstructor;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
public class RestaurantClient {

    private static final String RESOURCE_PATH = "/restaurantsss";
    private RestTemplate restTemplate;
    private String url;

    public List<RestaurantModel> list() {
        try {
            URI resourceUri = URI.create(url + RESOURCE_PATH);

            RestaurantModel[] restaurants = restTemplate.getForObject(resourceUri, RestaurantModel[].class);

            return Arrays.asList(restaurants);
        } catch (RestClientResponseException e) {
            throw new ClientApiException(e.getMessage(), e);
        }
    }
}
