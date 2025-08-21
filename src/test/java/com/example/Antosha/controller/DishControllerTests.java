package com.example.Antosha.controller;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.Antosha.dto.DishDto;
import com.example.Antosha.service.DishService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
class DishControllerTests {
    @Mock
    private DishService dishService;

    @InjectMocks
    private DishController dishController;

    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void init(){
        mockMvc = MockMvcBuilders.standaloneSetup(dishController).build();
        objectMapper = new ObjectMapper();
    }
    @Test
    void getById() throws Exception {
        DishDto dishDto = DishDto.builder().id(1L).name("name").category_id(1L).category_name("category")
                .description("description").image_path("image").price(1L).build();
        Mockito.when(dishService.findById(1L)).thenReturn(dishDto);
        mockMvc.perform(get("/api/v1/menu/getById?id=1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("name"))
                .andExpect(jsonPath("$.description").value("description"))
                .andExpect(jsonPath("$.image_path").value("image"))
                .andExpect(jsonPath("$.price").value(1L));
    }
}
