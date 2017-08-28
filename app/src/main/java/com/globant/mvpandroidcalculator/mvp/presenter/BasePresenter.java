package com.globant.mvpandroidcalculator.mvp.presenter;

import android.app.Activity;

import com.globant.mvpandroidcalculator.mvp.view.BaseView;
import com.globant.mvpandroidcalculator.util.bus.RxBus;

public abstract class BasePresenter {

    protected BaseView view;
    protected Activity activity;

    public BasePresenter(BaseView view){
        this.view = view;
    }

    public void  register(){
        activity = view.getActivity();
        if(activity == null){
            return;
        }

        subscribe();

    }

    abstract void subscribe();

    public void unregister(){
        Activity activity = view.getActivity();

        if(activity == null){
            return;
        }

        RxBus.clear(activity);
    }

}
