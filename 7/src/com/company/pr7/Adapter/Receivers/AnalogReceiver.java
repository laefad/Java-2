package com.company.pr7.Adapter.Receivers;

import com.company.pr7.Adapter.Signals.AnalogSignal;

public class AnalogReceiver {
    public AnalogReceiver() {}

    public void receive(AnalogSignal as){
        System.out.println("Signal received " + as.getData());
    }

}
