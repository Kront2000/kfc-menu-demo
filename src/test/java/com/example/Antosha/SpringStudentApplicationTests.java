package com.example.Antosha;

import com.example.Antosha.model.Category;
import com.example.Antosha.model.Dish;
import com.example.Antosha.repository.CategoryRepository;
import com.example.Antosha.repository.DishRepository;
import com.example.Antosha.service.CategoryService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;


//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest
public class SpringStudentApplicationTests {
    @Autowired
    private DishRepository dishRepository;
    @Autowired
    private CategoryRepository categoryRepository;


}
