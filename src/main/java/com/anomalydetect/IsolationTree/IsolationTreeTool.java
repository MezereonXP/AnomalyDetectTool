package com.anomalydetect.IsolationTree;

import com.anomalydetect.Result.Result;
import com.anomalydetect.Tool.DetectTool;

import java.util.ArrayList;
import java.util.List;

public class IsolationTreeTool implements DetectTool {

    private int maxTreeNum = 100;
    private int maxSampling = 256;
    private double factor = 0.6f;

    private ArrayList<Result> results;
    private IsolationForest forest;

    public IsolationTreeTool() {
    }

    public IsolationTreeTool(int maxTreeNum, int maxSampling) {
        this.maxTreeNum = maxTreeNum;
        this.maxSampling = maxSampling;
    }

    @Override
    public void timeSeriesAnalyse(double[] data) {
        this.results = new ArrayList<Result>();
        IsolationForest tempForest = new IsolationForest(maxTreeNum, maxSampling);
        tempForest.createForest(data.clone());
        this.forest = tempForest;
        cutAnomaly(data, factor);
    }

    /**
     * 选出所有异常值
     *
     * @param data
     * @param factor
     */
    public void cutAnomaly(double[] data, double factor) {
        for (int i = 0; i < data.length; i++) {
            if (this.forest.searchForest(data[i]) > factor) {
                this.results.add(new Result(i, data[i]));
            }
        }
    }

    @Override
    public List<Result> getResults() {
        return results;
    }

    public int getMaxSampling() {
        return maxSampling;
    }

    public void setMaxSampling(int maxSampling) {
        this.maxSampling = maxSampling;
    }

    public int getMaxTreeNum() {
        return maxTreeNum;
    }

    public void setMaxTreeNum(int maxTreeNum) {
        this.maxTreeNum = maxTreeNum;
    }

    public double getFactor() {
        return factor;
    }

    public void setFactor(double factor) {
        this.factor = factor;
    }
}
