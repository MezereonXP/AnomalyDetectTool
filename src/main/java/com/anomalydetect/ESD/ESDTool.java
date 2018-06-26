package com.anomalydetect.ESD;

import com.anomalydetect.Result.Result;
import com.anomalydetect.Tool.DetectTool;
import com.anomalydetect.Tool.MathTool;

import java.util.ArrayList;

/**
 * @program: AnomalyDetectTool
 * @description: Extreme Studentized Deviate
 * @author: mezereonxp Email: mezereonxp@gmail.com
 * @create: 2018-04-28 11:41
 **/
public class ESDTool implements DetectTool {

    private double average;// 平均值
    private double stdDeviation;// 方差
    private int K;// 第k个值
    private double t;// t统计量
    private double[] g;// Grubbs统计量
    private ArrayList<Result> results;

    ESDTool(int k) {
        this.K = k;
        this.g = new double[k];
    }

    public void timeSeriesAnalyse(double[] data) {

        initG(data);
        this.average = MathTool.getAverageFromArray(data);
        this.stdDeviation = MathTool.getStdDeviation(data);

        for (K = 1; K <= data.length; K++) {
            ArrayList<Result> tempResults = new ArrayList<Result>();
            double kValue = this.getKExtremeValue(data, K);
            int n = data.length;
            int count = 0;
            for (int i = 0; i < data.length; i++) {
                t = Math.abs(data[i] - average) / (stdDeviation / Math.sqrt(n - K));
                double lambda = (n - K) * t / (Math.sqrt((n - K - 1 + t * t) * (n - K + 1)));
                if (lambda < kValue) {
                    tempResults.add(new Result(i, data[i]));
                    count++;
                }
            }
            if (count == K) {
                results = tempResults;
            }
        }

    }

    private void initG(double[] data) {
        double[] temp = data.clone();
        double tempAvg = MathTool.getAverageFromArray(temp);
        double tempS = MathTool.getStdDeviation(temp);
        for (int i = 0; i < K; i++) {

        }

    }

    public double getKExtremeValue(double[] data, int k) {
        double[] temp = data.clone();
        for (int i = 0; i < data.length; i++) {
            temp[i] = Math.abs(temp[i] - average) / stdDeviation;
        }

        for (int i = 0; i < k + 1; i++) {
            for (int j = i + 1; j < data.length; j++) {
                if (temp[i] < temp[j]) {
                    double c = temp[i];
                    temp[i] = temp[j];
                    temp[j] = c;
                }
            }
        }
        return temp[k - 1];
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public double getStdDeviation() {
        return stdDeviation;
    }

    public void setStdDeviation(double stdDeviation) {
        this.stdDeviation = stdDeviation;
    }

    public int getK() {
        return K;
    }

    public void setK(int k) {
        K = k;
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

    public double[] getG() {
        return g;
    }

    public void setG(double[] g) {
        this.g = g;
    }
}
