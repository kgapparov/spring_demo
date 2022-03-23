package com.example.spring_demo.spring_basics.lesson1;

import org.springframework.stereotype.Component;

@Component
public class ContnetBasedFilter implements FilterInterface {
    @Override
    public String[] getRecommendations(String movie) {
        return new String[]{"Happy Feet", "Ice Age", "Share Tale"};
    }
}
