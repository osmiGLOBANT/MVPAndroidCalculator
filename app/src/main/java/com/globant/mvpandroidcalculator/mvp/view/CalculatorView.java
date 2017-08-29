package com.globant.mvpandroidcalculator.mvp.view;

import android.app.Activity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import com.globant.mvpandroidcalculator.R;
import com.globant.mvpandroidcalculator.util.bus.RxBus;
import com.globant.mvpandroidcalculator.util.bus.observers.AddButtonObserver;
import com.globant.mvpandroidcalculator.util.bus.observers.ClearButtonPressObserver;
import com.globant.mvpandroidcalculator.util.bus.observers.DividerButtonObserver;
import com.globant.mvpandroidcalculator.util.bus.observers.EqualButtonObserver;
import com.globant.mvpandroidcalculator.util.bus.observers.MultiplyButtonObserver;
import com.globant.mvpandroidcalculator.util.bus.observers.SubstractButtonObserver;

public class CalculatorView extends BaseView {

    @BindView(R.id.text_result) TextView text_result;

    public CalculatorView(Activity activity) {
        super(activity);
        ButterKnife.bind(this, activity);
    }

    @OnClick(R.id.button_number_one)
    public void numberOnePressed(){
        RxBus.post(new String("1"));
    }

    @OnClick(R.id.button_number_two)
    public void numberTwoPressed(){
        RxBus.post(new String("2"));
    }
    @OnClick(R.id.button_number_three)
    public void numberThreePressed(){
        RxBus.post(new String("3"));
    }
    @OnClick(R.id.button_number_four)
    public void numberfourPressed(){
        RxBus.post(new String("4"));
    }
    @OnClick(R.id.button_number_five)
    public void numberFivePressed(){
        RxBus.post(new String("5"));
    }
    @OnClick(R.id.button_number_six)
    public void numberSixPressed(){
        RxBus.post(new String("6"));
    }
    @OnClick(R.id.button_number_seven)
    public void numberSevenPressed(){
        RxBus.post(new String("7"));
    }
    @OnClick(R.id.button_number_eigth)
    public void numberEigthPressed(){
        RxBus.post(new String("8"));
    }
    @OnClick(R.id.button_number_nine)
    public void numberNinePressed(){
        RxBus.post(new String("9"));
    }
    @OnClick(R.id.button_number_zero)
    public void numberZeroPressed(){
        RxBus.post(new String("0"));
    }

    @OnClick(R.id.button_clear)
    public void clearButtonPressed(){
        RxBus.post(new ClearButtonPressObserver.ClearPressed());
    }

    @OnClick(R.id.button_add)
    public void addButtonPressed(){
        RxBus.post(new AddButtonObserver.AddPressed());
    }

    @OnClick(R.id.button_equal)
    public void equalButtonPressed(){
        RxBus.post(new EqualButtonObserver.EqualPressed());
    }

    @OnClick(R.id.button_substract)
    public void substractButtonPressed(){
        RxBus.post(new SubstractButtonObserver.SubPressed());
    }

    @OnClick(R.id.button_multiply)
    public void multiplyButtonPressed(){
        RxBus.post(new MultiplyButtonObserver.MultiplyPressed());
    }
    @OnClick(R.id.button_divide)
    public void dividerButtonPressed(){
        RxBus.post(new DividerButtonObserver.DivPressed());
    }

    public void setRes(String res){
        text_result.setText(res);
    }

}
