package com.anomalydetect.ESD;

import com.anomalydetect.Tool.DisplayTool;
import com.anomalydetect.Tool.FileTool;
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