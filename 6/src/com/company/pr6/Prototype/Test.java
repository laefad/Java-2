package com.company.pr6.Prototype;

public class Test {

    public static void main(String[] args) {
        Cat c1 = new Cat("Alex Merser", 1, Cat.CAT_STATUS.HUNGRY);
        Cat c2 = c1.clone();
        c1.setStatus(Cat.CAT_STATUS.FULL);
        System.out.println(c1.getStatus());
        System.out.println(c2.getStatus());
    }
}
