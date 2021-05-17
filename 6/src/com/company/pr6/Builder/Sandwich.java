package com.company.pr6.Builder;

import java.util.List;

public class Sandwich {

    public List<String> composition;

    public Sandwich(List<String> composition) {
        this.composition = composition;
    }

    public List<String> getComposition() {
        return composition;
    }

    @Override
    public String toString() {
        return "Sandwich{" +
                "composition=" + composition +
                '}';
    }
}
