package com.anomalydetect.IsolationTree;

import com.anomalydetect.Tool.DisplayTool;
import com.anomalydetect.Tool.FileTool;
import org.junit.Before;
import org.junit.Test;
import java.io.FileNotFoundException;



public class IsolationTreeToolTest {
    public static int TEST_LENGTH = 100;
    public static int TEST_LONG_LENGTH = 4000;
    public double[] testData;
    public double[] testData2;
    public double[] testData3;

    @Before
    public void setUp() throws FileNotFoundException {
        testData = FileTool.getData("data.json");
        testData2 = new double[TEST_LENGTH];
        for (int i=0; i < TEST_LENGTH; i++) {
            testData2[i] = Math.random() - 0.5;
        }
        testData3 = new double[TEST_LONG_LENGTH];
        for (int i=0; i < TEST_LONG_LENGTH; i++) {
            testData3[i] = Math.random() - 0.5;
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
        System.out.println("Start test repeat value sequence ...");
        for (int i=0; i<100; i++) {
            isolationTreeTool.timeSeriesAnalyse(testData3);
        }
        DisplayTool.showResult(isolationTreeTool);
        System.out.println("Isolation Forest Test is Finished");
    }

}