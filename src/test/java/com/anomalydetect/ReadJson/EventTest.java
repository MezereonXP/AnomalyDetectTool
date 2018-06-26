package com.anomalydetect.ReadJson;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EventTest {

    private Event event;
    private static final double VALUE = 1.0;
    private static final double NEW_VALUE = 2.0;
    private static final double DELTA = 0.0;

    @Before
    public void setUp() {
        event = new Event(VALUE);
    }

    @Test
    public void getTotal_count() {
        Assert.assertEquals(VALUE, event.getTotal_count(), DELTA);
    }

    @Test
    public void setTotal_count() {
        event.setTotal_count(NEW_VALUE);
        Assert.assertEquals(NEW_VALUE, event.getTotal_count(), DELTA);
    }
}