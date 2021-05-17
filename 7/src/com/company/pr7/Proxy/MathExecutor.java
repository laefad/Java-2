package com.company.pr7.Proxy;

public class MathExecutor implements Executor<Integer> {

    @Override
    public Integer calc(Integer x, Integer y) {
        return x + y;
    }

}
