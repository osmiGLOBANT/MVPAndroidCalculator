package com.globant.mvpandroidcalculator.util.bus.observers;

public abstract class EqualButtonObserver extends BusObserver<EqualButtonObserver.EqualPressed> {

    public EqualButtonObserver() {
        super(EqualButtonObserver.EqualPressed.class);
    }

    public static class EqualPressed {


    }
}