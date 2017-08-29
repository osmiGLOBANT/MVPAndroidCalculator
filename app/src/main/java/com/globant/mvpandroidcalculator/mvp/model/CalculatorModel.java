package com.globant.mvpandroidcalculator.mvp.model;

import android.app.Activity;
import android.util.Log;

import com.globant.mvpandroidcalculator.util.math.MathUtil;

public class CalculatorModel {

    public static final int ADD = 1;
    public static final int SUB = 2;
    public static final int MUL = 3;
    public static final int DIV = 4;
    public static final String ZERO = "0";
    public static final String DOT = ".";
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

    public void setOperation(int op){
        if(lastKey != OPERATOR){
            if(countNumbers>0){
                performOperation();
                setNumber();
            }
            else {
                setRes();
            }
            resetStringNum();
        }
        action = op;
        lastKey = OPERATOR;
    }


    public void performOperation(){

        if(lastKey != OPERATOR){
            setNumber();
        }
        switch(action) {
            case ADD :
                res = res + number;
                resetStringNum();
                result = String.valueOf(res);
                break;

            case SUB :
                res = res - number;
                resetStringNum();
                result = String.valueOf(res);
                break;

            case MUL :
                res = res * number;
                resetStringNum();
                result = String.valueOf(res);
                break;
            case DIV :
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

        if(sb.length() == 0 && num.equals(ZERO)) {
            return resetStringNum();
        }
        else{

            if(num.equals(DOT) ){
                if( !sb.toString().contains(DOT)){
                    if(sb.length() == 0){
                     sb.append(ZERO).append(DOT);
                    }
                    else {
                        sb.append(DOT);
                    }
                }
                return sb.toString();
            }
            else{
                sb.append(num);
                return sb.toString();
            }
        }
    }
}
