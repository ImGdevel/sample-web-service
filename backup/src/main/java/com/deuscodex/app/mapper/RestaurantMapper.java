package com.deuscodex.app.mapper;

import com.deuscodex.app.domain.Restaurant;
import com.deuscodex.app.dto.RestaurantDTO;

public class RestaurantMapper {

    private RestaurantMapper() {
        // 인스턴스 생성 방지
    }

    public static RestaurantDTO toDTO(Restaurant restaurant) {
        return RestaurantDTO.builder()
                .restaurantId(restaurant.getId())
                .name(restaurant.getName())
                .location(restaurant.getLocation())
                .phoneNumber(restaurant.getPhoneNumber())
                .operatingHours(restaurant.getOperatingHours())
                .rating(restaurant.getRating())
                .build();
    }

    public static Restaurant toEntity(RestaurantDTO restaurantDTO) {
        return Restaurant.builder()
                .id(restaurantDTO.getRestaurantId())
                .name(restaurantDTO.getName())
                .location(restaurantDTO.getLocation())
                .phoneNumber(restaurantDTO.getPhoneNumber())
                .operatingHours(restaurantDTO.getOperatingHours())
                .rating(restaurantDTO.getRating())
                .build();
    }
}
