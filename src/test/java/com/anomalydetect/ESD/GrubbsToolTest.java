package com.anomalydetect.ESD;

import com.anomalydetect.Tool.DisplayTool;
import com.anomalydetect.Tool.FileTool;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

public class GrubbsToolTest {

    public double[] testData;

    @Before
    public void setUp() throws FileNotFoundException {
        testData = FileTool.getData("data.json");
    }

    @Test
    public void timeSeriesAnalyse() {
        GrubbsTool grubbsTool = new GrubbsTool();
        grubbsTool.timeSeriesAnalyse(testData);
        DisplayTool.showResult(grubbsTool);
    }
}