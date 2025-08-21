package com.example.Antosha.service;

import com.example.Antosha.dto.DishDto;
import com.example.Antosha.model.Category;
import com.example.Antosha.model.Dish;
import com.example.Antosha.repository.CategoryRepository;
import com.example.Antosha.repository.DishRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class DishServiceTests {

    @Mock
    private DishRepository dishRepository;

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private AddImageService addImageService;

    @InjectMocks
    private DishService dishService;

    @Test
    public void findAll_WithTwoDish(){
        Dish dish1 = Dish.builder().id(1L).description("description1").image_path("image1").name("name1").price(1L)
                .category(new Category(1L, "category1")).build();
        Dish dish2 = Dish.builder().id(2L).description("description2").image_path("image2").name("name2").price(2L)
                .category(new Category(2L, "category2")).build();
        Mockito.when(dishRepository.findAll()).thenReturn(List.of(dish1, dish2));
        DishDto dishDto1 = DishDto.builder().id(1L).name("name1").category_id(1L).category_name("category1")
                .description("description1").image_path("image1").price(1L).build();
        DishDto dishDto2 = DishDto.builder().id(2L).name("name2").category_id(2L).category_name("category2")
                .description("description2").image_path("image2").price(2L).build();
        Assertions.assertEquals(List.of(dishDto1, dishDto2), dishService.findAll());
    }
}
