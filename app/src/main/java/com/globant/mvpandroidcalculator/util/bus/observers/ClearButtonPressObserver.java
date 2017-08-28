package com.globant.mvpandroidcalculator.util.bus.observers;

import com.globant.mvpandroidcalculator.mvp.presenter.CalculatorPresenter;

public abstract class ClearButtonPressObserver extends BusObserver<ClearButtonPressObserver.ClearPressed>{

    public ClearButtonPressObserver(){
        super(ClearPressed.class);
    }

    public static class ClearPressed{

    }
}
