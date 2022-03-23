package com.example.spring_demo.spring_in_depth.lesson12_prototype_scoped_beans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringDemoApplication {

    public static void main(String[] args) {
        /**
         * When the application is run, we can see that the constructor and post construct methods of the singleton
         * RecommenderImplementation bean (and its dependency, ContentBasedFilter bean) are called when the bean is created, before the application starts.
         *
         * The prototype bean is not created beforehand and the constructor and post construct methods for the
         * Movie bean are only called when we request the application context for the Movie bean.
         *
         * When the application terminates, the PreDestroy method is called for the singleton RecommenderImplementation
         * bean (and its dependency ContentBasedFilter bean) but not for the prototype scoped Movie bean.
         */
        ApplicationContext applicationContext = SpringApplication.run(SpringDemoApplication.class);
        RecommenderImplementation recommender = applicationContext.getBean(RecommenderImplementation.class);
        System.out.println(recommender);
        Movie movie1 = applicationContext.getBean(Movie.class);
        System.out.println(movie1);
        Movie movie2 = applicationContext.getBean(Movie.class);
        System.out.println(movie2);
    }

}
