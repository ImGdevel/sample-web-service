package com.deuscodex.app.service.impl;

import com.deuscodex.app.domain.Restaurant;
import com.deuscodex.app.dto.RestaurantDTO;
import com.deuscodex.app.mapper.RestaurantMapper;
import com.deuscodex.app.repository.RestaurantRepository;
import com.deuscodex.app.service.RestaurantService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public RestaurantDTO getRestaurantById(Long restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new EntityNotFoundException("Restaurant not found with id: " + restaurantId));
        return RestaurantMapper.toDTO(restaurant);
    }

    @Override
    public List<RestaurantDTO> getAllRestaurants() {
        List<Restaurant> restaurants = restaurantRepository.findAll();
        return restaurants.stream()
                .map(RestaurantMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public RestaurantDTO createRestaurant(RestaurantDTO restaurantDTO) {
        Restaurant restaurant = RestaurantMapper.toEntity(restaurantDTO);
        Restaurant savedRestaurant = restaurantRepository.save(restaurant);
        return RestaurantMapper.toDTO(savedRestaurant);
    }

    @Override
    @Transactional
    public RestaurantDTO updateRestaurant(Long restaurantId, RestaurantDTO restaurantDTO) {
        Restaurant existingRestaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new EntityNotFoundException("Restaurant not found with id: " + restaurantId));

        existingRestaurant.setName(restaurantDTO.getName());
        existingRestaurant.setLocation(restaurantDTO.getLocation());
        existingRestaurant.setPhoneNumber(restaurantDTO.getPhoneNumber());
        existingRestaurant.setOperatingHours(restaurantDTO.getOperatingHours());
        existingRestaurant.setRating(restaurantDTO.getRating());

        Restaurant updatedRestaurant = restaurantRepository.save(existingRestaurant);
        return RestaurantMapper.toDTO(updatedRestaurant);
    }

    @Override
    @Transactional
    public boolean deleteRestaurant(Long restaurantId) {
        if (restaurantRepository.existsById(restaurantId)) {
            restaurantRepository.deleteById(restaurantId);
            return true;
        } else {
            return false;
        }
    }
}
