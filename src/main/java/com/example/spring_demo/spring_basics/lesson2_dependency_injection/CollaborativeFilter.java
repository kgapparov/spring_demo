package com.example.spring_demo.spring_basics.lesson2_dependency_injection;

public class CollaborativeFilter implements FilterInterface {
    @Override
    public String[] getRecommendations(String move) {
        return new String[]{"Way to the heaven", "You are damp"};
    }
}
