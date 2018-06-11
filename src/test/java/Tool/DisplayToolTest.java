package Tool;

import BruteForce.BruteForceTool;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

public class DisplayToolTest {

    private double[] data;

    @Before
    public void setUp() throws FileNotFoundException {
        data = FileTool.getData("data.json");
    }

    @Test
    public void showResult() {
        BruteForceTool bruteForceTool = new BruteForceTool(10);
        bruteForceTool.timeSeriesAnalyse(data);
        DisplayTool.showResult(bruteForceTool);
    }
}