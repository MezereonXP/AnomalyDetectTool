package Wavelet;

import Result.Result;
import Tool.DetectTool;

import java.util.List;

/**
 * @program: AnomalyDetectTool
 * @description: Using wavelet analysis to detect anomaly point
 * @author: mezereonxp Email: mezereonxp@gmail.com
 * @create: 2018-05-22 11:01
 **/
public class WaveletTool implements DetectTool {

    private List<Result> results;

    @Override
    public void timeSeriesAnalyse(double[] data) {

    }

    @Override
    public List<Result> getResults() {
        return this.results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }
}
