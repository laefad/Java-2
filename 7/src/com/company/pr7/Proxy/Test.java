package com.company.pr7.Proxy;

public class Test {
    public static void main(String[] args) {
        Executor<Integer> ex = new MathExecutor();

        System.out.println(ex.calc(12, 23));
        System.out.println(ex.calc(Integer.MAX_VALUE, 12));

        System.out.println("---");

        ex = new ProxyExecutor();

        System.out.println(ex.calc(12, 23));
        System.out.println(ex.calc(Integer.MAX_VALUE, 12));
    }
}
