package com.beverage.beveragejavaclient;

import com.beverage.beveragejavaclient.api.ClientApiException;
import com.beverage.beveragejavaclient.api.RestaurantClient;
import org.springframework.web.client.RestTemplate;

public class ListRestaurantsMain {

    public static void main(String[] args) {
        try {
            RestTemplate restTemplate = new RestTemplate();

            RestaurantClient restaurantClient = new RestaurantClient(restTemplate, "http://localhost:8080");

            restaurantClient
                    .list()
                    .stream()
                    .forEach(restaurant -> System.out.println(restaurant));
        } catch (ClientApiException e) {
            if (e.getProblem() != null) {
                System.out.println(e.getProblem().toString());
            } else {
                System.out.println("Error unknown");
                e.printStackTrace();
            }
        }
    }
}
