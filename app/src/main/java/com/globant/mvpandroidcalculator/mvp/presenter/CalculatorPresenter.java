package com.globant.mvpandroidcalculator.mvp.presenter;

import com.globant.mvpandroidcalculator.mvp.model.CalculatorModel;

import com.globant.mvpandroidcalculator.mvp.view.CalculatorView;
import com.globant.mvpandroidcalculator.util.bus.RxBus;
import com.globant.mvpandroidcalculator.util.bus.observers.AddButtonObserver;
import com.globant.mvpandroidcalculator.util.bus.observers.ClearButtonPressObserver;
import com.globant.mvpandroidcalculator.util.bus.observers.DividerButtonObserver;
import com.globant.mvpandroidcalculator.util.bus.observers.EqualButtonObserver;
import com.globant.mvpandroidcalculator.util.bus.observers.MultiplyButtonObserver;
import com.globant.mvpandroidcalculator.util.bus.observers.NumberButtonPressObserver;
import com.globant.mvpandroidcalculator.util.bus.observers.SubstractButtonObserver;

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

        RxBus.subscribe(activity, new AddButtonObserver() {
            @Override
            public void onEvent(AddPressed value) {
                onAddButtonPressed();
            }
        });

        RxBus.subscribe(activity, new EqualButtonObserver() {
            @Override
            public void onEvent(EqualPressed value) {
                onEqualButtonPressed();
            }
        });

        RxBus.subscribe(activity, new SubstractButtonObserver() {
            @Override
            public void onEvent(SubPressed value) {
                onSubstractracButtonPressed();
            }
        });

        RxBus.subscribe(activity, new MultiplyButtonObserver() {
            @Override
            public void onEvent(MultiplyPressed value) {
                onMultiplyButtonPressed();
            }
        });

        RxBus.subscribe(activity, new DividerButtonObserver() {
            @Override
            public void onEvent(DivPressed value) {
                onDividerButtonPressed();
            }
        });


    }

    public void onNumberButtonPressed(String value){

        view.setRes( model.retainNum(value) );
    }



    public void onEqualButtonPressed(){
        model.performOperation();
        view.setRes(model.getRes());
    }
    public void onClearButtonPressed(){
        model.reset();
        view.setRes(model.resetStringNum());
    }

    public void onAddButtonPressed(){
        model.setOperation(CalculatorModel.ADD);
        view.setRes(model.getRes());
    }

    public void onSubstractracButtonPressed(){
        model.setOperation(CalculatorModel.SUB);
        view.setRes(model.getRes());
    }

    public void onMultiplyButtonPressed(){
        model.setOperation(CalculatorModel.MUL);
        view.setRes(model.getRes());
    }

    public void onDividerButtonPressed(){
        model.setOperation(CalculatorModel.DIV);
        view.setRes(model.getRes());
    }

}
