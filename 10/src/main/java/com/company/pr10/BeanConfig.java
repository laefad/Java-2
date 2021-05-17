package com.company.pr10;

import com.company.pr10.implementations.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public Trump trump() {
        return new Trump();
    }

    @Bean
    public Biden biden() {
        return new Biden();
    }

    @Bean
    public Merkel merkel() {
        return new Merkel();
    }
}
