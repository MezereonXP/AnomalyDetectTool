package com.anomalydetect.IsolationTree;

import com.anomalydetect.Tool.DisplayTool;
import com.anomalydetect.Tool.FileTool;
import org.junit.Before;
import org.junit.Test;
import java.io.FileNotFoundException;



public class IsolationTreeToolTest {
    public static int TEST_LENGTH = 100;
    public double[] testData;
    public double[] testData2;

    @Before
    public void setUp() throws FileNotFoundException {
        testData = FileTool.getData("data.json");
        testData2 = new double[TEST_LENGTH];
        for (int i=0; i < 100; i++) {
            testData2[i] = Math.random() - 0.5;
        }
    }

    @Test
    public void timeSeriesAnalyse() {
        System.out.println("Isolation Forest Test is Started ...");
        IsolationTreeTool isolationTreeTool = new IsolationTreeTool();
        isolationTreeTool.timeSeriesAnalyse(testData);
        DisplayTool.showResult(isolationTreeTool);
        isolationTreeTool.timeSeriesAnalyse(testData2);
        DisplayTool.showResult(isolationTreeTool);
        System.out.println("Isolation Forest Test is Finished");
    }

}