package com.anomalydetect.ESD;

import com.anomalydetect.Result.Result;
import com.anomalydetect.Tool.DetectTool;

import java.util.ArrayList;

/**
 * @program: AnomalyDetectTool
 * @description: Seasonal Extreme Studentized Deviate
 * @author: mezereonxp Email: mezereonxp@gmail.com
 * @create: 2018-05-07 18:16
 **/
public class SESDTool implements DetectTool {

    private double t;// t统计量
    private ArrayList<Result> results;
    private ESDTool esdTool;

    /**
     * constructor
     */
    SESDTool() {
        esdTool = new ESDTool(1);
    }

    public void timeSeriesAnalyse(double[] data) {
        esdTool.timeSeriesAnalyse(data);
        results = esdTool.getResults();
    }

    public double getT() {
        return t;
    }

    public void setT(double t) {
        this.t = t;
    }

    public ArrayList<Result> getResults() {
        return results;
    }

    public void setResults(ArrayList<Result> results) {
        this.results = results;
    }

    public ESDTool getEsdTool() {
        return esdTool;
    }

    public void setEsdTool(ESDTool esdTool) {
        this.esdTool = esdTool;
    }
}
