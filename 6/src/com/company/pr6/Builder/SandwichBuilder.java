package com.company.pr6.Builder;

import java.util.ArrayList;
import java.util.List;

public class SandwichBuilder implements Builder<Sandwich> {

    private List<String> products;

    SandwichBuilder(){
        products = new ArrayList<>();
        products.add("Bread");
    }

    @Override
    public Builder<Sandwich> addProduct(String s) {
        products.add(s);
        return this;
    }

    @Override
    public Builder<Sandwich> addLayer() {
        products.add("Bread");
        return this;
    }

    @Override
    public Builder<Sandwich> addSauce(String s) {
        products.add(s);
        return this;
    }

    @Override
    public Sandwich make() {
        products.add("Bread");
        return new Sandwich(products);
    }
}
