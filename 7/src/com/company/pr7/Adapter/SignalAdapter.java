package com.company.pr7.Adapter;

import com.company.pr7.Adapter.Signals.AnalogSignal;
import com.company.pr7.Adapter.Signals.BinarySignal;

public class SignalAdapter extends AnalogSignal {
    private BinarySignal binary;

    public SignalAdapter(BinarySignal binary){
        super("");
        this.binary = binary;
    }

    @Override
    public String getData() {
        StringBuilder res = new StringBuilder();
        binary.getData().forEach( (bit) -> res.append(bit ? '0' : '1') );
        return res.toString();
    }
}
