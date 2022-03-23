package com.example.spring_demo.spring_in_depth.lesson9_scope_mixed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("CBF")
public class ContentBasedFilter implements FilterInterface {

    //for keeping track of instances created
    private static int instances = 0;

    public static int getInstances() {
        return ContentBasedFilter.instances;
    }

    @Autowired
    private Movie movie;

    public ContentBasedFilter() {
        super();
        instances++;
        System.out.println("content-based filter constructor called");
    }

    public Movie getMovie() {
        return movie;
    }

    @Override
    public String[] getRecommendations(String movie) {
        return new String[]{"Happy Feet", "Ice Age", "Share Tale"};
    }
}
