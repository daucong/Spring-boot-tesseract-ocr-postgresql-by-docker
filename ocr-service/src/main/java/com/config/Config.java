package com.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import net.sourceforge.tess4j.Tesseract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
@RequiredArgsConstructor
public class Config {
    private final Environment env;

    @Bean
    Tesseract getTesseract() {
        Tesseract tesseract = new Tesseract();
        String relativePath = "tesseract-ocr/tessdata";
        String absolutePath = "/opt/" + relativePath;
        tesseract.setDatapath(absolutePath);
        return tesseract;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean("objectMapper")
    public ObjectMapper getObjectMapper() {
        return new ObjectMapper();
    }
}
