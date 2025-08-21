package com.example.Antosha.service;

import com.example.Antosha.dto.DishDto;
import com.example.Antosha.exeption.CategoryNotFoundException;
import com.example.Antosha.exeption.DishNotFoundException;
import com.example.Antosha.model.Category;
import com.example.Antosha.model.Dish;
import com.example.Antosha.repository.CategoryRepository;
import com.example.Antosha.repository.DishRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

import static java.util.stream.Collectors.toList;

@AllArgsConstructor
@Service
public class DishService {
    private final DishRepository dishRepository;
    private final CategoryRepository categoryRepository;
    private final AddImageService addImageService;

    public List<DishDto> findAll(){
        return dishRepository.findAll().stream().map(dish -> DishDto.builder()
                .id(dish.getId())
                .name(dish.getName())
                .category_id(dish.getCategory().getId())
                .category_name(dish.getCategory().getName())
                .description(dish.getDescription())
                .image_path(dish.getImage_path())
                .price(dish.getPrice()).build()
        ).toList();
    }
    public Dish save(DishDto dishDto) throws IOException {
        Category category = categoryRepository.findByName(dishDto.category_name()).orElse(new Category());
        Dish newDish = Dish.builder()
                .name(dishDto.name())
                .price(dishDto.price())
                .description(dishDto.description())
                .category(category)
                .image_path(addImageService.addImageCloudinary(dishDto.image()))
                .build();
        return dishRepository.save(newDish);
    }
    public DishDto findById(Long id){
        Dish dish = dishRepository.findById(id).orElseThrow(() -> new DishNotFoundException(id));
        return DishDto.builder()
                .id(dish.getId())
                .name(dish.getName())
                .category_id(dish.getCategory().getId())
                .category_name(dish.getCategory().getName())
                .description(dish.getDescription())
                .image_path(dish.getImage_path())
                .price(dish.getPrice()).build();

    }

    public Dish updateDish(DishDto dishDto) throws IOException {
        Dish dish = dishRepository.findById(dishDto.id()).orElse(new Dish());
        Category category = categoryRepository.findByName(dishDto.category_name()).orElseThrow(() -> new CategoryNotFoundException(dishDto.category_name()));
        Dish newDish = Dish.builder()
                .name(dishDto.name())
                .price(dishDto.price())
                .id(dishDto.id())
                .description(dishDto.description())
                .category(category)
                .image_path(dishDto.image() == null ? dish.getImage_path() : addImageService.addImageCloudinary(dishDto.image()))
                .build();
        return dishRepository.save(newDish);
    }

    public void deleteDish(Long id){
        dishRepository.deleteById(id);
    }
}
