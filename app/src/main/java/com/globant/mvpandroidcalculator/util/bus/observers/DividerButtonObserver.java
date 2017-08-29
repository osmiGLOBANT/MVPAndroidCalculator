package com.globant.mvpandroidcalculator.util.bus.observers;

public abstract class DividerButtonObserver extends BusObserver<DividerButtonObserver.DivPressed> {

    public DividerButtonObserver() {
        super(DivPressed.class);
    }

    public static class DivPressed {


    }
}