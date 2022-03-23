package com.example.spring_demo.spring_basics.lesson2_dependency_injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RecommenderImplementation {
    /**
     * @param movie the movie name
     * @return list of movies same as component;
     */
    @Autowired
    private FilterInterface filter;

    public RecommenderImplementation(FilterInterface filter) {
        super();
        this.filter = filter;
    }

    public String[] recommendMovies(String movie) {
        /**
         * user conent based filter to find similar movies
         * return the results
         */
        String[] result = filter.getRecommendations(movie);
        return result;
    }

}
