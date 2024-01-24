package com.deuscodex.app.service.impl;

import com.deuscodex.app.domain.Menu;
import com.deuscodex.app.dto.MenuDTO;
import com.deuscodex.app.mapper.MenuMapper;
import com.deuscodex.app.repository.MenuRepository;
import com.deuscodex.app.service.MenuService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Override
    public MenuDTO getMenuById(Long menuId) {
        Menu menu = menuRepository.findById(menuId)
                .orElseThrow(() -> new EntityNotFoundException("Menu not found with id: " + menuId));
        return MenuMapper.toDTO(menu);
    }

    @Override
    public List<MenuDTO> getAllMenus() {
        List<Menu> menus = menuRepository.findAll();
        return menus.stream()
                .map(MenuMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public MenuDTO createMenu(MenuDTO menuDTO) {
        Menu menu = MenuMapper.toEntity(menuDTO);
        Menu savedMenu = menuRepository.save(menu);
        return MenuMapper.toDTO(savedMenu);
    }

    @Override
    @Transactional
    public MenuDTO updateMenu(Long menuId, MenuDTO menuDTO) {
        Menu existingMenu = menuRepository.findById(menuId)
                .orElseThrow(() -> new EntityNotFoundException("Menu not found with id: " + menuId));

        existingMenu.setName(menuDTO.getName());
        existingMenu.setPrice(menuDTO.getPrice());
        existingMenu.setDescription(menuDTO.getDescription());

        Menu updatedMenu = menuRepository.save(existingMenu);
        return MenuMapper.toDTO(updatedMenu);
    }

    @Override
    @Transactional
    public boolean deleteMenu(Long menuId) {
        if (menuRepository.existsById(menuId)) {
            menuRepository.deleteById(menuId);
            return true;
        } else {
            return false;
        }
    }
}
