package com.company.pr6.Builder;

public interface Builder<T> {
    Builder<T> addProduct(String s);
    Builder<T> addLayer();
    Builder<T> addSauce(String s);
    T make();
}
