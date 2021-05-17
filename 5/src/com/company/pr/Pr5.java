package com.company.pr;

public class Pr5 {

    /*
    Реализовать паттерн Singleton как минимум 3-мя способами.
     */

    public static void main(String[] args) {
        Singleton1 s1 = Singleton1.instance;
        Singleton2 s2 = Singleton2.INSTANCE;
        Singleton3 s3 = Singleton3.getInstance();

        Singleton4 s4 = Singleton4.getInstance();
        //Singleton4 s4 = Singleton4.SingletonHolder.HOLDER_INSTANCE;
    }
}
