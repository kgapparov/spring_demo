package com.example.spring_demo.spring_basics.lesson6_injections;

import com.example.spring_demo.spring_basics.lesson6_injections.constructor.RecommenderImplementation;
import com.example.spring_demo.spring_basics.lesson6_injections.fields.RecommenderImplementation3;
import com.example.spring_demo.spring_basics.lesson6_injections.setters.RecommenderImplementation2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class SpringDemoApplication {

    public static void main(String[] args) {
        ApplicationContext appContext = SpringApplication.run(SpringDemoApplication.class);

        System.out.println("Fist autowire with cunstructor injection");
        RecommenderImplementation recommender = appContext.getBean(RecommenderImplementation.class);
        String[] result = recommender.recommendMovies("test");
        System.out.println(Arrays.toString(result));

        System.out.println("Second autowire with setter injection ");
        RecommenderImplementation2 recommender2 = appContext.getBean(RecommenderImplementation2.class);
        System.out.println(Arrays.toString(recommender2.recommendMovies("test")));


        System.out.println("Second autowire with field injection ");
        RecommenderImplementation3 recommender3 = appContext.getBean(RecommenderImplementation3.class);
        System.out.println(Arrays.toString(recommender3.recommendMovies("test")));
    }

}
