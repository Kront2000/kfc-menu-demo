package com.example.Antosha.repository;

import com.example.Antosha.model.Category;
import com.example.Antosha.model.Dish;
import jakarta.persistence.EntityManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.transaction.annotation.Transactional;

@DataJpaTest
public class CategoryRepositoryTest {

    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void save(){
        Category category = Category.builder()
                .name("Category")
                .build();
        Category insertedCategory = categoryRepository.save(category);
        Dish dish = Dish.builder()
                .name("name")
                .category(insertedCategory)
                .price(1L)
                .image_path("image")
                .build();
        Dish insertedDish = dishRepository.save(dish);

        Assertions.assertThat(entityManager.find(Dish.class, insertedDish.getId())).isEqualTo(dish);
    }

}

