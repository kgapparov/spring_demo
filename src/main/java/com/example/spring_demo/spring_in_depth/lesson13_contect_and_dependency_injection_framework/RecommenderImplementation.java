package com.example.spring_demo.spring_in_depth.lesson13_contect_and_dependency_injection_framework;


import org.springframework.beans.factory.annotation.Qualifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
