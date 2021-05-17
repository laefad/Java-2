package com.company.pr8.State;

public class Printer {

    public static final int MAX_DURABILITY = 5;

    private PrinterState state;
    private int amountOfPaper;
    private int durability = MAX_DURABILITY;

    public Printer() {
        state = new NormalState();
        amountOfPaper = 5;
    }

    public void repair() {
        durability = MAX_DURABILITY;

        if (state.getClass() == BrokenPrinter.class){
            state = new OutOfPaperState();
        }
        else if (state.getClass() == BrokenScanner.class){
            state = new NormalState();
        }
    }

    public void addPaper(int amount) {
        amountOfPaper += amount;

        if (state.getClass() == BrokenPrinter.class){
            state = new BrokenScanner();
        }
        else if (state.getClass() == OutOfPaperState.class){
            state = new NormalState();
        }
    }

    public String scan() {
        String res = state.scan();
        durability--;

        if (durability <= 0) {
            if (state.getClass() == NormalState.class){
                state = new BrokenScanner();
            }
            else if (state.getClass() == OutOfPaperState.class){
                state = new BrokenPrinter();
            }
        }

        return res;
    }

    public void print(String msg) {
        state.print(msg);
        amountOfPaper--;
        if (amountOfPaper <= 0) {
            if (state.getClass() == NormalState.class){
                state = new OutOfPaperState();
            }
            else if (state.getClass() == BrokenScanner.class){
                state = new BrokenPrinter();
            }
        }
    }

}

