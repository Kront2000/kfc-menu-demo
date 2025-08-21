package com.example.Antosha.controller;


import com.example.Antosha.dto.CategoryDishDto;
import com.example.Antosha.dto.DishDto;
import com.example.Antosha.model.Dish;
import com.example.Antosha.service.CategoryService;
import com.example.Antosha.service.DishService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/menu")
public class DishController {
    private final DishService dishService;

    private Validator validator;

    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryDishDto> getMenu(){
        return categoryService.getMenu();
    }

    @PostMapping("/add_dish")
    @CacheEvict(value = "menu", allEntries = true)
    public void save(@RequestParam("name") String name,
                     @RequestParam("description") String description,
                     @RequestParam("category") String category,
                     @RequestParam("price") Long price, @RequestPart(value = "image", required = false) MultipartFile image) throws IOException {
        DishDto dishDto = DishDto.builder()
                .name(name)
                .image(image)
                .price(price)
                .description(description)
                .category_name(category)
                .build();
        Set<ConstraintViolation<DishDto>> violations = validator.validate(dishDto);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
        System.out.println(dishDto);
        System.out.println(dishService.save(dishDto));
    }

    @GetMapping("/getById")
    public DishDto getById(@RequestParam("id") String id){
        System.out.println("id - " + id);
        return dishService.findById(Long.valueOf(id));
    }

    @PostMapping("/updateDish")
    @CacheEvict(value = "menu", allEntries = true)
    public void updateDish(@RequestParam("id") Long id, @RequestParam("name") String name,
                           @RequestParam("description") String description,
                           @RequestParam("category") String category,
                           @RequestParam("price") Long price, @RequestPart(value = "image", required = false) MultipartFile image) throws IOException {
        DishDto dishDto = DishDto.builder()
                .id(id)
                .name(name)
                .image(image)
                .price(price)
                .description(description)
                .category_name(category)
                .build();
        Set<ConstraintViolation<DishDto>> violations = validator.validate(dishDto);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
        System.out.println(dishDto);
        System.out.println(dishService.updateDish(dishDto));
    }
    @DeleteMapping("/deleteDish")
    @CacheEvict(value = "menu", allEntries = true)
    public void deleteDish(@RequestParam("id") Long id){
        dishService.deleteDish(id);
    }
}
