package com.beverage.beveragejavaclient;

import com.beverage.beveragejavaclient.api.ClientApiException;
import com.beverage.beveragejavaclient.api.RestaurantClient;
import com.beverage.beveragejavaclient.model.RestaurantModel;
import com.beverage.beveragejavaclient.model.input.AddressInput;
import com.beverage.beveragejavaclient.model.input.CityIdInput;
import com.beverage.beveragejavaclient.model.input.KitchenIdInput;
import com.beverage.beveragejavaclient.model.input.RestaurantInput;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

public class InclusionRestaurantsMain {

    public static void main(String[] args) {
        try {
            var restTemplate = new RestTemplate();
            var restaurantClient = new RestaurantClient(
                    restTemplate, "http://localhost:8080");

            var kitchen = new KitchenIdInput();
            kitchen.setId(1L);

            var city = new CityIdInput();
            city.setId(1L);

            var address = new AddressInput();
            address.setCity(city);
            address.setCep("38500-111");
            address.setStreet("Xyz Street");
            address.setNumber("300");
            address.setNeighborhood("Downtown");

            var restaurant = new RestaurantInput();
            restaurant.setName("Comida Mineira");
            restaurant.setDelivery(new BigDecimal(9.5));
            restaurant.setKitchen(new KitchenIdInput());
            restaurant.setKitchen(kitchen);
            restaurant.setAddress(address);

            RestaurantModel restaurantModel = restaurantClient.add(restaurant);

            System.out.println(restaurantModel);
        } catch (ClientApiException e) {
            if (e.getProblem() != null) {
                System.out.println(e.getProblem().getUserMessage());

                e.getProblem().getObjects().stream()
                        .forEach(p -> System.out.println("- " + p.getUserMessage()));

            } else {
                System.out.println("Error Unknown");
                e.printStackTrace();
            }
        }
    }
}
