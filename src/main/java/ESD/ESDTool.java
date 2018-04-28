package ESD;

import Tool.DetectTool;
import Tool.MathTool;

/**
 * @program: AnomalyDetectTool
 * @description: Extreme Studentized Deviate
 * @author: mezereonxp Email: mezereonxp@gmail.com
 * @create: 2018-04-28 11:41
 **/
public class ESDTool implements DetectTool{

    private double average;

    public void timeSeriesAnalyse(double[] data) {
        //TODO: 2018/4/28 实现ESD算法
        this.average = MathTool.getAverageFromArray(data);

    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }
}
