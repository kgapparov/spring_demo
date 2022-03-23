package com.example.spring_demo.spring_in_depth.lesson12_prototype_scoped_beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Movie {
    private static int instances = 0;

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private int id;
    private String name;
    private String genre;
    private String producer;

    public Movie() {
        super();
        instances++;
        logger.info("Movie constructor performed");
    }

    @PostConstruct
    public void postConstruct(){
        logger.info("Movie postConstruct action performed");
    }

    @PreDestroy
    public void preDestory(){
        logger.info("Movie preDestroy action performed");
    }

    public static int getInstances(){
        return instances;
    }
}
