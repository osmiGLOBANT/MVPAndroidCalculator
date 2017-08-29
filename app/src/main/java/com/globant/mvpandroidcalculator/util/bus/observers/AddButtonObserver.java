package com.globant.mvpandroidcalculator.util.bus.observers;

public abstract class AddButtonObserver extends BusObserver<AddButtonObserver.AddPressed> {

    public AddButtonObserver() {
        super(AddPressed.class);
    }

    public static class AddPressed {


    }
}