package com.example.Antosha.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.springframework.web.multipart.MultipartFile;

@Builder
public record DishDto(Long id,
                      @NotBlank(message = "Имя отсутствует")
                      String name,
                      Long category_id,
                      String category_name,
                      @NotBlank(message = "Описание отсутствует")
                      String description,
                      String image_path,
                      @Min(value = 1, message = "Цена должна быть больше 1")
                      Long price,
                      MultipartFile image) {
}
