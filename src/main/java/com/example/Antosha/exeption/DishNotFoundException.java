package com.example.Antosha.exeption;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class DishNotFoundException extends RuntimeException{
    public DishNotFoundException(Long id){
        super("Блюдо с индексом " + id + " не найден");
    }
}
