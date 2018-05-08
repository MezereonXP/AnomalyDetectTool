package ESD;

import Result.Result;
import Tool.DisplayTool;
import Tool.FileTool;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

class ESDToolTest {

    public double[] testData;

    @BeforeEach
    void setUp() throws FileNotFoundException {
        testData = FileTool.getData("data.json");
    }

    @Test
    void timeSeriesAnalyse() {
        ESDTool esdTool = new ESDTool(10);
        esdTool.timeSeriesAnalyse(testData);
        DisplayTool.showResult(esdTool);
    }
}