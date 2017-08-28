package com.globant.mvpandroidcalculator.util.bus.observers;

public abstract class NumberButtonPressObserver extends BusObserver<String>{

    public NumberButtonPressObserver() {
        super(String.class);
    }


}
