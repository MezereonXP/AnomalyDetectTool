package ESD;

import Result.Result;
import Tool.DetectTool;
import Tool.MathTool;

import java.util.ArrayList;

/**
 * @program: GrubbsTool
 * @description: Grubbs method to detect anomaly point
 * @author: mezereonxp Email: mezereonxp@gmail.com
 * @create: 2018-05-03 15:08
 **/
public class GrubbsTool implements DetectTool {

    private double average;// 平均值
    private double stdDeviation;// 样本标准差
    private double[] G;// 可疑值
    private double G_MAX = 3.754;// 100个样本执行概率为99.50%的阈值
    private ArrayList<Result> results;// 结果集

    public GrubbsTool() {
    }

    public GrubbsTool(double g) {
        G_MAX = g;
    }

    public void timeSeriesAnalyse(double[] data) {
        results = new ArrayList<Result>();
        average = MathTool.getAverageFromArray(data);
        stdDeviation = MathTool.getStdDeviation(data);
        G = new double[data.length];
        for (int i = 0; i < data.length; i++) {
            G[i] = (data[i] - average) / stdDeviation;
            if (G[i] > G_MAX) {
                results.add(new Result(i, data[i]));
                System.out.println("Anomaly point! value is : " + data[i]);
            }
        }
    }

    public ArrayList<Result> getResults() {
        return this.results;
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
}
