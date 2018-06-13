package ESD;

import Tool.DisplayTool;
import Tool.FileTool;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

public class SESDToolTest {

    public double[] testData;

    @Before
    public void setUp() throws FileNotFoundException {
        testData = FileTool.getData("data.json");
    }

    @Test
    public void timeSeriesAnalyse() {
        SESDTool sesdTool = new SESDTool();
        sesdTool.timeSeriesAnalyse(testData);
        DisplayTool.showResult(sesdTool);
    }
}