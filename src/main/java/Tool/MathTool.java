package Tool;

/**
 * @program: AnomalyDetectTool
 * @description: The tool to do some useful calculations
 * @author: mezereonxp Email: mezereonxp@gmail.com
 * @create: 2018-04-28 16:38
 **/
public class MathTool {

  /**
   * 计算double数组的平均值
   */
  public static double getAverageFromArray(double[] array) {
    double sum = 0;
    for (double d : array) {
      sum += d;
    }
    return sum / array.length;
  }

  /**
   * 计算double数组的标准差
   */
  public static double getStdDeviation(double[] array) {
    double average = getAverageFromArray(array);
    double sum = 0;
    for (double d : array) {
      sum += Math.pow(d - average, 2);
    }
    return Math.sqrt(sum / (array.length - 1));
  }
}
