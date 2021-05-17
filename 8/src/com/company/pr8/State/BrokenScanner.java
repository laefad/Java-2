package com.company.pr8.State;

public class BrokenScanner implements PrinterState {
    @Override
    public void print(String msg) {
        System.out.println(String.format("Printed a msg: %s", msg));
    }

    @Override
    public String scan() {
        System.out.println("Scanner is broken");
        return null;
    }
}
