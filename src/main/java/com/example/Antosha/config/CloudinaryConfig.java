package com.example.Antosha.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {
    @Bean
    public Cloudinary cloudinary(){
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dwoclq7g5",
                "api_key", "388686195482322",
                "api_secret", "-j0rdPD5r64oRzl4-9P_ewkv3Ro"
        ));
    }
}
