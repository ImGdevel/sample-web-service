package com.deuscodex.app.service;

import com.deuscodex.app.dto.RestaurantDTO;

import java.util.List;

public interface RestaurantService {

    RestaurantDTO getRestaurantById(Long restaurantId);

    List<RestaurantDTO> getAllRestaurants();

    RestaurantDTO createRestaurant(RestaurantDTO restaurantDTO);

    RestaurantDTO updateRestaurant(Long restaurantId, RestaurantDTO restaurantDTO);

    boolean deleteRestaurant(Long restaurantId);
}
