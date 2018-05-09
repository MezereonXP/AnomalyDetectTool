package ReadJson;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ItemTest {

    private static final double VALUE = 1.0;
    private static final double NEW_VALUE = 2.0;
    private static final double DELTA = 0.0;
    private static final int SIZE = 1;
    private static final int NEW_SIZE = 2;
    private static final String TIME_STAMP = "111400000000";
    private static final String NEW_TIME_STAMP = "111400000001";
    private Item item;

    @Before
    public void setUp() {
        item = new Item(TIME_STAMP, new Event(VALUE));
    }

    @Test
    public void getTempstamp() {
        Assert.assertEquals(TIME_STAMP, item.getTempstamp());
    }

    @Test
    public void setTempstamp() {
        item.setTempstamp(NEW_TIME_STAMP);
        Assert.assertEquals(NEW_TIME_STAMP, item.getTempstamp());
    }

    @Test
    public void getEvent() {
        Assert.assertEquals(VALUE, item.getEvent().getTotal_count(), DELTA);
    }

    @Test
    public void setEvent() {
        item.setEvent(new Event(NEW_VALUE));
        Assert.assertEquals(NEW_VALUE, item.getEvent().getTotal_count(), DELTA);
    }
}