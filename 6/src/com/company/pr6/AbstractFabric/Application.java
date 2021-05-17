package com.company.pr6.AbstractFabric;

import com.company.pr6.AbstractFabric.Croissants.Croissant;
import com.company.pr6.AbstractFabric.Fabrics.CookieFabric;
import com.company.pr6.AbstractFabric.Fabrics.SimpleFabric;
import com.company.pr6.AbstractFabric.Fabrics.TastyCookieFabric;
import com.company.pr6.AbstractFabric.Waffles.Waffle;

public class Application {

    public enum TYPE_OF_FABRIC {
        SIMPLE,
        CHOKO
    }

    private CookieFabric currentFabric;

    public void selectFabric(TYPE_OF_FABRIC type) {
        switch (type) {
            case CHOKO:
                currentFabric = new TastyCookieFabric();
                break;
            case SIMPLE:
                currentFabric = new SimpleFabric();
                break;
        }
    }

    public Application(){
        selectFabric(TYPE_OF_FABRIC.SIMPLE);
    }

    public Croissant getCroissant(){
        return currentFabric.makeCroissant();
    }

    public Waffle getWaffle(){
        return currentFabric.makeWaffle();
    }

}
