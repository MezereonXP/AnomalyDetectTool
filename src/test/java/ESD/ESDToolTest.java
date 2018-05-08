package ESD;

import Result.Result;
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
        ESDTool esdTool = new ESDTool();
        esdTool.timeSeriesAnalyse(testData);
        for (Result result : esdTool.getResults()) {
            System.out.print(result.getIndex()+", ");
        }
        System.out.println();
        for (Result result : esdTool.getResults()) {
            System.out.print(result.getValue()+", ");
        }
    }
}