package com.example.spring_demo.spring_in_depth.lesson15_External_property_file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Named;

@Named
@Qualifier("CBF")
public class ContentBasedFilter implements FilterInterface {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String[] getRecommendations(String movie) {
        return new String[]{"Happy Feet", "Ice Age", "Share Tale"};
    }

    public ContentBasedFilter() {
        super();
        logger.info("ContentBasedFilter constructor performed");
    }

    @PostConstruct
    public void postConstruct(){
        logger.info("ContentBasedFilter postConstruct method performed");
    }

    @PreDestroy
    public void preDestroy(){
        logger.info("ContentBasedFilter preDestroy method is performed");
    }
}
