package com.anomalydetect.Tool;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;

public class FileToolTest {

    private static final int LENGTH = 360;

    @Test
    public void getData() throws FileNotFoundException {
        double[] data = FileTool.getData("data.json");
        Assert.assertEquals(data.length, LENGTH);
    }
}