package Tool;

import Result.Result;

import java.util.ArrayList;
import java.util.List;

/**
 * 异常检测的接口类
 * @author mezereon E-mail:mezereonxp@gmail.com
 * @since 18-4-12
 */
public interface DetectTool {

  /**
   * 对时间序列进行异常检测
   */
  void timeSeriesAnalyse(double[] data);

  List<Result> getResults();
}
