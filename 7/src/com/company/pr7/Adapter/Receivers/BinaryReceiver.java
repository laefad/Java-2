package com.company.pr7.Adapter.Receivers;

import com.company.pr7.Adapter.Signals.BinarySignal;

public class BinaryReceiver {
    public BinaryReceiver() {}

    public void receive(BinarySignal bs){
        System.out.println("Signal received " + bs.getData());
    }
}
