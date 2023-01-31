package com.inventario.core.application;

import com.inventario.core.domain.entities.Category;
import com.inventario.core.domain.servicie.CreateCategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class CreateCategoryTest {
    @InjectMocks
    private CreateCategory createCategory;
    @Mock
    private CreateCategoryService createCategoryService;

    @Test
    void createCategory() {
        var build = buildCategory();
        var response = buildCategory();
        Mockito.when(createCategoryService.createCategory(build)).thenReturn(response);
        createCategory.createCategory(build);
        Mockito.verify(createCategoryService,Mockito.times(1)).createCategory(build);
    }

    private Category buildCategory() {
        return Category.builder().id(2).name("Juguetes").sizeUnit("unidad").build();
    }
}