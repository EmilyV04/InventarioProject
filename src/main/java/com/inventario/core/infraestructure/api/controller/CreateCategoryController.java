package com.inventario.core.infraestructure.api.controller;

import com.inventario.core.application.CreateCategory;
import com.inventario.core.infraestructure.api.mapper.CategoryRequestMapper;
import com.inventario.core.infraestructure.api.request.CategoryRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("category")
@RequiredArgsConstructor
public class CreateCategoryController {
    private final CreateCategory createCategory;
    private final CategoryRequestMapper categoryRequestMapper;
    @PostMapping(value = "/createCategory")
    public void CreateCategory(@RequestBody CategoryRequest categoryRequest){
        createCategory.createCategory(categoryRequestMapper.toEntity(categoryRequest));
    }
}
