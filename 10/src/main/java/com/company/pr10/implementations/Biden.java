package com.company.pr10.implementations;

import com.company.pr10.Politician;
import org.springframework.stereotype.Component;

@Component
public class Biden implements Politician {
    @Override
    public void doPolitic() {
        System.out.println("We destroy America!");
    }
}
