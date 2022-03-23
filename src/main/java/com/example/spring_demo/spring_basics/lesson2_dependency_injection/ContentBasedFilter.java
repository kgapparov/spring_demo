package com.example.spring_demo.spring_basics.lesson2_dependency_injection;

import org.springframework.stereotype.Component;

@Component
public class ContentBasedFilter implements FilterInterface {

    @Override
    public String[] getRecommendations(String movie) {
        return new String[]{"Happy Feet", "Ice Age", "Share Tale"};
    }
}
