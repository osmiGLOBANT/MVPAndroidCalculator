package com.globant.mvpandroidcalculator.mvp.presenter;

import com.globant.mvpandroidcalculator.mvp.model.CalculatorModel;

import com.globant.mvpandroidcalculator.mvp.view.CalculatorView;
import com.globant.mvpandroidcalculator.util.bus.RxBus;
import com.globant.mvpandroidcalculator.util.bus.observers.ClearButtonPressObserver;
import com.globant.mvpandroidcalculator.util.bus.observers.NumberButtonPressObserver;

public class CalculatorPresenter extends BasePresenter{

    private CalculatorView view;
    private CalculatorModel model;

    public CalculatorPresenter(CalculatorView view, CalculatorModel model) {
        super(view);
        this.view = view;
        this.model = model;
    }

    @Override
    void subscribe() {
        RxBus.subscribe(activity, new NumberButtonPressObserver() {
            @Override
            public void onEvent(String value) {
                onNumberButtonPressed(value);
            }
        });

        RxBus.subscribe(activity, new ClearButtonPressObserver() {
            @Override
            public void onEvent(ClearPressed value) {
                onClearButtonPressed();
            }
        });
    }

    public void onNumberButtonPressed(String value){

        view.setRes( model.retainNum(value) );
    }

    public void onClearButtonPressed(){
        model.reset();
        view.setRes(model.resetStringNum());
    }

}
