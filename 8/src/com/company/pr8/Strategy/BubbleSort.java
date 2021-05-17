package com.company.pr8.Strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BubbleSort<T extends Comparable<T>> implements SortStrategy<T> {

    public BubbleSort(){

    }

    @Override
    public List<T> sort(List<T> lst) {
        List<T> res = new ArrayList<>(lst);
        for (int i = 0; i < res.size(); i++) {
            boolean flag = true;
            for (int j = 0; j < res.size(); j++) {
                if (res.get(i).compareTo(res.get(j)) < 0) {
                    Collections.swap(res, i, j);
                    flag = false;
                }
            }
            if (flag) break;
        }

        return res;
    }
}
