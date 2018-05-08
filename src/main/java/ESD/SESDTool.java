package ESD;

import Tool.DetectTool;

/**
 * @program: AnomalyDetectTool
 * @description: Seasonal Extreme Studentized Deviate
 * @author: mezereonxp Email: mezereonxp@gmail.com
 * @create: 2018-05-07 18:16
 **/
public class SESDTool implements DetectTool{

    private double t;// t统计量

    /**
     * constructor
     */
    SESDTool(){

    }

    public void timeSeriesAnalyse(double[] data) {

    }

    public double getT() {
        return t;
    }

    public void setT(double t) {
        this.t = t;
    }
}
