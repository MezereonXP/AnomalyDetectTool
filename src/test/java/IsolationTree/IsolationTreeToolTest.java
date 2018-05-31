package IsolationTree;

import Tool.DisplayTool;
import Tool.FileTool;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

public class IsolationTreeToolTest {
    public double[] testData;

    @Before
    public void setUp() throws FileNotFoundException {
        testData = FileTool.getData("data.json");
    }

    @Test
    public void timeSeriesAnalyse() {
        IsolationTreeTool isolationTreeTool =  new IsolationTreeTool();
        isolationTreeTool.timeSeriesAnalyse(testData);
        DisplayTool.showResult(isolationTreeTool);
    }
}