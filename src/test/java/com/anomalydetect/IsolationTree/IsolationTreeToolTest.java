package com.anomalydetect.IsolationTree;

import com.anomalydetect.Tool.DisplayTool;
import com.anomalydetect.Tool.FileTool;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

public class IsolationTreeToolTest {
    public double[] testData;

    @Before
    public void setUp() throws FileNotFoundException {
        testData = FileTool.getData("data.json");
    }

    @Test
    public void timeSeriesAnalyse() {
        IsolationTreeTool isolationTreeTool = new IsolationTreeTool();
        isolationTreeTool.timeSeriesAnalyse(testData);
        DisplayTool.showResult(isolationTreeTool);
    }
}