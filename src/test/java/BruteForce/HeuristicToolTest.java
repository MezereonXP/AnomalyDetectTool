package BruteForce;

import Tool.DisplayTool;
import Tool.FileTool;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

public class HeuristicToolTest {

    private double[] testData;

    @Before
    public void setUp() throws FileNotFoundException {
        testData = FileTool.getData("data.json");
    }

    @Test
    public void timeSeriesAnalyse() {
        HeuristicTool heuristicTool = new HeuristicTool(3);
        heuristicTool.timeSeriesAnalyse(testData);
        DisplayTool.showResult(heuristicTool);
    }
}