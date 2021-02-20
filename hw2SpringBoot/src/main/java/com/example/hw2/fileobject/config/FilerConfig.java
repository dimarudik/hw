package com.example.hw2.fileobject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import static com.example.hw2.common.repository.Constants.*;
//TODO добавьте комментарии
// волшебные цифры вынесите в константы)
//     Done
@Configuration
public class FilerConfig {

    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(FILEMAXSIZE);
        return multipartResolver;
    }
}
