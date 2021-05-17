package com.company.pr8.Strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FastSort <T extends Comparable<T>> implements SortStrategy<T> {

    public FastSort() {

    }
    @Override
    public List<T> sort(List<T> lst) {
        List<T> res = new ArrayList<>(lst);
        Collections.sort(res);
        return res;
    }
}
