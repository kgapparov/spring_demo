package com.example.spring_demo.spring_in_depth.lesson9_scope_mixed;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.example.spring_demo.lesson10_scan", "com.example.spring_demo.lesson9_scope_mixed"})
//@ComponentScan(basePackages = "com.example.spring_demo.lesson9_scope_mixed")
@ComponentScan(includeFilters = @ComponentScan.Filter( type = FilterType.REGEX, pattern = "com.example.spring_demo.lesson10_scan.*"))
public class SpringDemoApplication {

    public static void main(String[] args) {
        ApplicationContext appContext = SpringApplication.run(SpringDemoApplication.class);

        System.out.println("ContentBasedFilter bean found = " + appContext.containsBean("contentBasedFilter"));
        System.out.println("CollaborativeFilter bean found = " + appContext.containsBean("collaborativeFilter"));

       //retrieve prototype singleton bean from context
        ContentBasedFilter cbf = appContext.getBean(ContentBasedFilter.class);
        System.out.println("\nContentBasedFilter bean with singleton scope");

        //Retrieve prototype bean from the singleton bean trice
        Movie movie1;
        movie1 = cbf.getMovie();
        Movie movie2 = cbf.getMovie();
        Movie movie3 = cbf.getMovie();
        System.out.println("\nMovie bean with prototype scope");
        System.out.println(movie1);
        System.out.println(movie2);
        System.out.println(movie3);

        //Print number of instances of each bean
        System.out.println("\nContentBased instances created " + ContentBasedFilter.getInstances());
        System.out.println("Movie instances created " + Movie.getInstances());
    }

}
