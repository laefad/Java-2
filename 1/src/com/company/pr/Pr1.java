package com.company.pr;

public class Pr1 {

    /*
    Имплементировать интерфейс Comparator, сравнивающий два числа по модулю.
     */

    public static void main(String[] args) {
        MyComparator comparator = new MyComparator();

        System.out.println(comparator.compare(1d,3.2));
        System.out.println(comparator.compare(-233d,3.2));
    }
}
