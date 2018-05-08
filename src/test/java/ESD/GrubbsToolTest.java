package ESD;

import Result.Result;
import Tool.DisplayTool;
import Tool.FileTool;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

class GrubbsToolTest {

    public double[] testData;

    @BeforeEach
    void setUp() throws FileNotFoundException {
        testData = FileTool.getData("data.json");
    }

    @Test
    void timeSeriesAnalyse() {
        GrubbsTool grubbsTool = new GrubbsTool();
        grubbsTool.timeSeriesAnalyse(testData);
        DisplayTool.showResult(grubbsTool);
    }
}