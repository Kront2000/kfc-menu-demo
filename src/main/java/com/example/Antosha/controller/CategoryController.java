package com.example.Antosha.controller;

import com.example.Antosha.dto.CategoryDto;
import com.example.Antosha.model.Category;
import com.example.Antosha.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    private final CategoryService service;


    @GetMapping
    public List<CategoryDto> findAll(){
        return service.findAll();
    }
    @PostMapping("/save_category")
    public Category save(@RequestBody Category category){
        return service.save(category);
    }
}
