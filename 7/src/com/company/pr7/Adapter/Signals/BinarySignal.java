package com.company.pr7.Adapter.Signals;

import java.util.List;

public class BinarySignal {

    private List<Boolean> data;

    public BinarySignal(List<Boolean> data){
        this.data = data;
    }

    public List<Boolean> getData() {
        return data;
    }
}
