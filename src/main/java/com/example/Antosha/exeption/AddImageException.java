package com.example.Antosha.exeption;

import com.example.Antosha.service.AddImageService;

import java.io.IOException;

public class AddImageException extends RuntimeException {
    public AddImageException(){
        super("Ошибка при добавлении изображения");
    }
}
