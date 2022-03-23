package com.example.spring_demo.spring_in_depth.lesson11_bean_lifecycle_postcunstruct_predestroy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class SpringDemoApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(SpringDemoApplication.class);
        RecommenderImplementation recommender = applicationContext.getBean(RecommenderImplementation.class);
        System.out.println(recommender);
    }

}
