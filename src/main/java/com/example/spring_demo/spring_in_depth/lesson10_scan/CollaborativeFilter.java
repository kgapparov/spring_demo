package com.example.spring_demo.spring_in_depth.lesson10_scan;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("CF")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CollaborativeFilter implements FilterInterface {
    public CollaborativeFilter() {
        super();
        System.out.println("Collaborative filter cunstructor called");
    }

    @Override
    public String[] getRecommendations(String move) {
        return new String[]{"Way to the heaven", "You are damp"};
    }
}
