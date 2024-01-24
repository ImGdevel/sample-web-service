package com.deuscodex.app.mapper;

import com.deuscodex.app.domain.Menu;
import com.deuscodex.app.dto.MenuDTO;

public class MenuMapper {

    private MenuMapper() {
        // 인스턴스 생성 방지
    }

    public static MenuDTO toDTO(Menu menu) {
        return MenuDTO.builder()
                .menuId(menu.getId())
                .name(menu.getName())
                .price(menu.getPrice())
                .description(menu.getDescription())
                .build();
    }

    public static Menu toEntity(MenuDTO menuDTO) {
        return Menu.builder()
                .id(menuDTO.getMenuId())
                .name(menuDTO.getName())
                .price(menuDTO.getPrice())
                .description(menuDTO.getDescription())
                .build();
    }
}
