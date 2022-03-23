package com.example.spring_demo.spring_in_depth.lesson12_prototype_scoped_beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class RecommenderImplementation {
    /**
     * @param movie the movie name
     * @return list of movies same as component;
     */
    private FilterInterface contentBasedFilter;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public void setContentBasedFilter(FilterInterface contentBasedFilter) {
        logger.info("In RecomenderImplementation setter method..dependency injection");
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
