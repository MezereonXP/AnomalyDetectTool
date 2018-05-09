package LOF;

import Tool.FileTool;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Administrator on 2018/4/27.
 */
public class LOFDetectToolTest {

  public double[] testData;
  @Before
  public void setUp() throws Exception {
    testData = FileTool.getData("data.json");
  }

  @Test
  public void timeSeriesAnalyse() throws Exception {
    LOFDetectTool lofDetectTool = new LOFDetectTool(200, 20);
    lofDetectTool.timeSeriesAnalyse(testData);
  }

}