package com.company.pr6.AbstractFabric.Fabrics;

import com.company.pr6.AbstractFabric.Croissants.Croissant;
import com.company.pr6.AbstractFabric.Waffles.Waffle;

public interface CookieFabric {
    Croissant makeCroissant();
    Waffle makeWaffle();
}
