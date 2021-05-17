package com.company.pr8.State;

public class Test {
    public static void main(String[] args) {
        Printer p = new Printer();

        p.print("Message !!");
        System.out.println(p.scan());

        p.print("Message 1");
        p.print("Message 2");
        p.print("Message 3");
        p.print("Message 4");
        p.print("Message 5");

        System.out.println(p.scan());
        System.out.println(p.scan());
        System.out.println(p.scan());
        System.out.println(p.scan());
        System.out.println(p.scan());
        System.out.println(p.scan());

        p.addPaper(10);
        p.print("Message 5");
        System.out.println(p.scan());

        p.repair();
        p.print("Message 5");
        System.out.println(p.scan());


    }
}
