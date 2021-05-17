package com.company.pr8.Strategy;

import java.util.List;

public interface SortStrategy <T extends Comparable<T>>{
    List<T> sort(List<T> lst);
}
