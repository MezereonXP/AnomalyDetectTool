package ESD;

import Tool.DisplayTool;
import Tool.FileTool;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

public class ESDToolTest {

    public double[] testData;

    @Before
    public void setUp() throws FileNotFoundException {
        testData = FileTool.getData("data.json");
    }

    @Test
    public void timeSeriesAnalyse() {
        ESDTool esdTool = new ESDTool(10);
        esdTool.timeSeriesAnalyse(testData);
        DisplayTool.showResult(esdTool);
    }
}