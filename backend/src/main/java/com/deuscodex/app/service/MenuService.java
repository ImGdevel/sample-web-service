package com.deuscodex.app.service;

import com.deuscodex.app.dto.MenuDTO;

import java.util.List;

public interface MenuService {

    MenuDTO getMenuById(Long menuId);

    List<MenuDTO> getAllMenus();

    MenuDTO createMenu(MenuDTO menuDTO);

    MenuDTO updateMenu(Long menuId, MenuDTO menuDTO);

    boolean deleteMenu(Long menuId);
}
