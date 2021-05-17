package com.company.pr6.FabricMethod;

public class HardcoverBook implements Book{

    private String title;

    public HardcoverBook(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return "This is a " + title;
    }
}
