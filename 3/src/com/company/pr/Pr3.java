package com.company.pr;

import java.util.*;

public class Pr3 {

    /*
      Создать свои потокобезопасные имплементации интерфейсов в соответствии с вариантом индивидуального задания.
      7) List с использованием ключевого слова synchronized,
         Set с использованием Semaphore.
     */

    public static void test(Runnable r1, Runnable r2)
    {
        Thread thread1 = new Thread(r1);
        Thread thread2 = new Thread(r2);

        thread1.start();
        thread2.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void testCollection(Collection<Integer> collection, String header)
    {
        test(() -> {
            for (int i = 1; i < 50_000; i++) {
                collection.add(i);
                if (i > 1)
                    collection.remove(i-1);
            }
        },() -> {
            for (int i = 50; i < 100_000; i++){
                collection.add(i);
                if (i > 50)
                    collection.remove(i-1);
            }
        });

        System.out.println(header);
        try {
            System.out.println(
                    collection.stream()
                            .map(Object::toString)
                            .reduce("", (x, str) -> str + ',' + x)
            );
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        System.out.println("---");
    }

    public static void testArrayList(){
        List<Integer> arrList = new ArrayList<>();
        testCollection(arrList, "Not my List:");
    }

    public static void testMyList(){
        List<Integer> myList = new MyList<>();
        testCollection(myList, "My List:");
    }

    public static void testMySet()
    {
        Set<Integer> set = new MySet<>();
        testCollection(set, "My set:");
    }

    public static void testHashSet()
    {
        Set<Integer> set = new HashSet<>();
        testCollection(set, "Not my set:");
    }

    public static void main(String[] args) {
        testMyList();
        testArrayList();
        testMySet();
        testHashSet();
    }
}
