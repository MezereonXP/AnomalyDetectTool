package Tool;

import BruteForce.BruteForceTool;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

public class DetectToolTest {

    private double[] data;

    @Before
    public void setUp() throws FileNotFoundException {
        data = FileTool.getData("data.json");
    }

    @Test
    public void timeSeriesAnalyse() {
        BruteForceTool bruteForceTool = new BruteForceTool(10);
        bruteForceTool.timeSeriesAnalyse(data);
    }

    @Test
    public void getResults() {
        BruteForceTool bruteForceTool = new BruteForceTool(10);
        bruteForceTool.timeSeriesAnalyse(data);
        DisplayTool.showResult(bruteForceTool);
    }
}