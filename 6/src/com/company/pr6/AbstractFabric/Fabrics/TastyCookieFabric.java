package com.company.pr6.AbstractFabric.Fabrics;

import com.company.pr6.AbstractFabric.Croissants.Croissant;
import com.company.pr6.AbstractFabric.Croissants.CroissantWithChoco;
import com.company.pr6.AbstractFabric.Waffles.Waffle;
import com.company.pr6.AbstractFabric.Waffles.WaffleWithChoco;

public class TastyCookieFabric implements CookieFabric {
    @Override
    public Croissant makeCroissant() {
        return new CroissantWithChoco();
    }

    @Override
    public Waffle makeWaffle() {
        return new WaffleWithChoco();
    }
}
