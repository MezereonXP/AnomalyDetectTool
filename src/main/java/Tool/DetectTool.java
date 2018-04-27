package Tool;

/**
 * 异常检测的接口类
 *
 * Created by Mezereon on 2018/4/27.
 */
public interface DetectTool {

  /**
   * 对时间序列进行异常检测
   */
  void timeSeriesAnalyse(double[] data);
}
