package com.company.pr8.State;

public class NormalState implements PrinterState {

    public NormalState(){}

    @Override
    public void print(String msg) {
        System.out.println(String.format("Printed a msg: %s", msg));
    }

    @Override
    public String scan() {
        return "scan : Wow this thing can scan something!!";
    }
}
