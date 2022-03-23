package com.example.spring_demo.spring_basics.lesson5_autowire_qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class RecommenderImplementation {
    /**
     * @param movie the movie name
     * @return list of movies same as component;
     */
    @Autowired
    @Qualifier("CF")
    private FilterInterface contentBasedFilter;

    public String[] recommendMovies(String movie) {
        /**
         *Here we have to candidates for autowiring - contentBasedFilter and collaborativeFilter.
         * because name is same as class ContentBasedFilter is chosen as an implementer.
         */
        String[] result = contentBasedFilter.getRecommendations(movie);
        return result;
    }
}
