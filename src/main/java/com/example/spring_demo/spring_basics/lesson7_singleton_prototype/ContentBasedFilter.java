package com.example.spring_demo.spring_basics.lesson7_singleton_prototype;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("CBF")
public class ContentBasedFilter implements FilterInterface {

    public ContentBasedFilter() {
        super();
        System.out.println("content-based filter constructor called");
    }

    @Override
    public String[] getRecommendations(String movie) {
        return new String[]{"Happy Feet", "Ice Age", "Share Tale"};
    }
}
