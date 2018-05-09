package ReadJson;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class ItemsTest {

    private Items items;
    private static final double VALUE = 1.0;
    private static final double NEW_VALUE = 2.0;
    private static final int SIZE = 1;
    private static final int NEW_SIZE = 2;
    private static final String TIME_STAMP = "111400000000";
    @Before
    public void setUp() {
        ArrayList<Item> itemArrayList = new ArrayList<Item>();
        itemArrayList.add(new Item(TIME_STAMP, new Event(VALUE)));
        items = new Items(itemArrayList);
    }

    @Test
    public void getItems() {
        Assert.assertEquals(items.getItems().size(), SIZE);
    }

    @Test
    public void setItems() {
        ArrayList<Item> itemArrayList = new ArrayList<Item>();
        itemArrayList.add(new Item(TIME_STAMP, new Event(VALUE)));
        itemArrayList.add(new Item(TIME_STAMP, new Event(NEW_VALUE)));
        items.setItems(itemArrayList);
        Assert.assertEquals(items.getItems().size(), NEW_SIZE);
    }
}