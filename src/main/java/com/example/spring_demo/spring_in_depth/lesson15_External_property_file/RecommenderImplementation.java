package com.example.spring_demo.spring_in_depth.lesson15_External_property_file;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class RecommenderImplementation {
    /**
     * @param movie the movie name
     * @return list of movies same as component;
     */
    private FilterInterface contentBasedFilter;

    @Value("${recommender.implementation.favoriteMove: Finding Dory}")
    private String favoriteMove;

    public String getFavoriteMove() {
        return favoriteMove;
    }

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Inject
    @Qualifier("CBF")
    public void setContentBasedFilter(FilterInterface contentBasedFilter) {
        logger.info("RecommenderImplementation construcor method performed");
        this.contentBasedFilter = contentBasedFilter;
    }

    @PostConstruct
    public void postConstruct(){
        logger.info("In RecommenderImplementation postConstruct method performed");
    }

    @PreDestroy
    public void preDestroy(){
        logger.info("RecommenderImplementation predestory Method performed");
    }

    public RecommenderImplementation() {
        super();
        logger.info("RecommenderImplementation constructor performed");
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
