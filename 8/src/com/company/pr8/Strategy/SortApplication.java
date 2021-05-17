package com.company.pr8.Strategy;

import java.util.List;

public class SortApplication<T extends Comparable<T>> {

    public enum STRATEGIES {
        BUBBLE,
        FAST
    }

    private SortStrategy strategy;

    public SortApplication(){
        selectStrategy(STRATEGIES.BUBBLE);
    }

    public void selectStrategy(STRATEGIES strategy){
        switch (strategy) {
            case FAST:
                this.strategy = new FastSort<T>();
                break;
            case BUBBLE:
                this.strategy = new BubbleSort<T>();
        }
    }

    public List<T> sort(List<T> lst){
        long start = System.nanoTime();
        List<T> res = strategy.sort(lst);
        long end = System.nanoTime();
        System.out.println(String.format("Time = %d mks, Strategy = %s", (end - start) / 1_000, strategy));
        return res;
    }
}
