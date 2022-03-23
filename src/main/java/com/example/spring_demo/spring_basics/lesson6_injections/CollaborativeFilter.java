package com.example.spring_demo.spring_basics.lesson6_injections;

import org.springframework.stereotype.Component;

@Component("CF")
public class CollaborativeFilter implements FilterInterface {
    @Override
    public String[] getRecommendations(String move) {
        return new String[]{"Way to the heaven", "You are damp"};
    }
}
