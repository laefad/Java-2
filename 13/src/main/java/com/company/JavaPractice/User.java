package com.company.JavaPractice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class User {

    private final Logger logger = LoggerFactory.getLogger(User.class);

    @Value("${student.name}")
    private String name;

    @Value("${student.last_name}")
    private String lastName;

    @Value("${student.group}")
    private String group;

    @PostConstruct
    public void init() {
        logger.info(
                "Student: \n" +
                "Name = " + name + "\n" +
                "Last name = " + lastName +"\n" +
                "Group = " + group
        );
    }
}
