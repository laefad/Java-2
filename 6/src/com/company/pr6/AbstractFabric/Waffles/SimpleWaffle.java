package com.company.pr6.AbstractFabric.Waffles;

public class SimpleWaffle implements Waffle {

    public SimpleWaffle(){}

    @Override
    public void getName() {
        System.out.println("This is simple waffle");
    }
}
