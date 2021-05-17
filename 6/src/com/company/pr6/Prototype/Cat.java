package com.company.pr6.Prototype;

public class Cat implements Cloneable{

    public enum CAT_STATUS {
        HUNGRY,
        FULL
    }

    private String name;
    private int age;
    private CAT_STATUS status;

    public Cat(String name, int age, CAT_STATUS status) {
        this.name = name;
        this.age = age;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public CAT_STATUS getStatus() {
        return status;
    }

    public void setStatus(CAT_STATUS status) {
        this.status = status;
    }

    @Override
    protected Cat clone() {
        return new Cat(name, age, status);
    }
}
