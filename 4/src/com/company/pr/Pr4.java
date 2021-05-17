package com.company.pr;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Pr4 {
    /*
      Реализовать собственную имплементацию ExecutorService
      с единственным параметром конструктора – количеством потоков.
    */

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService s = new MyExecutorService(3);

        List<Callable<String>> lst = new ArrayList<>();
        lst.add(() -> "Future task 1");
        lst.add(() -> "Future task 2");

        Future<String> f1 = s.submit(() -> "Submit future task");

        List<Future<String>> res = s.invokeAll(lst);
        for (Future<String> f : res) {
            System.out.println(f.get());
        }

        System.out.println(f1.get());
    }
}
