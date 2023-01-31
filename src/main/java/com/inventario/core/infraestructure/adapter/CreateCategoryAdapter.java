package com.inventario.core.infraestructure.adapter;

import com.inventario.core.domain.entities.Category;
import com.inventario.core.domain.servicie.CreateCategoryService;
import com.inventario.core.infraestructure.mapper.CategoryMapper;
import com.inventario.core.infraestructure.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Slf4j
public class CreateCategoryAdapter implements CreateCategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    public Category createCategory(Category category){
        log.info("Creando una categoria...");
        return categoryMapper.toEntity(categoryRepository.save(categoryMapper.toDto(category)));
    }
}
