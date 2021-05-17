package com.company.pr10;

import com.company.pr10.implementations.*;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

    public static void test(ApplicationContext context) {
        Politician p1 = context.getBean(Trump.class);
        Politician p2 = context.getBean(Biden.class);
        Politician p3 = context.getBean(Merkel.class);
        p1.doPolitic();
        p2.doPolitic();
        p3.doPolitic();
    }

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        test(context);
        context = new AnnotationConfigApplicationContext(Config.class);
        test(context);
    }
}
