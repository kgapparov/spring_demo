package com.example.spring_demo.spring_basics.lesson4_autowire_by_name;

import org.springframework.stereotype.Component;

@Component
public class ContentBasedFilter implements FilterInterface {

    @Override
    public String[] getRecommendations(String movie) {
        return new String[]{"Happy Feet", "Ice Age", "Share Tale"};
    }
}
