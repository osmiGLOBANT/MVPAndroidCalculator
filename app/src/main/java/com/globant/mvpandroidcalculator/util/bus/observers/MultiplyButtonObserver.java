package com.globant.mvpandroidcalculator.util.bus.observers;

public abstract class MultiplyButtonObserver extends BusObserver<MultiplyButtonObserver.MultiplyPressed> {


    public MultiplyButtonObserver() {
        super(MultiplyButtonObserver.MultiplyPressed.class);
    }

    public static class MultiplyPressed{

    }
}
