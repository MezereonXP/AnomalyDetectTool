package com.anomalydetect.Result;

/**
 * @program: AnomalyDetectTool
 * @description: A class to store result
 * @author: mezereonxp Email: mezereonxp@gmail.com
 * @create: 2018-05-08 09:56
 **/
public class Result {
    private int index;
    private double value;
    private double[] multiValue;
    private Boolean isMuti;

    public Result(int index, double[] multiValue) {
        this.index = index;
        this.multiValue = multiValue;
        this.isMuti = true;
    }

    public Result(int index, double value) {
        this.index = index;
        this.value = value;
        this.isMuti = false;
    }

    @Override
    public String toString() {
        String result = "Index is " + index + ",  value is ";
        if (isMuti) {
            for (double d : multiValue) {
                result += "[ " + d + " ],";
            }
            return result;
        } else {
            return "Index is " + index + ",  value is " + value;
        }
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Boolean getMuti() {
        return isMuti;
    }

    public void setMuti(Boolean muti) {
        isMuti = muti;
    }
}
