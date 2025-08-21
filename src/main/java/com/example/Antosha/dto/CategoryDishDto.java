package com.example.Antosha.dto;

import com.example.Antosha.model.Dish;

import java.util.List;

public record CategoryDishDto(String name, List<Dish> dishes) {
}
