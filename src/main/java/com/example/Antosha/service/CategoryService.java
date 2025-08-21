package com.example.Antosha.service;

import com.example.Antosha.dto.CategoryDishDto;
import com.example.Antosha.dto.CategoryDto;
import com.example.Antosha.model.Category;
import com.example.Antosha.model.Dish;
import com.example.Antosha.repository.CategoryRepository;
import com.example.Antosha.repository.DishRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Data
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final DishRepository dishRepository;

    public List<CategoryDto> findAll(){
        return categoryRepository.findAll().stream()
                .map(category -> new CategoryDto(category.getId(), category.getName()))
                .toList();
    }
    public Category save(Category category){
        return categoryRepository.save(category);
    }

    @Cacheable("menu")
    public List<CategoryDishDto>  getMenu(){
        // Получаем все категории
        List<Category> categories = categoryRepository.findAll();

// Получаем все блюда одним запросом
        List<Dish> dishes = dishRepository.findAll();

// Группируем блюда по категории
        Map<Category, List<Dish>> dishesByCategory = dishes.stream()
                .collect(Collectors.groupingBy(Dish::getCategory));

// Собираем DTO
        List<CategoryDishDto> result = categories.stream()
                .map(cat -> new CategoryDishDto(
                        cat.getName(),
                        dishesByCategory.getOrDefault(cat, List.of())
                ))
                .toList();
        return result;
    }
}
