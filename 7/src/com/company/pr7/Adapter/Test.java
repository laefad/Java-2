package com.company.pr7.Adapter;

import com.company.pr7.Adapter.Receivers.AnalogReceiver;
import com.company.pr7.Adapter.Receivers.BinaryReceiver;
import com.company.pr7.Adapter.Signals.AnalogSignal;
import com.company.pr7.Adapter.Signals.BinarySignal;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        AnalogReceiver ar = new AnalogReceiver();
        BinaryReceiver br = new BinaryReceiver();

        BinarySignal bs = new BinarySignal(new ArrayList<>(){{
            add(true);
            add(false);
            add(true);
        }});

        AnalogSignal as = new AnalogSignal("signal0");

        ar.receive(as);
        br.receive(bs);

        ar.receive(new SignalAdapter(bs));
    }
}
