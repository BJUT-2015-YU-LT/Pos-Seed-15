package test;

import org.junit.Before;
import org.junit.Test;
import pos.ItemManager;

import static org.junit.Assert.assertEquals;

public class ItemManagerTest {
    ItemManager items;

    @Before
    public void setUp() throws Exception {
        items=new ItemManager();
        items.addItem("ITEM000000", "可口可乐", "瓶", 3.00);
        items.addItem("ITEM000000", "可口可乐", "瓶", 3.00);
        items.addItem("ITEM000001", "雪碧", "瓶", 3.00);
        items.addItem("ITEM000004", "电池", "个", 2.00);

    }

    @Test
    public void testTotal() throws Exception {
        Double result=3.00*2.0+3.0+2.0;
        assertEquals(result,items.total());

    }
}