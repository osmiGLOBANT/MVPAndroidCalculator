package com.globant.mvpandroidcalculator.mvp.model;

import android.util.Log;

public class CalculatorModel {

    private int res = 0;
    private int number = 0;
    private StringBuilder sb;

    public CalculatorModel(){
        sb = new StringBuilder(res);
    }


    public void reset() {
        res = 0;
    }

    public String resetStringNum() {
        sb = new StringBuilder();
        return "0";
    }

    public int getRes() {
        return res;
    }

    public void add() {
        res = res + number;
    }

    public void setNumber(int number){
        this.number = number;
    }

    public String retainNum(String num){
        if(sb.length() == 0 && num.equals("0")) {

            return resetStringNum();

        }
        
        else{
            sb.append(num);
            return sb.toString();
        }


    }


}
