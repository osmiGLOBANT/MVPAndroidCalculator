package com.globant.mvpandroidcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.globant.mvpandroidcalculator.mvp.model.CalculatorModel;
import com.globant.mvpandroidcalculator.mvp.presenter.CalculatorPresenter;
import com.globant.mvpandroidcalculator.mvp.view.CalculatorView;

public class MainActivity extends AppCompatActivity {
    private CalculatorPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new CalculatorPresenter(new CalculatorView(this), new CalculatorModel());
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.register();
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.unregister();
    }
}
