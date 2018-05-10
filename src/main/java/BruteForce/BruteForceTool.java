package BruteForce;

import Result.Result;
import Tool.DetectTool;
import Tool.MathTool;

import java.util.ArrayList;

/**
 * @program: AnomalyDetectTool
 * @description: Using Brute Force Algorithm to find anomaly subsequence
 * @author: mezereonxp Email: mezereonxp@gmail.com
 * @create: 2018-05-10 15:03
 **/
public class BruteForceTool implements DetectTool {

    private ArrayList<Result> results;

    private int length;

    BruteForceTool(int length) {
        this.length = length;
        results = new ArrayList<Result>();
    }

    public void timeSeriesAnalyse(double[] data) {

        double bestDist = 0;
        int bestLoc = -1;

        for (int p = 0; p < data.length - length + 1; p++) {
            double tempDist = Double.MAX_VALUE;
            for (int q = 0; q < data.length - length + 1; q++){
                if (Math.abs(p-q) >= length && dist(data, p, q, length) < tempDist){
                    tempDist = dist(data, p, q, length);
                }
            }
            if (tempDist > bestDist){
                bestDist = tempDist;
                bestLoc = p;
            }
        }
        results.add(new Result(bestLoc, data[bestLoc]));
    }

    private double dist(double[] data, int p, int q, int length) {
        double dist = 0;
        for (int i = 0;i < length; i++){
            dist += Math.pow(data[p+i]-data[q+i], 2);
        }
        return Math.sqrt(dist);
    }

    public ArrayList<Result> getResults() {
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
