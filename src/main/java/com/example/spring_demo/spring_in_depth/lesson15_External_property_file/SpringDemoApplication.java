package com.example.spring_demo.spring_in_depth.lesson15_External_property_file;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Arrays;

@Configuration
@ComponentScan
@PropertySource("classpath:app.properties")
public class SpringDemoApplication {

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringDemoApplication.class)) {
            System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
            RecommenderImplementation recommender = context.getBean(RecommenderImplementation.class);
            System.out.println(recommender.getFavoriteMove());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
