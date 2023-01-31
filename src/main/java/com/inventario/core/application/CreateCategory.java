package com.inventario.core.application;

import com.inventario.core.domain.entities.Category;
import com.inventario.core.domain.servicie.CreateCategoryService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateCategory {
    private final CreateCategoryService createCategoryService;
    public void createCategory(Category category) {
        createCategoryService.createCategory(category);
    }
}
