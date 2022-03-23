package com.example.spring_demo.spring_basics.lesson1;

public class CollaborativeFilter implements FilterInterface{
    @Override
    public String[] getRecommendations(String move) {
        return new String[]{"Way to the heaven", "You are damp"};
    }
}
