package com.example.Antosha.repository;

import com.example.Antosha.model.Category;
import com.example.Antosha.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {
    public List<Dish> findByCategory(Category category);

}
