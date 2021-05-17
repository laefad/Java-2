package com.company.pr8.Strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {

    public static List<Integer> getList(){
        List<Integer> randomlst = new ArrayList<>();
        for (int i = 0; i < 51; i++)
            randomlst.add(i);
        Collections.shuffle(randomlst);
        return randomlst;
    }

    public static void main(String[] args) {
        SortApplication<Integer> app = new SortApplication<>();
        List<Integer> lst = getList();
        System.out.println(app.sort(lst));

        System.out.println("----");

        app.selectStrategy(SortApplication.STRATEGIES.FAST);
        lst = getList();
        System.out.println(app.sort(lst));
    }
}
