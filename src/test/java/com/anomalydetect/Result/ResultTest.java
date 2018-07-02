package com.anomalydetect.Result;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ResultTest {

    public Result result;
    public static final int INDEX = 1;
    public static final int NEW_INDEX = 2;
    public static final double VALUE = 2.0;
    public static final double NEW_VALUE = 3.0;
    public static final double DELTA = 0.0;

    @Before
    public void setUp() {
        result = new Result(INDEX, VALUE);
    }

    @Test
    public void getIndex() {
        Assert.assertEquals("Test getIndex of Result", result.getIndex(), INDEX);
    }

    @Test
    public void setIndex() {
        result.setIndex(NEW_INDEX);
        Assert.assertEquals("Test setIndex of Result", result.getIndex(), NEW_INDEX);
    }

    @Test
    public void getValue() {
        Assert.assertEquals(VALUE, result.getValue(), DELTA);
    }

    @Test
    public void setValue() {
        result.setValue(NEW_VALUE);
        Assert.assertEquals(NEW_VALUE, result.getValue(), DELTA);
    }
}