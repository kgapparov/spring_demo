package com.example.spring_demo.spring_in_depth.lesson13_contect_and_dependency_injection_framework;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@ComponentScan
public class SpringDemoApplication {

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringDemoApplication.class)) {
            System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
            RecommenderImplementation recommender = context.getBean(RecommenderImplementation.class);
            System.out.println(Arrays.toString(recommender.recommendMovies("Finding Dory")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
