package com.example.spring_demo.spring_basics.lesson5_autowire_qualifier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class SpringDemoApplication {

    public static void main(String[] args) {
        ApplicationContext appContext = SpringApplication.run(SpringDemoApplication.class);
        RecommenderImplementation recommender = appContext.getBean(RecommenderImplementation.class);
        String[] result = recommender.recommendMovies("test");
        System.out.println(Arrays.toString(result));
    }

}
