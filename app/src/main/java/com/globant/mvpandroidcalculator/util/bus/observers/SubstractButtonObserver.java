package com.globant.mvpandroidcalculator.util.bus.observers;

public abstract class SubstractButtonObserver extends BusObserver<SubstractButtonObserver.SubPressed> {

    public SubstractButtonObserver() {
        super(SubstractButtonObserver.SubPressed.class);
    }

    public static class SubPressed {


    }
}