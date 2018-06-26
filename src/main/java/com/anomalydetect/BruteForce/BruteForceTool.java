package com.anomalydetect.BruteForce;

import com.anomalydetect.Result.Result;
import com.anomalydetect.Tool.DetectTool;
import com.anomalydetect.Tool.MathTool;
import com.anomalydetect.Tool.MultiDetectTool;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: AnomalyDetectTool
 * @description: Using Brute Force Algorithm to find anomaly subsequence
 * @author: mezereonxp Email: mezereonxp@gmail.com
 * @create: 2018-05-10 15:03
 **/
public class BruteForceTool implements DetectTool, MultiDetectTool {

    private ArrayList<Result> results;

    private int length;

    public BruteForceTool(int length) {
        this.length = length;
    }

    public void timeSeriesAnalyse(double[] data) {
        results = new ArrayList<Result>();
        double bestDist = 0;
        int bestLoc = -1;

        for (int p = 0; p < data.length - length + 1; p++) {
            double tempDist = Double.MAX_VALUE;
            for (int q = 0; q < data.length - length + 1; q++) {
                if (Math.abs(p - q) >= length && MathTool.dist(data, p, q, length) < tempDist) {
                    tempDist = MathTool.dist(data, p, q, length);
                }
            }
            if (tempDist > bestDist) {
                bestDist = tempDist;
                bestLoc = p;
            }
        }
        results.add(new Result(bestLoc, data[bestLoc]));
    }

    @Override
    public void multiTimeSeriesAnalyse(double[][] data, int dimension) {
        results = new ArrayList<Result>();
        double bestDist = 0;
        int bestLoc = -1;

        for (int p = 0; p < data.length - length + 1; p++) {
            double tempDist = Double.MAX_VALUE;
            for (int q = 0; q < data.length - length + 1; q++) {
                if (Math.abs(p - q) >= length && MathTool.distForMulti(data, p, q, length, dimension) < tempDist) {
                    tempDist = MathTool.distForMulti(data, p, q, length, dimension);
                }
            }
            if (tempDist > bestDist) {
                bestDist = tempDist;
                bestLoc = p;
            }
        }
        results.add(new Result(bestLoc, data[bestLoc]));
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(ArrayList<Result> results) {
        this.results = results;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
