package com.company.pr8.State;

public class OutOfPaperState implements PrinterState {
    @Override
    public void print(String msg) {
        System.out.println("Out of paper!");
    }

    @Override
    public String scan() {
        return "scan : But we can scan!";
    }
}
