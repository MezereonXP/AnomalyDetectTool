package ESD;

import Tool.DetectTool;
import Tool.MathTool;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @program: GrubbsTool
 * @description: Grubbs method to detect anomaly point
 * @author: mezereonxp Email: mezereonxp@gmail.com
 * @create: 2018-05-03 15:08
 **/
public class GrubbsTool implements DetectTool{

  private double average;// 平均值
  private double stdDeviation;// 样本标准差
  private double[] G;// 可疑值
  private static final double G_MAX = 2.956;// 50个样本执行概率为95%的阈值

  public void timeSeriesAnalyse(double[] data) {
    average = MathTool.getAverageFromArray(data);
    stdDeviation = MathTool.getStdDeviation(data);
    G = new double[data.length];
    for (int i = 0; i < data.length; i++){
      G[i] = (data[i] - average)/stdDeviation;
      if (G[i]>G_MAX){
        System.out.println("Anomaly point! value is : "+data[i]);
      }
    }
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
