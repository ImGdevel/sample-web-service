package com.deuscodex.app.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MenuDTO {

    private Long menuId;

    @NotBlank(message = "Menu name cannot be blank")
    private String name;

    private double price;

    @NotBlank(message = "Description cannot be blank")
    private String description;

    // Getters and Setters
}

