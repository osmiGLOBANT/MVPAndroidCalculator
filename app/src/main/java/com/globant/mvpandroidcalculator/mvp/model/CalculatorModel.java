package com.globant.mvpandroidcalculator.mvp.model;

import android.app.Activity;
import android.util.Log;

import com.globant.mvpandroidcalculator.util.math.MathUtil;

public class CalculatorModel {

    private double res = 0;
    private double number = 0;
    private StringBuilder sb;
    private int action = 0;
    private int lastKey = -1;
    private int countNumbers = 0;
    private final int OPERATOR = 1;
    private final int NUMBER = 2;
    private String result;



    public CalculatorModel(){
        sb = new StringBuilder();
    }


    public void reset() {
        res = 0;
        action = 0;
        resetStringNum();
        number = 0;
        lastKey = -1;
        countNumbers = 0;
    }

    public String resetStringNum() {
        sb = new StringBuilder();
        return "0";
    }

    public String getRes() {

        if(!MathUtil.isDecimal(res)){
            return String.valueOf((int)res);
        }
        else{
            return result;
        }
    }

    public void add() {
        if(lastKey != OPERATOR){
            if(countNumbers>1){
             setNumber();
            }
            else {
                setRes();
            }
            resetStringNum();
        }


        action = 1;
        lastKey = OPERATOR;
    }

    public void substract() {
        if(countNumbers>1){
            setNumber();
        }
        else {
            setRes();
        }
        resetStringNum();


        action = 2;
        lastKey = OPERATOR;
    }

    public void multiply() {
        if(countNumbers>1){
            setNumber();
        }
        else {
            setRes();
        }
        resetStringNum();


        action = 3;
        lastKey = OPERATOR;
    }

    public void divide() {
        if(countNumbers>1){
            setNumber();
        }
        else {
            setRes();
        }
        resetStringNum();

        action = 4;
        lastKey = OPERATOR;
    }

    public void performOperation(){

        if(lastKey != OPERATOR){
            setNumber();
        }
        switch(action) {
            case 1 :
                res = res + number;
                resetStringNum();
                result = String.valueOf(res);
                break;

            case 2 :
                res = res - number;
                resetStringNum();
                result = String.valueOf(res);
                break;

            case 3 :
                res = res * number;
                resetStringNum();
                result = String.valueOf(res);
                break;
            case 4 :
                if(res == 0){
                    result = "Error";
                }
                else {
                    res = res / number;
                }
                resetStringNum();
                result = String.valueOf(res);
                break;

            default :
                break;

        }

    }
    public void setNumber(){
        countNumbers++;
        if(sb.length()>0) {
            number = Double.parseDouble(sb.toString());
        }
        else{
            number = 0;
        }
    }

    public void setRes(){
        countNumbers++;
        if(sb.length()>0) {
            res = Double.parseDouble(sb.toString());
        }
        else{
            res = 0;
        }
    }

    public String retainNum(String num){
        lastKey = NUMBER;


        if(lastKey == OPERATOR){
            res = number;
        }




        if(sb.length() == 0 && num.equals("0")) {

            return resetStringNum();

        }
        
        else{
            sb.append(num);
            return sb.toString();
        }


    }



}
