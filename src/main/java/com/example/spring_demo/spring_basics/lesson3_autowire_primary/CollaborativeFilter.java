package com.example.spring_demo.spring_basics.lesson3_autowire_primary;

import org.springframework.stereotype.Component;

@Component
public class CollaborativeFilter implements FilterInterface {
    @Override
    public String[] getRecommendations(String move) {
        return new String[]{"Way to the heaven", "You are damp"};
    }
}
