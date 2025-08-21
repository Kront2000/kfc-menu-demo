package com.example.Antosha.exeption;

public class CategoryNotFoundException extends RuntimeException{
    public CategoryNotFoundException(Long id){
        super("Категория с индексом " + id + " не найдена");
    }
    public CategoryNotFoundException(String name){
        super("Категория с именем " + name + " не найдена");
    }
}
