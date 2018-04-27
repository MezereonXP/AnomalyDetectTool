package ExponentialMoving;

import static org.junit.Assert.*;

import Tool.FileTool;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Administrator on 2018/4/27.
 */
public class HoltWintersToolTest {

  public double[] testData;

  @Before
  public void setUp() throws Exception {
    testData = FileTool.getData("data.json");
  }

  @Test
  public void timeSeriesAnalyse() throws Exception {
    double alpha = 0.1;
    double step = 0.01;
    int times = 1000;
    HoltWintersTool holtWintersTool = new HoltWintersTool(alpha, step, times);
    holtWintersTool.timeSeriesAnalyse(testData);
  }

}