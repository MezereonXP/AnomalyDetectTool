package ExponentialMoving;

import Tool.DisplayTool;
import Tool.FileTool;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Administrator on 2018/4/27.
 */
public class HoltWintersToolTest {

    private static final double ALPHA = 0.1;
    private static final double STEP = 0.01;
    private static final int TIMES = 1000;

    public double[] testData;

    @Before
    public void setUp() throws Exception {
        testData = FileTool.getData("data.json");
    }

    @Test
    public void timeSeriesAnalyse() throws Exception {
        HoltWintersTool holtWintersTool = new HoltWintersTool(ALPHA, STEP, TIMES);
        holtWintersTool.timeSeriesAnalyse(testData);
        DisplayTool.showResult(holtWintersTool);
    }

}