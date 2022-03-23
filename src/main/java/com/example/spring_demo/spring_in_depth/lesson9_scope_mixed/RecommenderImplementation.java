package com.example.spring_demo.spring_in_depth.lesson9_scope_mixed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class RecommenderImplementation {
    /**
     * @param movie the movie name
     * @return list of movies same as component;
     */

    private FilterInterface contentBasedFilter;

    @Autowired
    @Qualifier("CBF")
    public void setContentBasedFilter(FilterInterface contentBasedFilter) {
        this.contentBasedFilter = contentBasedFilter;
        System.out.println("Setter injection appliesd");
    }

    public String[] recommendMovies(String movie) {
        /**
         *Here we have to candidates for autowiring - contentBasedFilter and collaborativeFilter.
         * because name is same as class ContentBasedFilter is chosen as an implementer.
         */
        String[] result = contentBasedFilter.getRecommendations(movie);
        return result;
    }
}
