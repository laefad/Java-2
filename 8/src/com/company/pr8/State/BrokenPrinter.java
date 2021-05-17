package com.company.pr8.State;

public class BrokenPrinter implements PrinterState {
    @Override
    public void print(String msg) {
        System.out.println("Out of paper!");
    }

    @Override
    public String scan() {
        System.out.println("Scanner is broken");
        return null;
    }
}
