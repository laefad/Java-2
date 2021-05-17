package com.company.pr6.AbstractFabric.Fabrics;

import com.company.pr6.AbstractFabric.Croissants.Croissant;
import com.company.pr6.AbstractFabric.Croissants.SimpleCroissant;
import com.company.pr6.AbstractFabric.Waffles.SimpleWaffle;
import com.company.pr6.AbstractFabric.Waffles.Waffle;

public class SimpleFabric implements CookieFabric {
    @Override
    public Croissant makeCroissant() {
        return new SimpleCroissant();
    }

    @Override
    public Waffle makeWaffle() {
        return new SimpleWaffle();
    }
}
