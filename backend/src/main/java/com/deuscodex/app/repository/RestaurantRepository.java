package com.deuscodex.app.repository;

import com.deuscodex.app.domain.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    // 추가적인 쿼리 메서드가 필요한 경우 여기에 추가
}
