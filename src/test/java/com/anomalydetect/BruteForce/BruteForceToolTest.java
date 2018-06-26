package com.anomalydetect.BruteForce;

import com.anomalydetect.Tool.DisplayTool;
import com.anomalydetect.Tool.FileTool;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

public class BruteForceToolTest {

    private double[] data;

    @Before
    public void setUp() throws FileNotFoundException {
        data = FileTool.getData("data.json");
    }

    @Test
    public void timeSeriesAnalyse() {
        BruteForceTool bruteForceTool = new BruteForceTool(10);
        bruteForceTool.timeSeriesAnalyse(data);
        DisplayTool.showResult(bruteForceTool);
    }
}