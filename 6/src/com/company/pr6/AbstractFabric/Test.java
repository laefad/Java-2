package com.company.pr6.AbstractFabric;

import com.company.pr6.AbstractFabric.Croissants.Croissant;
import com.company.pr6.AbstractFabric.Waffles.Waffle;

public class Test {
    public static void main(String[] args) {
        Application app = new Application();

        app.selectFabric(Application.TYPE_OF_FABRIC.SIMPLE);
        Croissant c1 = app.getCroissant();
        Waffle w1 = app.getWaffle();

        app.selectFabric(Application.TYPE_OF_FABRIC.CHOKO);
        Croissant c2 = app.getCroissant();
        Waffle w2 = app.getWaffle();

        c1.getName();
        w1.getName();
        System.out.println("---");
        c2.getName();
        w2.getName();
    }
}
