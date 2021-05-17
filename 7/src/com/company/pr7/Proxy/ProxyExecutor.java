package com.company.pr7.Proxy;

public class ProxyExecutor implements Executor<Integer> {

    Executor<Integer> real = new MathExecutor();

    @Override
    public Integer calc(Integer x, Integer y) {
        if (x == null && y == null)
            return null;
        if (x == null)
            return y;
        if (y == null)
            return x;
        int abs_sum = Math.abs(x) + Math.abs(y);
        if (abs_sum < x || abs_sum < y)
            System.out.println("Result may be overflowed");
        return real.calc(x, y);
    }

}
